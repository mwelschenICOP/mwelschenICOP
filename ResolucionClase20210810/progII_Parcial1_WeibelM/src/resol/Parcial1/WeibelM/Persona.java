package resol.Parcial1.WeibelM;

enum Genero {F, M};

public class Persona  {

	private String apellido;
	private String nombre;
	private String dni;
	private String fechaNac;
	private Genero miGenero;
	private Domicilio miDomicilio;
	protected String getApellido() {
		return apellido;
	}
	
	
	//Metodo para asociar un domicilio
	
	public Persona(String apellido, String nombre, String dni, String fechaNac, Genero miGenero,
			Domicilio miDomicilio) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNac = fechaNac;
		this.miGenero = miGenero;
		this.miDomicilio = miDomicilio;
	}

	public Persona() {
		
	}
	
	
	public void mostrar() {
		System.out.println(this.getApellido()+", "+this.getNombre());
		this.getMiDomicilio().mostrar();
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
	protected String getFechaNac() {
		return fechaNac;
	}
	protected void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	protected Genero getMiGenero() {
		return miGenero;
	}
	protected void setMiGenero(Genero miGenero) {
		this.miGenero = miGenero;
	}
	protected Domicilio getMiDomicilio() {
		return miDomicilio;
	}
	protected void setMiDomicilio(Domicilio miDomicilio) {
		this.miDomicilio = miDomicilio;
	}
	
	

	
	
}
