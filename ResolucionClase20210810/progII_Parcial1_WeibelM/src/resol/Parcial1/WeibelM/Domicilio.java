package resol.Parcial1.WeibelM;

public class Domicilio {
	
	private String calle;
	private int numeracion;
	private String barrio;
	private int localidad; 
	
	
	
	
	public Domicilio(String calle, int numeracion, String barrio, int localidad) {
		super();
		this.calle = calle;
		this.numeracion = numeracion;
		this.barrio = barrio;
		this.localidad = localidad;
	}
	
	public Domicilio() {
		super();
		
	}
	
	public void mostrar() {
		
		System.out.println(this.getCalle()+ " "+ this.getNumeracion() 
		                 + "("+ this.getBarrio()+") de la localidad de "
				+ ObraSocial.localidadCobertura.get(this.getLocalidad()));
	}
	
	protected String getCalle() {
		return calle;
	}
	protected void setCalle(String calle) {
		this.calle = calle;
	}
	protected int getNumeracion() {
		return numeracion;
	}
	protected void setNumeracion(int numeracion) {
		this.numeracion = numeracion;
	}
	protected String getBarrio() {
		return barrio;
	}
	protected void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	protected int getLocalidad() {
		return localidad;
	}
	protected void setLocalidad(int localidad) {
		this.localidad = localidad;
	}


	
}
