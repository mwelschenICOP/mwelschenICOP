package ParcialAseguradora;

import java.util.Scanner;

public class Cuota {
	private static Scanner input = new Scanner(System.in);
	private int numCuota;
	private int montoCuota;
	private boolean pagada;
	private String fechaVencimiento;
	private FormaPago formaPagoEfectiva;
	private String fecha_pago;
	
	public Cuota() {
		super();
		System.out.println("Ingrese numero de cuota");
		this.numCuota=input.nextInt();
		input.nextLine();
		System.out.println("Ingrese el monto de cuota");
		this.montoCuota=input.nextInt();
		input.nextLine();
		System.out.println("Ingrese 1 si esta pagada o 2 si no");
		int pag=input.nextInt();
		if(pag==1) {
			this.pagada=true;
		}else {
			this.pagada=false;
		}input.nextLine();
		System.out.println("Ingrese fecha de vencimiento");
		this.fechaVencimiento=input.nextLine();
		input.nextLine();
		System.out.println("Indique forma de pago efectiva: 1-Efectivo 2-Transferencia 3-Debito Automatico Otro-Indefinido");
		int pago=input.nextInt();
		if(pago==1) {
			this.formaPagoEfectiva=FormaPago.Efectivo;
		}else if(pago==2) {
			this.formaPagoEfectiva=FormaPago.Transferencia;
		}else if(pago==3){
			this.formaPagoEfectiva=FormaPago.DebitoAutomatico;
		}else {
			this.formaPagoEfectiva=FormaPago.Indefinido;
		}
		System.out.println("Ingrese fecha de pago");
		this.fecha_pago=input.nextLine();
	}
	public Cuota(int numCuota, int montoCuota, boolean pagada, String fechaVencimiento, FormaPago formaPagoEfectiva) {
		super();
		this.numCuota = numCuota;
		this.montoCuota = montoCuota;
		this.pagada = pagada;
		this.fechaVencimiento = fechaVencimiento;
		this.formaPagoEfectiva = formaPagoEfectiva;
	}
	public void mostrar() {
		System.out.println("Numero de cuota: "+this.numCuota+", monto: "+this.montoCuota);
		if(pagada==true) {
			System.out.println("Medio de pago:"+this.formaPagoEfectiva);
		}else {
			System.out.println("Cuota adeudada");
		}
	}
	public void cuotaPaga(FormaPago forma, String fecha){
		this.pagada=true;
		this.formaPagoEfectiva=forma;
		this.fecha_pago=fecha;
	}
	public int getNumCuota() {
		return numCuota;
	}
	public void setNumCuota(int numCuota) {
		this.numCuota = numCuota;
	}
	public int getMontoCuota() {
		return montoCuota;
	}
	public void setMontoCuota(int montoCuota) {
		this.montoCuota = montoCuota;
	}
	public boolean isPagada() {
		return pagada;
	}
	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public FormaPago getFormaPagoEfectiva() {
		return formaPagoEfectiva;
	}
	public void setFormaPagoEfectiva(FormaPago formaPagoEfectiva) {
		this.formaPagoEfectiva = formaPagoEfectiva;
	}
}
