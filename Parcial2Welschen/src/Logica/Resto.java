package Logica;

import java.util.ArrayList;

public class Resto {
	public static int id;
	private String nombre;
	private String calle;
	private String ciudad;
	private ArrayList<Mesa> listaMesas;
	
	public Resto() {
		super();
	}
	public Resto(String nombre, String calle, String ciudad, ArrayList<Mesa> listaMesas) {
		super();
		this.setId(id);
		this.nombre = nombre;
		this.calle = calle;
		this.ciudad = ciudad;
		this.listaMesas = new ArrayList<Mesa>(0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		Resto.id = id;
		id=id+1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public ArrayList<Mesa> getListaMesas() {
		return listaMesas;
	}

	public void setListaMesas(ArrayList<Mesa> listaMesas) {
		this.listaMesas = listaMesas;
	}
	public void agregarMesas(Mesa mesa) {
		listaMesas.add(mesa);
	}
	public void listarMesas() {
		for (int i = 0; i <listaMesas.size(); i++) {
		
	}
	}
}
