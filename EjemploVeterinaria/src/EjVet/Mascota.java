package EjVet;
import java.util.Scanner;
enum sexo {Macho,Hembra}

public abstract class Mascota {
	
	private static Scanner input = new Scanner(System.in);
	private static int cont=0;
	private int idMascota;
	private String nombre;
	private String fecha_nacimiento;
	private sexo sexo;
	private boolean esAbonado;
	private LibretaSanitaria nroLibreta;
	
	public Mascota(int idMascota, String nombre, String fecha_nacimiento, EjVet.sexo sexo, boolean esAbonado,
			LibretaSanitaria nroLibreta) {
		super();
		this.idMascota = cont++;
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.sexo = sexo;
		this.esAbonado = esAbonado;
		this.nroLibreta = nroLibreta;
	}
	
	public Mascota() {
		super();
		this.idMascota = cont++;
		System.out.println("Ingrese el nombre de la mascota: ");
		String name = input.nextLine();
		this.nombre= name;
		System.out.println("Ingrese fecha de nacimiento: ");
		String fecha = input.nextLine();
		this.fecha_nacimiento=fecha;
		System.out.println("Ingrese 1 si es macho o 2 si es hembra: ");
		int sex=input.nextInt();
		if (sex==1) {
			this.sexo= EjVet.sexo.Macho;
		}else if (sex==2) {
			this.sexo= EjVet.sexo.Hembra;
		}else {
			System.out.println("No seleccionó una opcion correcta, se asigna hembra por defecto");
			this.sexo= EjVet.sexo.Hembra;
		}
		System.out.println("ingrese 1 si es abonado o 2 si no lo es: ");
		int abono = input.nextInt();
		if (abono==1) {
			this.esAbonado=true;
		}else if (abono==2) {
			this.esAbonado=false;
		}else {
			System.out.println("No ingreso una opcion correcta, se coloca no abonado por defecto");
			this.esAbonado=false;
		}
		this.nroLibreta=new LibretaSanitaria();
	}
	public void mostrar() {
		System.out.println("ID de la mascota: "+this.idMascota+", nombre: "+this.nombre);
		System.out.println("Fecha de nacimiento: "+this.fecha_nacimiento +", sexo: "+this.sexo);
		if(this.esAbonado==true) {
			System.out.println("Es abonado y su numero de libreta es :"+this.nroLibreta.getNroLibreta());
		}else
		System.out.println("No es abonado y su numero de libreta es :"+this.nroLibreta.getNroLibreta());
	}

	public int getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public sexo getSexo() {
		return sexo;
	}
	public void setSexo(sexo sexo) {
		this.sexo = sexo;
	}
	public boolean isEsAbonado() {
		return esAbonado;
	}
	public void setEsAbonado(boolean esAbonado) {
		this.esAbonado = esAbonado;
	}

	public LibretaSanitaria getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(LibretaSanitaria nroLibreta) {
		this.nroLibreta = nroLibreta;
	}
	
}
