package EjVet;
import java.util.ArrayList;
import java.util.Scanner;
public class Veterinaria {
	private static Scanner input = new Scanner(System.in);
	private String razonSocial;
	private String domicilio;
	private Localidades localidad;
	private String telRegular;
	private String telGuardia;
	private ArrayList<Mascota> listaMascotas;
	
	public Veterinaria() {
		super();
		System.out.println("Ingrese razon social: ");
		String rs=input.next();
		this.razonSocial=rs;
		System.out.println("Ingrese domicilio: ");
		String domi=input.nextLine();
		this.domicilio=domi;
		input.nextLine();
		System.out.println("Localidad: ingrese 1 si es Santa fe o 2 si es San vicente ");
		int local=input.nextInt();
		if (local==1) {
			this.localidad=Localidades.SantaFe;
		}else {
			this.localidad=Localidades.SanVicente;
		}
		System.out.println("Ingrese telefono regular");
		String regular = input.next();
		this.telRegular=regular;
		input.nextLine();
		System.out.println("Ingrese telefono de guardia");
		String guardia = input.nextLine();
		this.telGuardia=guardia;
		this.listaMascotas=new ArrayList();
	}
	public Veterinaria(String razonSocial, String domicilio, Localidades localidad, String telRegular,
			String telGuardia) {
		super();
		this.razonSocial = razonSocial;
		this.domicilio = domicilio;
		this.localidad = localidad;
		this.telRegular = telRegular;
		this.telGuardia = telGuardia;
		this.listaMascotas = new ArrayList<Mascota>();
	}
	
	public void agregarMascota() {
		System.out.println("Ingrese 1 si quiere agregar un Canino o 2 si es Ofidio ");
		int mascot =input.nextInt();
		if (mascot==1) {
			listaMascotas.add(new Canino());
		}else if (mascot==2) {
			listaMascotas.add(new Ofidios());
		}else {
			System.out.println("El valor ingresado no es valido.");
		}
	}

	public void agregarMascota(Mascota mascota) {
		listaMascotas.add(mascota);	
	}
	
	public void agregarMascota(int idMascota, String nombre, String fecha_nacimiento, EjVet.sexo sexo, boolean esAbonado,
			LibretaSanitaria nroLibreta, String raza, Pelaje pelaje, String color, float peso, boolean estaVacunado,
			boolean estaDesparacitado) {
		listaMascotas.add(new Canino());
	}
	public void agregarMascota(int idMascota, String nombre, String fecha_nacimiento, EjVet.sexo sexo, boolean esAbonado,
			LibretaSanitaria nroLibreta, Especie especie, float longitud, boolean esConstrictora, boolean esVenenosa,
			boolean estaDomesticada) {
		listaMascotas.add(new Ofidios());
	}
	
	public void mostrarVeterinaria() {
		System.out.println("---------------------------");
		System.out.println("Bienvenidos a veterinaria: "+this.razonSocial);
		System.out.println("Ubicada en el domicilio: "+this.domicilio +"en la localidad de "+this.localidad);
		System.out.println("Nuesto numero de telefono es :"+this.telRegular+", en el caso de guardias, llame al "+this.telGuardia);
	}
	public void mostrarMascotas() {
		System.out.println("-------Lista de mascotas---------");
		if (this.listaMascotas.isEmpty()) {System.out.println("No hay mascotas registradas.");}
    	else {
    		 for(int i=0; i< this.listaMascotas.size();i++){
    			 this.listaMascotas.get(i).mostrar();
    	}
    	}
	}
	
	public void eliminarMascota() {
		mostrarMascotas();
		
	}

	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public Localidades getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidades localidad) {
		this.localidad = localidad;
	}
	public String getTelRegular() {
		return telRegular;
	}
	public void setTelRegular(String telRegular) {
		this.telRegular = telRegular;
	}
	public String getTelGuardia() {
		return telGuardia;
	}
	public void setTelGuardia(String telGuardia) {
		this.telGuardia = telGuardia;
	}
	public ArrayList<Mascota> getListaMascotas() {
		return listaMascotas;
	}
	public void setListaMascotas(ArrayList<Mascota> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}
}
