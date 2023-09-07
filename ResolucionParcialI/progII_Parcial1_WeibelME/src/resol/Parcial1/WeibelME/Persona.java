package resol.Parcial1.WeibelME;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Persona {
	private String apellido;
	private String nombre;
	private String dni;
	private String fechaNacimiento;
	private Domicilio domicilio;
	
	
	
	public Persona() {
		super();
	}

	public void mostrar() {
		System.out.println("Apellido y nombre: "+ this.getApellido()+", "+this.getNombre()+" DNI N°: "+this.getDni()+" Natalicio: "+ this.getFechaNacimiento());
		this.getDomicilio().mostrar();
	}
	
	public Persona(String apellido, String nombre, String dni, String unaFecha, String calle, int nro, int localidad) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = unaFecha;
        domicilio = new Domicilio(calle, nro, localidad);
	}

	


	public Persona(String apellido, String nombre, String dni, String unaFecha, Domicilio domicilio) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = unaFecha;
		//this.fechaNacimiento = new SimpleDateFormat(unaFecha);  //new SimpleDateFormat("dd/MM/yyyy");
		this.domicilio = domicilio;
	}
	
	


	protected String getApellido() {
		return apellido;
	}
	protected void setApellido(String apellido) {
		this.apellido = apellido;
	}
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}

	protected String getFechaNacimiento() {
		return fechaNacimiento;
	}

	protected void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	protected Domicilio getDomicilio() {
		return domicilio;
	}
	protected void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
	

}
