package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import ConexionBD.AccesoDatos;
import ConexionBD.MesaAD;
import ConexionBD.ReservaAD;
import ConexionBD.RestoAD;
import Logica.Mesa;
import Logica.MesaException;
import Logica.Reserva;
import Logica.Resto;

public class Control {
	private Resto resto;
	private MesaAD mesaad;
	private ArrayList<Resto> listResto;
	private RestoAD restoad;
	private ReservaAD reservaad;
	
	AccesoDatos ad = new AccesoDatos();
	Connection con;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	public Control() {
		this.restoad = new RestoAD();
		this.listResto = restoad.traerResto();
		this.mesaad = new MesaAD();
		this.reservaad = new ReservaAD(mesaad);	
	}
	public void setResto(Resto resto) {
		this.resto = resto;
	}
	public void RellenarCombo(String tabla, String valor, JComboBox<String> combo) {
		String sql = "SELECT * FROM "+ tabla;
		try {
			con = ad.abrirConexion();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			combo.addItem(rs.getString(valor));
		}
		}catch(SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "ERROR" +e.toString());
		}finally {
			ad.cerrarConexion();
	}
	}
	public void setearResto(String nom) {
		for (Resto r : listResto) {
		    if (nom.equals(r.getNombre())) {
		    	setResto(r);
		    	this.resto.setListaMesas(mesaad.buscarMesaidResto(r.getId()));
		    	this.resto.setListaReservas(reservaad.traerReservas(r.getId()));
		    }
		}
	}
	public List<Mesa> verDisponibles(int cant, String fecha) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = format.parse(fecha);
			ArrayList<Mesa> mDisp =resto.mesasDisponibles(cant, date);
			if(mDisp.isEmpty()) {
				String mensaje="Disculpe, no contamos con disponibilidad para esa fecha o cantidad de comensales, quizas puede reservar dos o mas mesas.";
				JOptionPane.showMessageDialog(null, mensaje, "Reserva", JOptionPane.INFORMATION_MESSAGE);
			}
			List<Mesa> mesas = new ArrayList<>();
			for(Mesa mesa: mDisp) {
			 mesas.add(mesa); 
				}
			return mesas;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}	
	}
	public void reservarMesa(int cant, String fecha, String nombre, int mesa) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date= null;
		try {
			date = format.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Mesa m = resto.getMesa(mesa);
		Reserva reserva = new Reserva(date, nombre, cant, m);
		resto.guardarReserva(reserva);
		reservaad.guardarReserva(cant, date, nombre, mesa);
		
	}
	public List<Mesa> verDisponibles(int cant) {
		ArrayList<Mesa> mDisp =resto.mesasDisponibles(cant);
		if(mDisp.isEmpty()) {
			String mensaje="Disculpe, no contamos con disponibilidad para esa fecha o cantidad de comensales, quizas puede reservar dos o mas mesas.";
			JOptionPane.showMessageDialog(null, mensaje, "Reserva", JOptionPane.INFORMATION_MESSAGE);
		}
		List<Mesa> mesas = new ArrayList<>();
		for(Mesa mesa: mDisp) {
		 mesas.add(mesa); 
			}
		return mesas;
	}
	public void reservarMesa(int mesa) {
	Mesa m =resto.getMesa(mesa);
	m.reservar();
	mesaad.cambiarEstado("Reservada",mesa);
}
	public List<Mesa> verOcupadas() {
		ArrayList<Mesa> mOcu =resto.mesasOcupadas();
		if(mOcu.isEmpty()) {
			String mensaje="No hay mesas ocupadas actualmente";
			JOptionPane.showMessageDialog(null, mensaje, "Mesas ocupadas", JOptionPane.INFORMATION_MESSAGE);
		}
		List<Mesa> mesas = new ArrayList<>();
		for(Mesa mesa: mOcu) {
		 mesas.add(mesa); 
			}
		return mesas;
	}
	public void liberarMesa(double cons, int nMesa) {
		Mesa m =resto.getMesa(nMesa);
		m.liberar();
		mesaad.cambiarEstado(cons, nMesa, m.estadoActual());
		
	}
	public List<Mesa> verLiberadas() {
		ArrayList<Mesa> mLib =resto.mesasLiberadas();
		if(mLib.isEmpty()) {
			String mensaje="No hay mesas liberadas actualmente";
			JOptionPane.showMessageDialog(null, mensaje, "Mesas liberadas", JOptionPane.INFORMATION_MESSAGE);
		}
		List<Mesa> mesas = new ArrayList<>();
		for(Mesa mesa: mLib) {
		 mesas.add(mesa); 
			}
		return mesas;
	}
	public void ocuparMesa(int mesa) {
		Mesa m =resto.getMesa(mesa);
		m.ocupar();
		mesaad.cambiarEstado(mesa, m.estadoActual());
		
	}
	public ArrayList<Mesa> verDisponibles() {
		ArrayList<Mesa> mDisp =resto.mesasDisponibles();
		if(mDisp.isEmpty()) {
			String mensaje="No hay mesas cargadas";
			JOptionPane.showMessageDialog(null, mensaje, "Mesas", JOptionPane.INFORMATION_MESSAGE);
		}
		ArrayList<Mesa> mesas = new ArrayList<>();
		for(Mesa mesa: mDisp) {
		 mesas.add(mesa); 
			}
		return mesas;
	}
	public ArrayList<Mesa> verReservadasXFecha(String fecha) {
		ArrayList<Mesa> mDisp =resto.mesasReservadas(fecha);
		ArrayList<Mesa> mesasReservadas = new ArrayList<>();
		for(Mesa mesa: mDisp) {
		 mesasReservadas.add(mesa); 
			}return mesasReservadas;
	}
	public ArrayList<Mesa> verDisponiblesXFecha(String fecha) {
		ArrayList<Mesa> mDisp =resto.mesasReservadas(fecha);
		ArrayList<Mesa> MesasReservadas = new ArrayList<>();
		for(Mesa mesa: mDisp) {
		 MesasReservadas.add(mesa); 
			}
		ArrayList<Mesa> todasLasMesas = verDisponibles();
		ArrayList<Mesa> mesasDisponibles = new ArrayList<>();
		if(MesasReservadas.isEmpty()) {
			
		}else {
		for(Mesa mesa : todasLasMesas) {

			  boolean estaReservada = false;
			  for(Mesa reservada : MesasReservadas) {
				
				  if(reservada.getNroMesa()== mesa.getNroMesa() ) {
			      estaReservada = true;
			    
				}
			  if(!estaReservada) {
			    mesasDisponibles.add(mesa); 
			  }
			  }
			}
		return mesasDisponibles;
		}return todasLasMesas;
		}
	
}