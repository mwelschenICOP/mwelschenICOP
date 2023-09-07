package EjVet;
import java.util.Scanner;
enum Especie {serpiente,boa,piton,anaconda}

public class Ofidios extends Mascota {

	private static Scanner input = new Scanner(System.in);
	private Especie especie;
	private float longitud;
	private boolean esConstrictora = false;
	private boolean esVenenosa = false;
	private boolean estaDomesticada = false;
	
	public Ofidios(int idMascota, String nombre, String fecha_nacimiento, EjVet.sexo sexo, boolean esAbonado,
			LibretaSanitaria nroLibreta, Especie especie, float longitud, boolean esConstrictora, boolean esVenenosa,
			boolean estaDomesticada) {
		super(idMascota, nombre, fecha_nacimiento, sexo, esAbonado, nroLibreta);
		this.especie = especie;
		this.longitud = longitud;
		this.esConstrictora = esConstrictora;
		this.esVenenosa = esVenenosa;
		this.estaDomesticada = estaDomesticada;
	}
	public Ofidios() {
		super();
		System.out.println("Especie");
		System.out.println("Ingrese: 1) Serpiente 2)Boa 3)Piton o 4)Anaconda");
		int espe=input.nextInt();
		switch(espe) {
		case 1:
			this.especie=especie.serpiente;
			break;
		case 2:
			this.especie=especie.boa;
			break;
		case 3:
			this.especie=especie.piton;
			break;
		case 4:
			this.especie=especie.anaconda;
			break;
		}
		System.out.println("Ingrese longitud en formato m,cm:");
		float longit = input.nextFloat();
		this.longitud=longit;
		System.out.println("Ingrese 1 si es constrictora o 2 si no lo es: ");
		int cons=input.nextInt();
		if (cons==1) {
			this.esConstrictora=true;
		}else {
			this.esConstrictora=false;
		}
		System.out.println("Ingrese 1 si es venenosa o 2 si no lo es: ");
		int ven=input.nextInt();
		if (ven==1) {
			this.esVenenosa=true;
		}else {
			this.esVenenosa=false;
		}
		System.out.println("Ingrese 1 si está domesticada o 2 si no lo está: ");
		int dom=input.nextInt();
		if (dom==1) {
			this.estaDomesticada=true;
		}else {
			this.estaDomesticada=false;
		}
	}
	

	public void mostrar() {
		super.mostrar();
		System.out.println("La especie es "+this.especie+" y su longitud es: "+this.longitud);
		if (this.esConstrictora=true) {
			System.out.println("Es constrictora");
		}else {
			System.out.println("No es constrictora");
		}
		if (this.estaDomesticada=true) {
			System.out.println("Esta domesticada");
		}else {
			System.out.println("No esta domesticada");
		}
		if (this.esVenenosa=true) {
			System.out.println("Es venenosa");
		}else {
			System.out.println("No es venenosa");
		}
		
	}
	public Especie getEspecie() {
		return especie;
	}
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public boolean isEsConstrictora() {
		return esConstrictora;
	}
	public void setEsConstrictora(boolean esConstrictora) {
		this.esConstrictora = esConstrictora;
	}
	public boolean isEsVenenosa() {
		return esVenenosa;
	}
	public void setEsVenenosa(boolean esVenenosa) {
		this.esVenenosa = esVenenosa;
	}
	public boolean isEstaDomesticada() {
		return estaDomesticada;
	}
	public void setEstaDomesticada(boolean estaDomesticada) {
		this.estaDomesticada = estaDomesticada;
	}
}
