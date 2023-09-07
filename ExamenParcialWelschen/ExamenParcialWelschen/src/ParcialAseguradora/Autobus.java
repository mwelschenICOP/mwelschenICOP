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
		input.nextLine();
	}

	public Autobus(int numPlazas) {
		super();
		this.numPlazas = numPlazas;
	}
	public void mostrar() {
		super.mostrar();
		System.out.println("Es un autobus que tiene "+this.numPlazas+" lugares para transportar gente.");
	}
	public int getNumPlazas() {
		return numPlazas;
	}
	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}
}
