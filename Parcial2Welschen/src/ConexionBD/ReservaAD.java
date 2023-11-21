package ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Logica.Reserva;
import Logica.Resto;

public class ReservaAD {
	private MesaAD mesa;
	
	AccesoDatos ad = new AccesoDatos();
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	
	public ReservaAD(MesaAD mesa) {
		  this.mesa = mesa;
	  }
	
	
	/*public void listarReservas(Connection con, JTable tabla) {
		DefaultTableModel model;
		String [] columnas = {"ID", "FECHA", "NOMBRE Y APELLIDO", "CANTIDAD", "MESA" };
		model = new DefaultTableModel(null, columnas);
		
		String sql = "SELECT * FROM reserva";
		
		String [] filas = new String [5];
			
		try {
			con = ad.abrirConexion();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				for (int i = 0; i<5; i++) {
					filas[i] = rs.getString(i+1);
				}model.addRow(filas);
			}tabla.setModel(model);
		}catch (Exception e){
		}
	}*/

	public ArrayList<Reserva> traerReservas(int idResto) {
		ArrayList<Reserva> reserva = new ArrayList<>();
	
		 String sql = "SELECT r.idres, r.fecha, r.nombreapellido, r.cantcomensales, m.nromesa FROM reserva r INNER JOIN mesa m ON r.nromesa = m.nromesa WHERE m.idresto = ?";

		  try {
			con = ad.abrirConexion();
			pst = con.prepareStatement(sql);
			pst.setInt(1, idResto);
			rs = pst.executeQuery();
		    while (rs.next()) {
		      Reserva res = new Reserva();
		      res.setIdRes(rs.getInt("idres"));
		      res.setFecha(rs.getDate("fecha"));
		      res.setNombreApellido(rs.getString("nombreapellido"));
		      res.setCantComensales(rs.getInt("cantcomensales"));
		      res.setMesa(mesa.buscarMesa(rs.getInt("nromesa")));

		      reserva.add(res);
		    }
		  } catch (SQLException e) {
		    e.printStackTrace();
		  } finally {
		    ad.cerrarConexion();
		  }
		  return reserva;
		}


	public void guardarReserva(int cant, Date date, String nombre, int nummesa) {
		String sql = "INSERT INTO reserva (fecha ,nombreapellido, cantcomensales, nromesa) VALUES (?, ?, ?, ?)";
		try {
			con = ad.abrirConexion();
			pst = con.prepareStatement(sql);
			java.sql.Date dateSQL = new java.sql.Date(date.getTime());
			pst.setDate(1, dateSQL);
			pst.setString(2, nombre);
			pst.setInt(3, cant);
			pst.setInt(4, nummesa);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
			
		}finally {
			ad.cerrarConexion();
		}
	}
		
	}


