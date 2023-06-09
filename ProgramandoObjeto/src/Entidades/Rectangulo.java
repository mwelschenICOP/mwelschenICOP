package Entidades;

import java.util.Scanner;

public class Rectangulo {
	private static Scanner input = new Scanner(System.in);
	private int base, altura;
	public Rectangulo(int base, int altura) {
		super();
		this.base = base;
		this.altura = altura;
	}

	public Rectangulo() {
		super();
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	public void crearRectangulo(int base, int altura) {
		this.base = input.nextInt();
		this.altura = input.nextInt();
	}public void calcularSuperficie() {
		System.out.println("La superficie del rectangulo es: "+(base*altura));
	}
	public void calcularPerimetro() {
		System.out.println("El perimetro del rectangulo es: "+((base+altura)*2));
	}
	public void dibujarRectangulo() {
		for (int i=0; i<altura;i++ ) {
			for (int j=0; j<base; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
