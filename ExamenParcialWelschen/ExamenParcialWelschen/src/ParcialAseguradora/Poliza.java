package ParcialAseguradora;

import java.util.Scanner;

enum TipoCobertura {Total,ContraTerceros,Parcial}

public class Poliza {
	private static Scanner input = new Scanner(System.in);
	private static int autoinc=1000;
	private int numPoliza;
	private String fechaInicio;
	private String fechaFin;
	private int cantCuotas;
	private FormaPago formaPagoPreferente;
	private int montoTotalAsegurado;
	private boolean incluyeGranizo;
	private int montoMaxGranizo;
	private Vehiculo vehiculo;
	private Cliente cliente;
	
	public Poliza() {
		super();
		this.numPoliza = autoinc++;
		System.out.println("Ingrese fecha de inicio");
		this.fechaInicio=input.nextLine();
		input.nextLine();
		System.out.println("Ingrese fecha de fin");
		this.fechaFin=input.nextLine();
		input.nextLine();
		System.out.println("Ingrese cantidad de cuotas");
		this.cantCuotas=input.nextInt();
		input.nextLine();
		System.out.println("Indique forma de pago preferente: 1-Efectivo 2-Transferencia 3-Debito Automatico");
		int pago=input.nextInt();
		if(pago==1) {
			this.formaPagoPreferente=FormaPago.Efectivo;
		}else if(pago==2) {
			this.formaPagoPreferente=FormaPago.Transferencia;
		}else if(pago==3){
			this.formaPagoPreferente=FormaPago.DebitoAutomatico;
		}else {
			this.formaPagoPreferente=FormaPago.Indefinido;
		}
		input.nextLine();
		System.out.println("Ingrese el monto total asegurado");
		this.montoTotalAsegurado=input.nextInt();
		input.nextLine();
		System.out.println("Marque 1 si incluye cobertura a granizo o 2 si no lo incluye"); 
		int gra=input.nextInt();
		if(gra==1) {
			this.incluyeGranizo=true;
		}else {
			this.incluyeGranizo=false;
		}input.nextLine();
		System.out.println("Ingrese el monto maximo contra granizo");
		this.montoMaxGranizo=input.nextInt();
		this.cliente = new Cliente();
		this.vehiculo = new Vehiculo();
	}
	public Poliza(int numPoliza, String fechaInicio, String fechaFin, int cantCuotas, FormaPago formaPagoPreferente,
			int montoTotalAsegurado, boolean incluyeGranizo, int montoMaxGranizo, Vehiculo vehiculo, Cliente cliente) {
		super();
		this.numPoliza = autoinc++;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cantCuotas = cantCuotas;
		this.formaPagoPreferente = formaPagoPreferente;
		this.montoTotalAsegurado = montoTotalAsegurado;
		this.incluyeGranizo = incluyeGranizo;
		this.montoMaxGranizo = montoMaxGranizo;
		this.vehiculo = vehiculo;
		this.cliente = cliente;
	}
	public void mostrar() {
		System.out.println("Numero de poliza: "+this.numPoliza+", iniciada el dia "+this.fechaInicio +" y si fecha de finalizacion es: "+this.fechaFin);
		System.out.println("Son "+this.cantCuotas +" cuotas, la forma de pago preferencial es "+this.formaPagoPreferente+" y su monto total asegurado es: "+this.montoTotalAsegurado);
	    if(incluyeGranizo==true) {
		System.out.println("Incluye cobertura contra granizo, por un monto maximo de: "+this.montoMaxGranizo);
	    }else {
	    	System.out.println("No incluye cobertura contra granizo, pero puede comunicarse con Aseguradora La Tercera Seguros para contratarlo. Su consulta no molesta");
	    }
	}
	public int getNumPoliza() {
		return numPoliza;
	}
	public void setNumPoliza(int numPoliza) {
		this.numPoliza = numPoliza;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getCantCuotas() {
		return cantCuotas;
	}
	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}
	public FormaPago getFormaPagoPreferente() {
		return formaPagoPreferente;
	}

	public int getMontoTotalAsegurado() {
		return montoTotalAsegurado;
	}
	public void setMontoTotalAsegurado(int montoTotalAsegurado) {
		this.montoTotalAsegurado = montoTotalAsegurado;
	}
	public boolean isIncluyeGranizo() {
		return incluyeGranizo;
	}
	public void setIncluyeGranizo(boolean incluyeGranizo) {
		this.incluyeGranizo = incluyeGranizo;
	}
	public int getMontoMaxGranizo() {
		return montoMaxGranizo;
	}
	public void setMontoMaxGranizo(int montoMaxGranizo) {
		this.montoMaxGranizo = montoMaxGranizo;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
}
