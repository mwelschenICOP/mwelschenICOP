package EjVet;

import java.util.Scanner;

enum Pelaje {largo,corto}

public class Canino extends Mascota {
	public Canino(int idMascota, String nombre, String fecha_nacimiento, EjVet.sexo sexo, boolean esAbonado,
			LibretaSanitaria nroLibreta, String raza, Pelaje pelaje, String color, float peso, boolean estaVacunado,
			boolean estaDesparacitado) {
		super(idMascota, nombre, fecha_nacimiento, sexo, esAbonado, nroLibreta);
		this.raza = raza;
		this.pelaje = pelaje;
		this.color = color;
		this.peso = peso;
		this.estaVacunado = estaVacunado;
		this.estaDesparacitado = estaDesparacitado;
	}
	private static Scanner input = new Scanner(System.in);
	private String raza = "mestizo";
	private Pelaje pelaje;
	private String color;
	private float peso;
	private boolean estaVacunado;
	private boolean estaDesparacitado;
	
	public Canino() {
		super();
		System.out.println("ingrese raza: ");
		String raz=input.next();
		this.raza=raz;
		input.nextLine();
		System.out.println("ingrese 1 si es pelo largo o 2 si es pelo corto: ");
		int pelo =input.nextInt();
		if(pelo==1) {
			this.pelaje=Pelaje.largo;
		}else if (pelo==2) {
			this.pelaje=Pelaje.corto;
		}else {
			System.out.println("No ingresó una opcion valida, se indica pelo corto por defecto");
			this.pelaje=Pelaje.corto;
		}
		System.out.println("Ingrese el color: ");
		String col=input.nextLine();
		this.color=col;
		input.nextLine();
		System.out.println("Ingrese el peso en formato kg,gr :" );
		float pes=input.nextFloat();
		this.peso=pes;
		input.nextLine();
		System.out.println("Ingrese 1 si esta vacunado o 2 si no lo está: ");
		int vacu =input.nextInt();
		if (vacu==1) {
			this.estaVacunado=true;
		}else if (vacu==2) {
			this.estaVacunado=false;
		}else {
			System.out.println("ingreso una opcion incorrecta, se coloca no vacunado por defecto.");
			this.estaVacunado=false;
		}
		System.out.println("Ingrese 1 si esta desparacitado o 2 si no lo está: ");
		int desp =input.nextInt();
		if (desp==1) {
			this.estaDesparacitado=true;
		}else if (desp==2) {
			this.estaDesparacitado=false;
		}else {
			System.out.println("ingreso una opcion incorrecta, se coloca no vacunado por defecto.");
			this.estaDesparacitado=false;
		}
	}


	public void mostrar() {
		super.mostrar();
		System.out.println("El perro es raza: "+this.raza+", color "+this.color+" y de pelo "+this.pelaje);
		System.out.println("Su peso es: "+this.peso);
		if (this.estaVacunado=true) {
			System.out.println("Está vacunado.");
		}else {
			System.out.println("No está vacunado");
		}
		if (this.estaDesparacitado=true) {
			System.out.println("Está desparacitado.");
		}else {
			System.out.println("No está desparacitado");
		}
	}
	public void vacunar() {
		this.estaVacunado=true;
	}
	public void desparacitar() {
		this.estaDesparacitado=true;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public Pelaje getPelaje() {
		return pelaje;
	}
	public void setPelaje(Pelaje pelaje) {
		this.pelaje = pelaje;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public boolean isEstaVacunado() {
		return estaVacunado;
	}
	public void setEstaVacunado(boolean estaVacunado) {
		this.estaVacunado = estaVacunado;
	}
	public boolean isEstaDesparacitado() {
		return estaDesparacitado;
	}
	public void setEstaDesparacitado(boolean estaDesparacitado) {
		this.estaDesparacitado = estaDesparacitado;
	}
}
