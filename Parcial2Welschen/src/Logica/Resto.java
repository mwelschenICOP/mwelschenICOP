package Logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Resto {
	private static int cont = 0;
	private int id;
	private String nombre;
	private String calle;
	private String ciudad;
	private ArrayList<Mesa> listaMesas;
	
	private static Scanner input = new Scanner(System.in);
	
	public Resto() {
		super();
		cont++;
		this.id=cont;
		this.listaMesas = new ArrayList<Mesa>();
	}
	public Resto(String nombre, String calle, String ciudad) {
		super();
		cont++;
		this.id=cont;
		this.nombre = nombre;
		this.calle = calle;
		this.ciudad = ciudad;
		this.listaMesas = new ArrayList<Mesa>();
	}

	public int getId() {
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
		Date date=null;
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
}

