package EjercicioDNI;

import java.util.Scanner;

public class Persona {
	private static Scanner input = new Scanner(System.in);
	private String nombre;
	private String apellido;
	private DNI unDni;
	
	public Persona() {
		super();
		System.out.println("Ingrese el nombre");
		this.nombre = input.next();
		System.out.println("Ingrese el apellido");
		this.apellido=input.nextLine();
	}
	
	public Persona(String nombre, String apellido, DNI unDni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.unDni = unDni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public DNI getDni() {
		return unDni;
	}
	
	DNI undni = new DNI();
	
	
	
	

}
