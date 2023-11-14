package Modelo;


public class Direccion {
	private int idDireccion;
	private String calle;
	private int numero;
	
	public Direccion() {
		super();
	}
	public Direccion(int idDireccion, String calle, int numero) {
		super();
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.numero = numero;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getIdDireccion() {
		
		return idDireccion;
	}
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}
	
}
