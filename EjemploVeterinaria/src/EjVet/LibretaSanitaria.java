package EjVet;

import java.util.Scanner;

public class LibretaSanitaria {
	private static Scanner input = new Scanner(System.in);
	private static int count=100;
	private int nroLibreta=80;
	private String observacion;
	
	public LibretaSanitaria() {
		super();
		this.nroLibreta = count++;
		System.out.println("Ingrese observacion: ");
		String obs= input.next();
		this.observacion = obs;
	}
	public LibretaSanitaria(int nroLibreta, String observacion) {
		super();
		this.nroLibreta = count++;
		this.observacion = observacion;
	}
	public void mostrar() {
		System.out.println("Numero de libreta: "+this.nroLibreta+" observaciones: "+this.observacion);
	}
	public int getNroLibreta() {
		return nroLibreta;
	}
	public void setNroLibreta(int nroLibreta) {
		this.nroLibreta = nroLibreta;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
