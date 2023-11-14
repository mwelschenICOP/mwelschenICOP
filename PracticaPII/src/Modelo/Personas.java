package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Personas {
	private String nombre;
	private Direccion direccion;
	private List<Automoviles> automoviles;
	
	public Personas() {
		super();
	}
	public Personas(String nombre, Direccion direccion, List<Automoviles> automoviles) {
		super();
		this.nombre = nombre;
		this.direccion = new Direccion();
		this.automoviles = new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public List<Automoviles> getAutomoviles() {
		return automoviles;
	}
	public void setAutomoviles(List<Automoviles> automoviles) {
		this.automoviles = automoviles;
	}
}
