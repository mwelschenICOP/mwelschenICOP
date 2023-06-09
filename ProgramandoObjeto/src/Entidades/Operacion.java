package Entidades;

import java.util.Scanner;

public class Operacion {
	private static Scanner input = new Scanner(System.in);

	private int numero1, numero2;

	public Operacion() {
		super();
	}

	public Operacion(int numero1, int numero2) {
		super();
		this.numero1 = numero1;
		this.numero2 = numero2;
	}

	public int getNumero1() {
		return numero1;
	}

	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}

	public int getNumero2() {
		return numero2;
	}

	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}

	public void crearOperacion(int numero1, int numero2) {
		this.numero1=input.nextInt();
		this.numero2=input.nextInt();
	}
	public int sumar() {
		return numero1+numero2;	
	}
	public int restar() {
		return numero1-numero2;
	}
	public int multiplicar() {
		if (numero1==0 || numero2==0) {
			System.out.println("Error: no debe ingresar 0");
			return 0;
		}else
			return numero1*numero2;
	}
	public int dividir() {
		if (numero1==0 || numero2==0) {
			System.out.println("Error: no debe ingresar 0");
			return 0;
		}else
			return numero1/numero2;
	}
}
