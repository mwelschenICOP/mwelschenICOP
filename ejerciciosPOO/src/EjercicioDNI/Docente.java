package EjercicioDNI;

import java.util.Date;

public class Docente extends Persona {

	private int legajo;
	private Date fechaIngreso;
		public Docente(String nombre, String apellido, DNI unDni, int legajo, Date fechaIngreso) {
		super(nombre, apellido, unDni);
		this.legajo = legajo;
		this.fechaIngreso = fechaIngreso;
	}
		public Docente() {
		super();
	}
		public Docente(String nombre, String apellido, DNI unDni) {
		super(nombre, apellido, unDni);
		
	}

	
	
}
