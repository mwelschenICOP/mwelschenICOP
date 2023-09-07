package ParcialAseguradora;

import java.util.Scanner;

enum Genero{Femenino,Masculino}
public class Cliente {
	private static Scanner input = new Scanner(System.in);
	private String nombre;
	private String apellido;
	private Genero genero;
	private int dni;
	private String mail;
	private String domicilio;
	private int telefono;
	
	public Cliente(String nombre, String apellido, Genero genero, int dni, String mail, String domicilio,
			int telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.dni = dni;
		this.mail = mail;
		this.domicilio = domicilio;
		this.telefono = telefono;
	}
	public Cliente() {
		super();
		System.out.println("Ingrese nombre del ciente: ");
		String name=input.nextLine();
		this.nombre=name;
		System.out.println("Ingrese apellido del cliente: ");
		String ape=input.nextLine();
		this.apellido=ape;
		System.out.println("Ingrese 1 si es femenino o 2 si es masculino");
		int sexo=input.nextInt();
		if (sexo==1) {
			this.genero=Genero.Femenino;
		}else if (sexo==2) {
			this.genero=Genero.Masculino;
		}else {
			System.out.println("El valor ingresado es incorrecto");
		}input.nextLine();
		System.out.println("Ingrese el dni: ");
		int doc=input.nextInt();
		this.dni=doc;
		input.nextLine();
		System.out.println("Ingrese mail");
		String correo =input.nextLine();
		this.mail=correo;
		System.out.println("Ingrese domicilio");
		String domi =input.nextLine();
		this.domicilio=domi;
		System.out.println("Ingrese telefono");
		int tel =input.nextInt();
		this.telefono=tel;
	}
		public void mostrar() {
			System.out.println("El nombre del cliente es: "+this.nombre+", apellido: "+this.apellido +"\n");
			System.out.println("Su genero es "+this.genero +", su dni "+this.dni+" y su domicilio: "+this.domicilio+"\n");
		    System.out.println("Para comunicarse puede hacer al telefono: "+this.telefono+" o al correo: "+this.mail+"\n");
		    System.out.println("-------------------------------------------------");
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public Genero getGenero() {
		return genero;
	}
	public int getDni() {
		return dni;
	}
	public String getMail() {
		return mail;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public int getTelefono() {
		return telefono;
	}
}
