package Logica;

import java.sql.SQLException;
import java.text.ParseException;
import ConexionBD.MesaAD;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Resto {
	private static int cont = 0;
	private int id;
	private String nombre;
	private String calle;
	private String ciudad;
	private ArrayList<Mesa> listaMesas;
	private ArrayList<Reserva> listaReservas;
	
	
	private static Scanner input = new Scanner(System.in);

	public Resto() {
		
	}
	public Resto(String nombre, String calle, String ciudad) {
		super();
		cont++;
		this.id=cont;
		this.nombre = nombre;
		this.calle = calle;
		this.ciudad = ciudad;
		this.listaMesas = new ArrayList<Mesa>();
		this.listaReservas = new ArrayList<Reserva>();
	}
	public int getId() {
		System.out.println(id);
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
	public void mostrarMesas(Resto resto, String est, String fecha) {
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
		
		  for(Mesa mesa : resto.getListaMesas()) {

		    boolean reservadaFecha = false;
		    
		    for(Reserva reserva : mesa.getListaReservas()) {
		    	
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
		  // Mostrar las mesas encontradas
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
	public void mostrarCapacidad(Resto resto) {

		  int capacidad = 0;
		  int libre = 0; 
		  int ocupada = 0;
		  int reservada = 0;

		  for(Mesa mesa : resto.getListaMesas()) {
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
	public void mostrarCapacidad(Resto resto,String fecha) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		  int capacidad = 0; 
		  int reservada = 0;

		  for(Mesa mesa : resto.getListaMesas()) {
		    capacidad += mesa.getCapacidad();
		    boolean reservadaFecha = false;
		    for(Reserva r : mesa.getListaReservas()) {
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
	public void mostrarInfo(Resto resto) {
		System.out.println("Nombre del restaurante " + resto.getNombre());
	    System.out.println("Calle: " + resto.getCalle());
	    System.out.println("Ciudad: " + resto.getCiudad());
	    resto.mostrarMesas();
	}
	public void mostrarInfo(Resto resto, String fecha) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		System.out.println("Nombre del restaurante " + resto.getNombre());
	    System.out.println("Calle: " + resto.getCalle());
	    System.out.println("Ciudad: " + resto.getCiudad());
	    System.out.println("\nMesas:");
	    for(Mesa mesa : resto.getListaMesas()) {
	    	 boolean reservadaFecha = false;
	    	 if (mesa.getListaReservas().size()==0) {
	    		 System.out.println("Mesa " + mesa.getNroMesa() + " libre - Capacidad: " + mesa.getCapacidad());
	    	 }else {
	         for(Reserva r : mesa.getListaReservas()) {
	        	 System.out.print("Mesa " + mesa.getNroMesa() + " - Capacidad: " + mesa.getCapacidad());
				try {
					date = formatoFecha.parse(fecha);
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
	           if(r.getFecha().equals(date)) {
	             reservadaFecha = true;
	           } if(reservadaFecha) {
		           System.out.println(" - Reservada para la fecha indicada por " + r.getNombreApellido());
		         } else {          
		           System.out.println(" - Mesa libre para la fecha indicada");
		         }
	         }
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
	
	public void altaMesa(Resto resto) {
		System.out.println("Ingrese el numero de mesa que quiere dar de alta (lo puede consultar en el menú): ");
		int nro = input.nextInt();
		 for(Mesa mesa : resto.getListaMesas()) {
			    if(mesa.getNroMesa() == nro) {
			      mesa.ocupar(); 
			    }System.out.println("-");
		 }
	}
	public void bajaMesa(Resto resto) {
		System.out.println("Ingrese el numero de mesa que quiere dar de baja (lo puede consultar en el menú): ");
		int nro = input.nextInt();
		 for(Mesa mesa : resto.getListaMesas()) {
			    if(mesa.getNroMesa() == nro) {
			      mesa.liberar(); 
			    }else {
			  System.out.println("-");
			}
		 } 
	}
	public void reservarMesa(Resto resto) {
		System.out.println("Ingrese el numero de mesa que quiere reservar (lo puede consultar en el menú): ");
		int nro = input.nextInt();
		 for(Mesa mesa : resto.getListaMesas()) {
			    if(mesa.getNroMesa() == nro) {
			      mesa.reservar(); 
			    }else {
			    	System.out.println("-");
			}
		 } 
	}
	public void reservarMesa(Resto resto, String fecha) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		System.out.println("Ingrese el numero de mesa que quiere reservar: ");
		int nro = input.nextInt();
		input.nextLine();
		System.out.println("Ingrese su nombre y apellido:");
		String nomape = input.nextLine();
		System.out.println("Ingrese cantidad de comensales:");
		int comen = input.nextInt();
		 for(Mesa mesa : resto.getListaMesas()) {
	    	boolean reservadaFecha = false;
	    	 for(Reserva r : mesa.getListaReservas()) {
				try {
					date = formatoFecha.parse(fecha);
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
	           if(r.getFecha().equals(date)) {
	             reservadaFecha = true;
	           } if(reservadaFecha) {
		           System.out.println("Ya se encuentra reservada para la fecha indicada ");
		         } else {
		        	mesa.reservaFutura(nro, date, nomape, comen);
		         }
	         }
	         }
	       }
	public void guardarMesas(Resto resto) {
		MesaAD mesaad = new MesaAD();
		for(Mesa mesa : resto.getListaMesas()) {
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
}
