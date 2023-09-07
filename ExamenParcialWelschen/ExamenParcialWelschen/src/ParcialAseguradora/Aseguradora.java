package ParcialAseguradora;

import java.util.ArrayList;
import java.util.Scanner;


public class Aseguradora {
	private static Scanner input = new Scanner(System.in);
	private String razonSocial;
	private ArrayList<Cliente> listaCliente;
	private ArrayList<Vehiculo> listaVehiculo;
	private ArrayList<Poliza> listaPoliza;
	private ArrayList<Taxi> listaTaxi;
	private ArrayList<Autobus> listaAutobus;
	
	public Aseguradora() {
		super();
	}
	public Aseguradora(String razonSocial, ArrayList<Cliente> listaCliente, ArrayList<Vehiculo> listaVehiculo,
			ArrayList<Poliza> listaPoliza, ArrayList<Taxi> listaTaxi, ArrayList<Autobus> listaAutobus) {
		super();
		this.razonSocial = razonSocial;
		this.listaCliente =  new ArrayList<Cliente>();
		this.listaVehiculo =  new ArrayList<Vehiculo>();
		this.listaPoliza =  new ArrayList<Poliza>();
		this.listaTaxi=new ArrayList<Taxi>();
		this.listaAutobus=new ArrayList<Autobus>();
	}
	public void agregarCliente() {
		listaCliente.add(new Cliente());
	}
	public void agregarVehiculo() {
		System.out.println("Ingrese 1 si quiere agregar un taxi o 2 si es autobus ");
		int tipo =input.nextInt();
		if (tipo==1) {
		listaVehiculo.add(new Taxi());
		listaTaxi.add(new Taxi());
		}else if(tipo==2) {
			listaVehiculo.add(new Autobus());
			listaAutobus.add(new Autobus());
		}else {
		System.out.println("El valor ingresado es incorrecto");	
		}
		}
	public void agregarPoliza() {
		listaPoliza.add(new Poliza());
	}
	public void mostrarCliente() {
		System.out.println("-------Lista de clientes---------");
		if (this.listaCliente.isEmpty()) {System.out.println("No hay clientes registrados.");}
    	else {
    		 for(int i=0; i< this.listaCliente.size();i++){
    			 this.listaCliente.get(i).mostrar();
    	}
    	}
	}
	public void mostrarPoliza() {
		System.out.println("-------Lista de polizas----------");
		if (this.listaPoliza.isEmpty()) {System.out.println("No hay polizas registradas.");}
    	else {
    		 for(int i=0; i< this.listaPoliza.size();i++){
    			 this.listaPoliza.get(i).mostrar();
    		 }
    	}
    	}
	public void mostrarVehiculo() {
		System.out.println("-------Lista de vehiculos----------");
		if (this.listaVehiculo.isEmpty()) {System.out.println("No hay vehiculos registrados.");}
    	else {
    		 for(int i=0; i< this.listaVehiculo.size();i++){
    			 this.listaVehiculo.get(i).mostrar();
    		 }
    	}
	}
		public void mostrarTaxi() {
		System.out.println("-------Lista de taxis----------");
		if (this.listaTaxi.isEmpty()) {System.out.println("No hay taxis registrados.");}
    	else {
    		 for(int i=0; i< this.listaTaxi.size();i++){
    			 this.listaTaxi.get(i).mostrar();
    		 }
    	}
	}
		public void mostrarAutobus() {
			System.out.println("-------Lista de autobuses----------");
			if (this.listaAutobus.isEmpty()) {System.out.println("No hay autobuses registrados.");}
	    	else {
	    		 for(int i=0; i< this.listaAutobus.size();i++){
	    			 this.listaAutobus.get(i).mostrar();
	    		 }
	    	}	
		}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}
	public void setListaCliente(ArrayList<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	public ArrayList<Vehiculo> getListaVehiculo() {
		return listaVehiculo;
	}
	public void setListaVehiculo(ArrayList<Vehiculo> listaVehiculo) {
		this.listaVehiculo = listaVehiculo;
	}
	public ArrayList<Poliza> getListaPoliza() {
		return listaPoliza;
	}
	public void setListaPoliza(ArrayList<Poliza> listaPoliza) {
		this.listaPoliza = listaPoliza;
	}	
}
