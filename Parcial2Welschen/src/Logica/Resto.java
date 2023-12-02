package Logica;

import java.sql.SQLException;
import java.text.ParseException;
import ConexionBD.MesaAD;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Resto {

	private int id;
	private String nombre;
	private String calle;
	private String ciudad;
	private ArrayList<Mesa> listaMesas;
	private ArrayList<Reserva> listaReservas;

	private static Scanner input = new Scanner(System.in);

	public Resto() {
		this.listaMesas = new ArrayList<Mesa>();
		this.listaReservas = new ArrayList<Reserva>();
	}
	public Resto(String nombre, String calle, String ciudad, int id) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.calle = calle;
		this.ciudad = ciudad;
		this.listaMesas = new ArrayList<Mesa>();
		this.listaReservas = new ArrayList<Reserva>();
	}

	public int getId() {
		//System.out.println(id);
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCalle() {
		return calle;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public ArrayList<Mesa> getListaMesas() {
		return listaMesas;
	}
	public ArrayList<Reserva> getListaReservas() {
		return listaReservas;
	}
	public void setListaReservas(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}
	public void setListaMesas(ArrayList<Mesa> listaMesas) {
		this.listaMesas = listaMesas;
	}
	public void mostrarMesas() {
		if (listaMesas.isEmpty()) {
			System.out.println("No hay mesas cargadas");
		}else {
			for (int i = 0; i <listaMesas.size(); i++) {
				System.out.println(listaMesas.get(i));
			}
		}
	}
	public void mostrarMesas(String est) {
		if (listaMesas.isEmpty()) {
			System.out.println("No hay mesas cargadas");
		}else {
			for (int i = 0; i <listaMesas.size(); i++) {
				if(listaMesas.get(i).estadoActual()==est) {
					System.out.println(listaMesas.get(i));
				}
			}System.out.println("En el caso de no mostrarse datos, no existen mesas actualmente en el estado buscado");
		}
	}

	public void mostrarMesas(String est, String fecha) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date date=null ;
		try {
			date = formatoFecha.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (listaMesas.isEmpty()) {
			System.out.println("No hay mesas cargadas");
		}else { ArrayList<Mesa> mesas = new ArrayList<>();

		for(Mesa mesa : getListaMesas()) {

			boolean reservadaFecha = false;

			for(Reserva reserva : getListaReservas()) {

				if(reserva.getFecha().equals(date)) {
					reservadaFecha = true;
					break; 
				}
			}

			if(reservadaFecha || fecha == null) {
				if(mesa.estadoActual() == est) {
					mesas.add(mesa);
				}
			}
		}

		System.out.println("Mesas en estado " + est + " para la fecha " + fecha);
		if (mesas.isEmpty()) {
			System.out.println("Todas las mesas estan libres para esta fecha");
		}else {
			for(Mesa mesa : mesas) {
				System.out.println("Mesa " + mesa.getNroMesa()); 
			}
		}
		}
	}
	public void mostrarCapacidad() {

		int capacidad = 0;
		int libre = 0; 
		int ocupada = 0;
		int reservada = 0;

		for(Mesa mesa : getListaMesas()) {
			capacidad += mesa.getCapacidad();

			if(mesa.estadoActual() == "Liberada") {
				libre += mesa.getCapacidad();
			}
			else if(mesa.estadoActual() == "Ocupada") {
				ocupada += mesa.getCapacidad(); 
			} 
			else { 
				reservada += mesa.getCapacidad();
			}
		}
		System.out.println("Capacidad total: " + capacidad);
		System.out.println("Libres: " + libre);
		System.out.println("Ocupadas: " + ocupada);
		System.out.println("Reservadas: " + reservada);
	}
	public void mostrarCapacidad(String fecha) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		int capacidad = 0; 
		int reservada = 0;

		for(Mesa mesa : getListaMesas()) {
			capacidad += mesa.getCapacidad();
			boolean reservadaFecha = false;
			for(Reserva r : getListaReservas()) {
				try {
					date = formatoFecha.parse(fecha);
				} catch (ParseException e) {

					e.printStackTrace();
				}
				if(r.getFecha().equals(date)) {
					reservadaFecha = true;
				} if(reservadaFecha) {
					reservada += mesa.getCapacidad();
				}
			}
		}
		int libre = capacidad - reservada;
		System.out.println("Capacidad total: " + capacidad);
		System.out.println("Libres: " + libre);
		System.out.println("Reservadas: " + reservada);
	}
	public void mostrarInfo() {
		System.out.println("Nombre del restaurante " + getNombre());
		System.out.println("Calle: " + getCalle());
		System.out.println("Ciudad: " + getCiudad());
		mostrarMesas();
	}
	public void mostrarInfo(String fecha) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		System.out.println("Nombre del restaurante " + getNombre());
		System.out.println("Calle: " + getCalle());
		System.out.println("Ciudad: " + getCiudad());
		System.out.println("\nMesas:");
		List<Mesa> mesasDispo = new ArrayList<>();
		List<Mesa> mesasReser = new ArrayList<>();
		if (getListaReservas().size()==0) {
			for(Mesa mesa : getListaMesas())
				System.out.println("Mesa " + mesa.getNroMesa() + " libre - Capacidad: " + mesa.getCapacidad());
		}
		else{
			for(Mesa mes : getListaMesas()) {

				for(Reserva r : getListaReservas()) {
					try {
						date = formatoFecha.parse(fecha);
					} catch (ParseException e) {

						e.printStackTrace();
					}
					if(r.getFecha().equals(date) && r.getMesa().getNroMesa()==mes.getNroMesa()) {
						mesasReser.add(mes);
					}
				}
			}
			for(Mesa m : mesasReser) {
				System.out.print("Mesa " + m.getNroMesa() + " - Capacidad: " + m.getCapacidad()+" - fecha "+fecha+ " RESERVADA\n");
			}
			for(Mesa mesa : getListaMesas()) {
				for (Mesa rese : mesasReser) {
					if(!mesasReser.contains(mesa)) {
						if(!mesasDispo.contains(mesa))
							mesasDispo.add(mesa);
					}
				}
			}
			for(Mesa m : mesasDispo) {
				System.out.print("Mesa " + m.getNroMesa() + " - Capacidad: " + m.getCapacidad()+" - fecha "+fecha+ " LIBERADA\n");
			}
		}

	}

	public void mostrarInfo(String fecha, int cap) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		List<Mesa> mesasDispo = new ArrayList<>();
		List<Mesa> mesasReser = new ArrayList<>();
		if (getListaReservas().size()==0) {
			for(Mesa mesa : getListaMesas())
				System.out.println("Mesa " + mesa.getNroMesa() + " libre - Capacidad: " + mesa.getCapacidad());
		}
		else{
			for(Mesa mes : getListaMesas()) {

				for(Reserva r : getListaReservas()) {
					try {
						date = formatoFecha.parse(fecha);
					} catch (ParseException e) {

						e.printStackTrace();
					}
					if(r.getFecha().equals(date) && r.getMesa().getNroMesa()==mes.getNroMesa() && mes.getCapacidad()>=cap) {
						mesasReser.add(mes);
					}
				}
			}
			for(Mesa m : mesasReser) {
				System.out.print("Mesa " + m.getNroMesa() + " - Capacidad: " + m.getCapacidad()+" - fecha "+fecha+ " RESERVADA\n");
			}
			for(Mesa mesa : getListaMesas()) {
				for (Mesa rese : mesasReser) {
					if(!mesasReser.contains(mesa) && mesa.getCapacidad()>=cap) {
						if(!mesasDispo.contains(mesa))
							mesasDispo.add(mesa);
					}
				}
			}
			for(Mesa m : mesasDispo) {
				System.out.print("Mesa " + m.getNroMesa() + " - Capacidad: " + m.getCapacidad()+" - fecha "+fecha+ " LIBERADA\n");
			}
		}

	}

	public void nuevaMesa() {
		System.out.println("Ingrese la capacidad");
		int cap = input.nextInt();
		int consu = 0;
		System.out.println("Ingrese la cantidad de mesas");
		int cant =input.nextInt();
		for (int i = 0; i < cant; i++) {
			Mesa mesa = new Mesa(cap, consu);
			listaMesas.add(mesa);
		}
	}
	public void nuevaMesa(int cap, int cant) {
		for (int i = 0; i < cant; i++) {
			Mesa mesa = new Mesa(cap, 0);
			listaMesas.add(mesa);
		}
	}
	public void eliminarMesa() {
		System.out.println("Ingrese el numero de mesa que quiere dar de alta (lo puede consultar en el menú): ");
		int nro = input.nextInt();
		int ind = -1;
		for(int i = 0; i < listaMesas.size(); i++) {
			Mesa m = listaMesas.get(i);
			try {
				if(m.getNroMesa() == nro) {
					ind=i;

				}if (ind<0) {
					System.out.println("El numero de mesa ingresado es incorrecto");

				}else if(listaMesas.get(i).estadoActual()!="Reservada"){
					throw new MesaException("No se puede eliminar una mesa reservada");
				}else {
					listaMesas.remove(i);
					System.out.println("Mesa eliminada correctamente");
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void altaMesa() {
		System.out.println("Lista de mesas: ");
		mostrarMesas();
		System.out.println("Ingrese el numero de mesa que quiere ocupar: ");
		int nro = input.nextInt();
		for(Mesa mesa : getListaMesas()) {
			if(mesa.getNroMesa() == nro) {
				mesa.ocupar();
			}
		}
	}
	public void bajaMesa() {
		System.out.println("Lista de mesas: ");
		mostrarMesas();
		System.out.println("Ingrese el numero de mesa que quiere liberar: ");
		int nro = input.nextInt();
		for(Mesa mesa : getListaMesas()) {
			if(mesa.getNroMesa() == nro) {
				mesa.liberar(); 
			}
		} 
	}
	public void reservarMesa() {
		System.out.println("Lista de mesas: ");
		mostrarMesas();
		System.out.println("Ingrese el numero de mesa que quiere reservar: ");
		int nro = input.nextInt();
		for(Mesa mesa : getListaMesas()) {
			if(mesa.getNroMesa() == nro) {
				mesa.reservar(); 
			}
		} 
	}
	public void reservarMesa(String fecha) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		List<Mesa> mesasDispo = new ArrayList<>();
		List<Mesa> mesasReser = new ArrayList<>();
		System.out.println("Ingrese el numero de mesa que quiere reservar: ");
		int nro = input.nextInt();
		input.nextLine();
		System.out.println("Ingrese su nombre y apellido:");
		String nomape = input.nextLine();
		System.out.println("Ingrese cantidad de comensales:");
		int comen = input.nextInt();
		for(Mesa mes : getListaMesas()) {
			for(Reserva r : getListaReservas()) {
				try {
					date = formatoFecha.parse(fecha);
				} catch (ParseException e) {

					e.printStackTrace();
				}
				if(r.getFecha().equals(date) && r.getMesa().getNroMesa()==mes.getNroMesa()) {
					mesasReser.add(mes);
				}
			}
		}
		for(Mesa mesa : getListaMesas()) {
			for (Mesa rese : mesasReser) {
				if(!mesasReser.contains(mesa)) {
					if(!mesasDispo.contains(mesa))
						mesasDispo.add(mesa);
				}
			}
		}
		for(Mesa mesa : getListaMesas()) {
			if(mesa.getNroMesa()==nro && mesasDispo.contains(mesa)) {
				Reserva reserv = new Reserva(date, nomape, comen, mesa);
				listaReservas.add(reserv);
				System.out.println("Reserva guardada exitosamente \n");
			}
		}
	}
	public void reservarMesa(String fecha, int cap) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		List<Mesa> mesasDispo = new ArrayList<>();
		List<Mesa> mesasReser = new ArrayList<>();
		System.out.println("Ingrese el numero de mesa que quiere reservar: ");
		int nro = input.nextInt();
		input.nextLine();
		System.out.println("Ingrese su nombre y apellido:");
		String nomape = input.nextLine();
		for(Mesa mes : getListaMesas()) {
			for(Reserva r : getListaReservas()) {
				try {
					date = formatoFecha.parse(fecha);
				} catch (ParseException e) {

					e.printStackTrace();
				}
				if(r.getFecha().equals(date) && r.getMesa().getNroMesa()==mes.getNroMesa()) {
					mesasReser.add(mes);
				}
			}
		}
		for(Mesa mesa : getListaMesas()) {
			for (Mesa rese : mesasReser) {
				if(!mesasReser.contains(mesa)) {
					if(!mesasDispo.contains(mesa))
						mesasDispo.add(mesa);
				}
			}
		}
		for(Mesa mesa : getListaMesas()) {
			if(mesa.getNroMesa()==nro && mesasDispo.contains(mesa)) {
				Reserva reserv = new Reserva(date, nomape, cap, mesa);
				listaReservas.add(reserv);
				System.out.println("Reserva guardada exitosamente \n");
			}
		}
	}
	public void guardarMesas() {
		MesaAD mesaad = new MesaAD();
		for(Mesa mesa : getListaMesas()) {
			try {
				mesaad.guardarMesas(mesa, id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<Mesa> mesasDisponibles(int cant, Date date) {
		ArrayList<Mesa> mDispo = new ArrayList<>();
		for (Mesa mesa : listaMesas) {
			if(mesa.getCapacidad()>=cant) {
				if (mesaDisponible(mesa, date)==true){
					mDispo.add(mesa);
				}
			}	
		}return mDispo;

	}
	public boolean mesaDisponible(Mesa mesa, Date date) {
		for (Reserva rese : listaReservas) {
			if (rese.getFecha().equals(date) && rese.getMesa().equals(mesa)) {
				return false;
			}
		}return true;
	}
	public ArrayList<Mesa> mesasDisponibles(int cant) {
		ArrayList<Mesa> mDispo = new ArrayList<>();
		for (Mesa mesa : listaMesas) {
			if(mesa.getCapacidad()>=cant && mesa.estadoActual()=="Liberada") {
				mDispo.add(mesa);
			}
		}return mDispo;
	}
	public Mesa getMesa(int nroMesa) {
		Mesa m = null;
		for (Mesa mesa : listaMesas) {
			if(nroMesa == mesa.getNroMesa()) {
				m=mesa;
			}
		}
		return m;
	}
	public void guardarReserva(Reserva rese) {
		this.listaReservas.add(rese);

	}
	public ArrayList<Mesa> mesasOcupadas() {
		ArrayList<Mesa> mOcup = new ArrayList<>();
		for (Mesa mesa : listaMesas) {
			if(mesa.estadoActual()=="Ocupada") {
				mOcup.add(mesa);
			}
		}return mOcup;
	}
	public ArrayList<Mesa> mesasLiberadas() {
		ArrayList<Mesa> mLib = new ArrayList<>();
		for (Mesa mesa : listaMesas) {
			if(mesa.estadoActual()=="Liberada") {
				mLib.add(mesa);
			}
		}return mLib;
	}
	public ArrayList<Mesa> mesasDisponibles() {
		ArrayList<Mesa> mLib = new ArrayList<>();
		for (Mesa mesa : listaMesas) {
			mLib.add(mesa);
		}return mLib;
	}
	public ArrayList<Mesa> mesasReservadas(String fecha) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date= null;
		try {
			date = format.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ArrayList<Mesa> mLibres = new ArrayList<>();
		int nume=-1;
		Mesa m;
		for (Reserva mesa : listaReservas) {

			if (date.equals(mesa.getFecha()))
				nume = mesa.getMesa().getNroMesa();
			m = getMesa(nume);
			mLibres.add(m);
		}return mLibres;
	}

	public void top3ConsumoMesas() {
		List<Mesa> mesas = getListaMesas();

		mesas.sort((m1, m2) -> Double.compare(m2.getConsumo(), m1.getConsumo()));

		List<Mesa> top3 = mesas.stream()
				.limit(3)
				.collect(Collectors.toList());

		top3.forEach(m -> System.out.println("Mesa :"+m.getNroMesa() + " - Consumo: " + m.getConsumo()));
	}
	public void mostrarMesasXEstado() {
		List<Mesa> mesas = getListaMesas();

		List<Mesa> mesasLiberadas = mesas.stream()
				.filter(mesa -> mesa.estadoActual().equals("Liberada"))
				.collect(Collectors.toList());

		List<Mesa> mesasOcupadas = mesas.stream()
				.filter(mesa -> mesa.estadoActual().equals("Ocupada")) 
				.collect(Collectors.toList());

		List<Mesa> mesasReservadas = mesas.stream()
				.filter(mesa -> mesa.estadoActual().equals("Reservada"))
				.collect(Collectors.toList());

		/*	Map<String, List<Mesa>> mesasPorEstado = mesas.stream()
		    .collect(Collectors.groupingBy(Mesa::estadoActual));

		List<Mesa> mesasLiberadas = mesasPorEstado.get("Liberada");
		List<Mesa> mesasOcupadas = mesasPorEstado.get("Ocupada"); 
		List<Mesa> mesasReservadas = mesasPorEstado.get("Reservada");*/

		System.out.println("Mesas liberadas: " + mesasLiberadas); 
		System.out.println("Mesas ocupadas: " + mesasOcupadas);
		System.out.println("Mesas reservadas: " + mesasReservadas);
	}
}
