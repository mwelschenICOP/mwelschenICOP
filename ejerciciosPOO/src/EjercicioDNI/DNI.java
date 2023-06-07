package EjercicioDNI;

import java.util.Scanner;

public class DNI {
	private static Scanner input = new Scanner(System.in);
	
	public DNI() {
		super();
		System.out.println("Ingrese el tipo de dni");
		this.tipo = input.next();
		System.out.println("Ingrese el ejemplar");
		this.ejemplar=input.next().charAt(0);
		System.out.println("Ingrese el numero de dni");
		this.numero=input.nextInt();
	}
	private String tipo;
	private long numero;
	private char ejemplar;
	
	public DNI(String tipo, long numero, char ejemplar) {
		super();
		this.tipo = tipo;
		this.numero = numero;
		this.ejemplar = ejemplar;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public int getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(char ejemplar) {
		this.ejemplar = ejemplar;
	}
	
}
