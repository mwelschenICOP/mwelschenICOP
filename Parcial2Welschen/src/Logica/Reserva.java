package Logica;

import java.util.Date;

public class Reserva {
	private static int con = 0;
	private int idRes;
	private Date fecha;
	private String nombreApellido;
	private int cantComensales;
	private Mesa mesa;
	
	public Reserva(Date fecha, String nombreApellido, int cantComensales, Mesa mesa) {
		super();
		con++;
		this.idRes=con;
		this.fecha = fecha;
		this.nombreApellido = nombreApellido;
		this.cantComensales = cantComensales;
		this.mesa = mesa;
	}
	

	public Reserva() {
		super();
		con++;
		this.idRes=con;
	}

	public Reserva(int nro, Date fecha, String nomape, int comen) {
		super();
		con++;
		this.idRes=con;
		this.fecha = fecha;
		this.nombreApellido = nomape;
		this.cantComensales = comen;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public int getCantComensales() {
		return cantComensales;
	}

	public void setCantComensales(int cantComensales) {
		this.cantComensales = cantComensales;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	
}
