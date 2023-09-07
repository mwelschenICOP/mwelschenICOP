package resol.Parcial1.WeibelME;

import java.util.HashMap;

public class Domicilio {

	
	private String calle;
	private int numero;
	private int localidad;
	
		
	public Domicilio() {
		super();
	}
	
	public Domicilio(String calle, int numero, int localidad) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
	}
	
	public void mostrar(String localidad) {
		System.out.println(this.getCalle()+" N° "+ this.getNumero()+" en la localidad de "+ localidad);
	}
	
	public void mostrar() {
		System.out.println(this.getCalle()+" N° "+ this.getNumero()+" en la localidad de "+ localidad);
	}
	
	protected String getCalle() {
		return calle;
	}
	protected void setCalle(String calle) {
		this.calle = calle;
	}
	protected int getNumero() {
		return numero;
	}
	protected void setNumero(int numero) {
		this.numero = numero;
	}
	protected int getLocalidad() {
		return localidad;
	}
	protected void setLocalidad(int localidad) {
		this.localidad = localidad;
	}
	
	
	
}
