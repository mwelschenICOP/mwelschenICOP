package ParcialAseguradora;

import java.util.ArrayList;
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
	private ArrayList<Cuota> listaCuota;
	private TipoCobertura tipoCobertura;

	public Poliza(Vehiculo vehiculo, Cliente cliente) {
		super();
		this.numPoliza = autoinc++;
		System.out.println("Ingrese fecha de inicio");
		this.fechaInicio=input.nextLine();
		System.out.println("Ingrese fecha de fin");
		this.fechaFin=input.nextLine();
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
		this.cliente = cliente;
		this.vehiculo =  vehiculo;
		this.listaCuota=new ArrayList<Cuota>();
		System.out.println("Indique el tipo de cobertura: 1-Total 2-Contra Terceros 3-Parcial");
		int tip=input.nextInt();
		if(tip==1) {
			this.tipoCobertura=TipoCobertura.Total;
		}else if(pago==2) {
			this.tipoCobertura=TipoCobertura.ContraTerceros;
		}else if(pago==3){
			this.tipoCobertura=TipoCobertura.Parcial;
		}else {System.out.println("Valor incorrecto, se asigno Parcial por defecto");
		this.tipoCobertura=TipoCobertura.Parcial;
		}
	}
	public Poliza(int numPoliza, String fechaInicio, String fechaFin, int cantCuotas, FormaPago formaPagoPreferente,
			int montoTotalAsegurado, boolean incluyeGranizo, int montoMaxGranizo, Vehiculo vehiculo, Cliente cliente, ArrayList<Cuota> listaCuota, TipoCobertura tipoCobertura) {
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
		this.listaCuota= new ArrayList<Cuota>();
		this.tipoCobertura=tipoCobertura;
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
	public void agregarCuota() {
		this.listaCuota.add(new Cuota());
	}
	public void mostrarCuota() {
		for (int i=0;i<listaCuota.size();i++) {
			System.out.print("Cuota N°"+(i+1)+") ");
			listaCuota.get(i).mostrar();
		}
	}
	public int proxCuotaImpaga() {
		for(int i=0;i<listaCuota.size();i++) {
			if(listaCuota.get(i).isPagada()==false) {
				System.out.println("CUOTA A PAGAR n° "+(i+1)+" = ");
				return i;
			}
		}
		return -1;
	}
	public void cuotaPagada(int posicionCuota, FormaPago pago, String fecha) {
		this.listaCuota.get(posicionCuota).cuotaPaga(pago, fecha);
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
	public ArrayList<Cuota> getListaCuota() {
		return listaCuota;
	}
	public void setListaCuota(ArrayList<Cuota> listaCuota) {
		this.listaCuota = listaCuota;
	}
	public TipoCobertura getTipoCobertura() {
		return tipoCobertura;
	}
	public void setTipoCobertura(TipoCobertura tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}
	public void setFormaPagoPreferente(FormaPago formaPagoPreferente) {
		this.formaPagoPreferente = formaPagoPreferente;
	}	
}
