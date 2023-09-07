package resol.Parcial1.WeibelM;

enum Cargo {Admistrativo, Especializado, Directivo, AgenteAfiliador};

public class Empleado extends Persona {
	private static int nroLegajo = 999000;
	
	private String fechaInicio;
	private Cargo miCargo;
	
		
	public Empleado(String apellido, String nombre, String dni, String fechaNac, Genero miGenero, Domicilio miDomicilio,
			String fechaInicio, Cargo miCargo) {
		super(apellido, nombre, dni, fechaNac, miGenero, miDomicilio);
		this.fechaInicio = fechaInicio;
		this.miCargo = miCargo;
	}
	

	
	public Empleado() {
		
	};
	
	public void mostrar() {
		super.mostrar();
		System.out.println("Nro. Legajo: "+ this.getNroLegajo()+" desde el "+ this.getFechaInicio()
		    +" tiene el cargo: "+ this.getMiCargo());
	};
	
	protected static int getNroLegajo() {
		return nroLegajo;
	}
	protected static void setNroLegajo(int nroLegajo) {
		Empleado.nroLegajo = nroLegajo;
	}
	protected String getFechaInicio() {
		return fechaInicio;
	}
	protected void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	protected Cargo getMiCargo() {
		return miCargo;
	}
	protected void setMiCargo(Cargo miCargo) {
		this.miCargo = miCargo;
	}
	
	

}
