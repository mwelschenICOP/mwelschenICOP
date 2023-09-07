package resol.EjemploParcial;

import java.util.HashMap;
import java.util.Map;

public class ObraSocial {
	private String razonSocial;
	private Plan plan;
	private Domicilio domicilio;
	private Map<Integer, String> Localidad;
	
	public ObraSocial(String razonSocial, Plan plan, Domicilio domicilio, Map<Integer, String> localidad) {
		super();
		this.razonSocial = razonSocial;
		this.plan = plan;
		this.domicilio = domicilio;
		Localidad = localidad;
	}

	public ObraSocial() {
		super();
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Map<Integer, String> getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(Map<Integer, String> localidad) {
		Localidad = localidad;
	}

}
