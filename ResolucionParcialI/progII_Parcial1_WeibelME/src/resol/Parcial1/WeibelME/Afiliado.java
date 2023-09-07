package resol.Parcial1.WeibelME;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Afiliado extends Persona {
	
	private static int nroAdhesion = 0;
	private String fechaAdhesion;
	private Boolean tieneAfeccion;
	private PlanCobertura planCobertura;
	private Empleado afiliador;
	
	public Afiliado(SimpleDateFormat fechaAdhesion, Boolean tieneAfeccion) {
		super();
		this.nroAdhesion++;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaAdhesion = dtf.format(LocalDateTime.now());
		this.tieneAfeccion = tieneAfeccion;
		
	}
	
	public Afiliado(String ape, String nom, String dni, String fecNac, String calle, int nro, int codPos, boolean afecPrev, PlanCobertura plan, Empleado agente) {
		super(ape, nom, dni, fecNac, calle, nro, codPos);
		this.nroAdhesion++;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaAdhesion = dtf.format(LocalDateTime.now());
		this.setTieneAfeccion(afecPrev);
		this.setPlanCobertura(plan);
		this.setAfiliador(agente);
	}
	
	public Afiliado(int nroAdhesion, String fechaAdhesion, Boolean tieneAfeccion, PlanCobertura planCobertura,
			Empleado afiliador) {
		super();
		this.nroAdhesion = nroAdhesion;
		this.fechaAdhesion = fechaAdhesion;
		this.tieneAfeccion = tieneAfeccion;
		this.planCobertura = planCobertura;
		this.afiliador = afiliador;
	}
	

	public void mostrar() {
		  System.out.println("Afiliado N�: " + this.getNroAdhesion()+" desde: "+ this.getFechaAdhesion() + " - PLAN: "+ this.getPlanCobertura().toString());
		  super.mostrar();
		  System.out.print("Agente afiliador: ");
		  this.getAfiliador().mostrar();
		  System.out.println(" ");
	}
	
	
	
	
	protected String getFechaAdhesion() {
		return fechaAdhesion;
	}

	protected void setFechaAdhesion(String fechaAdhesion) {
		this.fechaAdhesion = fechaAdhesion;
	}

	protected int getNroAdhesion() {
		return nroAdhesion;
	}
	protected void setNroAdhesion(int nroAdhesion) {
		this.nroAdhesion = nroAdhesion;
	}
	
	protected Boolean getTieneAfeccion() {
		return tieneAfeccion;
	}
	protected void setTieneAfeccion(Boolean tieneAfeccion) {
		this.tieneAfeccion = tieneAfeccion;
	}
	protected PlanCobertura getPlanCobertura() {
		return planCobertura;
	}
	protected void setPlanCobertura(PlanCobertura planCobertura) {
		this.planCobertura = planCobertura;
	}
	

	protected Empleado getAfiliador() {
		return afiliador;
	}
	protected void setAfiliador(Empleado afiliador) {
		this.afiliador = afiliador;
	}


}
