package resol.Parcial1.WeibelME;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

enum Cargo {Administrativo, Especializado, Directivo, AgenteAfiliador};

public class Empleado extends Persona {
	
	private static int nroLegajo = 999000;
	private String fechaInicio;
	private Cargo cargoReviste;
	  



public Empleado(String ape, String nom, String dni, String fecNac, String calle, int nro, int codPos, Cargo cargo) {
		super(ape, nom, dni, fecNac, calle, nro, codPos);
		this.nroLegajo++;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaInicio = dtf.format(LocalDateTime.now());
		this.cargoReviste = cargo;
	}	
	
 public Empleado(Cargo cargoReviste) {
			super();
			this.nroLegajo++;
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        this.fechaInicio = dtf.format(LocalDateTime.now());
			this.cargoReviste = cargoReviste;
		}	  
	
	
  public Empleado(String fechaInicio, Cargo cargoReviste) {
		super();
		this.nroLegajo++;
		this.fechaInicio = fechaInicio;
		this.cargoReviste = cargoReviste;
	}
  
  public Empleado()  {
	  
  };
  
  public void mostrar() {
	  System.out.println("Legajo N°: " + this.getNroLegajo()+"  Cargo que reviste: " + this.getCargoReviste().toString()+ " desde: "+ this.getFechaInicio());
	  super.mostrar();
	  System.out.println(" ");
  }
  
  
  
  	protected String getFechaInicio() {
	return fechaInicio;
}

protected void setFechaInicio(String fechaInicio) {
	this.fechaInicio = fechaInicio;
}

	protected int getNroLegajo() {
		return nroLegajo;
	}
	protected void setNroLegajo(int nroLegajo) {
		this.nroLegajo = nroLegajo;
	}

	protected Cargo getCargoReviste() {
		return cargoReviste;
	}
	protected void setCargoReviste(Cargo cargoReviste) {
		this.cargoReviste = cargoReviste;
	}

  
}
