package ParcialAseguradora;

import java.util.Scanner;

public class Autobus extends Vehiculo {
	private static Scanner input = new Scanner(System.in);
	private int numPlazas;
	
	public Autobus() {
		super();
		System.out.println("Ingrese numero de plazas");
		int pla=input.nextInt();
		this.numPlazas=pla;
	}

	public Autobus(String marca, String modelo, int anio, int nroMotor, String chasis, String color, int potenciaCV,
			String matricula,int numPlazas) {
		super(marca, modelo, anio, nroMotor, chasis, color, potenciaCV, matricula);
		this.numPlazas = numPlazas;
	}
	public void mostrar() {
		super.mostrar();
		System.out.println("Es un autobus que tiene "+this.numPlazas+" lugares para transportar gente.");
	    System.out.println("----------------------------------------\n");
	}
	public int getNumPlazas() {
		return numPlazas;
	}
	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}
}
