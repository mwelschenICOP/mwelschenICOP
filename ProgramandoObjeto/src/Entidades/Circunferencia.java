package Entidades;

public class Circunferencia {
	private double radio;

	public Circunferencia(double radio) {
		super();
		this.radio = radio;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	public Circunferencia() {
		super();
	}

	public void crearCircunferencia(double radio) {
		this.radio = radio;
	}
	public void area() {
		double A =Math.PI *Math.pow(radio, 2);
		System.out.println("El area de la circunferencia es "+A);
	}
	public void perimetro() {
		double P =Math.PI*radio*2;
		System.out.println("El perimetro de la circunferencia es "+P);
	}
}
