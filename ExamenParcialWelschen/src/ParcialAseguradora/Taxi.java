package ParcialAseguradora;

import java.util.Scanner;

public class Taxi extends Vehiculo {
	private static Scanner input = new Scanner(System.in);
	private int numLicencia;
	
	public Taxi() {
		super();
		System.out.println("Ingrese numero de licencia");
		int lic=input.nextInt();
		this.numLicencia=lic;
	}

	public Taxi(String marca, String modelo, int anio, int nroMotor, String chasis, String color, int potenciaCV,
			String matricula, int numLicencia) {
		super(marca, modelo, anio, nroMotor, chasis, color, potenciaCV, matricula);
		this.numLicencia = numLicencia;
	}
	public void mostrar() {
		super.mostrar();
		System.out.println("Es un taxi cuyo numero de licencia es "+this.numLicencia);
	    System.out.println("----------------------------------------\n");
	}
	public int getNumLicencia() {
		return numLicencia;
	}

	public void setNumLicencia(int numLicencia) {
		this.numLicencia = numLicencia;
	}
}
