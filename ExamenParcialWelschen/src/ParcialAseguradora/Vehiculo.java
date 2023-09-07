package ParcialAseguradora;

import java.util.Scanner;

public class Vehiculo {
	private static Scanner input = new Scanner(System.in);
	private String marca;
	private String modelo;
	private int anio;
	private int nroMotor;
	private String chasis;
	private String color;
	private int potenciaCV;
	private String matricula;
	
	public Vehiculo() {
		super();
		System.out.println("Ingrese marca");
		String mar =input.nextLine();
		this.marca=mar;
		System.out.println("Ingrese modelo");
		String mod=input.nextLine();
		this.modelo=mod;
		System.out.println("Ingrese año del auto");
		int an = input.nextInt();
		this.anio=an;
		System.out.println("Ingrese numero de motor");
		int mot=input.nextInt();
		this.nroMotor=mot;
		input.nextLine();
		System.out.println("Ingrese chasis");
		String chas=input.nextLine();
		this.chasis=chas;
		System.out.println("ingrese color");
		String col=input.nextLine();
		this.color=col;
		System.out.println("Ingrese matricula");
		String mat=input.nextLine();
		this.matricula=mat;
		System.out.println("ingrese potencia en CV");
		int cv =input.nextInt();
		this.potenciaCV=cv;
	}
	public Vehiculo(String marca, String modelo, int anio, int nroMotor, String chasis, String color, int potenciaCV,
			String matricula) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.nroMotor = nroMotor;
		this.chasis = chasis;
		this.color = color;
		this.potenciaCV = potenciaCV;
		this.matricula = matricula;
	}
	
	public void mostrar() {
		System.out.println("El vehiculo es marca "+this.marca+", modelo "+this.modelo +" y año "+this.anio+"\n");
		System.out.println("Su numero de motor es "+this.nroMotor +", su chasis "+this.chasis+" y color "+this.color+"\n");
	    System.out.println("Tiene "+this.potenciaCV+" caballos de potencia y su matricula es "+this.matricula+"\n");
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getNroMotor() {
		return nroMotor;
	}
	public void setNroMotor(int nroMotor) {
		this.nroMotor = nroMotor;
	}
	public String getChasis() {
		return chasis;
	}
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPotenciaCV() {
		return potenciaCV;
	}
	public void setPotenciaCV(int potenciaCV) {
		this.potenciaCV = potenciaCV;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
