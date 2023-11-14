package Logica;
import java.util.Scanner;

public class Mesa {
	private Estado state;
	private static int nroMesa;
	private int capacidad;
	private int consumo;
	
	private static Scanner input = new Scanner(System.in);
	
	public Mesa() {
		super();
	}
	
	public Mesa(Estado state, int capacidad, int consumo) {
		super();
		this.state = state;
		this.setNroMesa(nroMesa);
		this.capacidad = capacidad;
		this.consumo = consumo;
	}
	

	public Estado getState() {
		return state;
	}
	public void setState(Estado state) {
		this.state = state;
	}
	public int getNroMesa() {
		return nroMesa;
	}
	public void setNroMesa(int nroMesa) {
		Mesa.nroMesa = nroMesa;
		nroMesa	= nroMesa+1;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getConsumo() {
		return consumo;
	}
	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}
	public void liberar() {
		this.state.liberar(this);
	}
	public void reservar() {
		this.state.reservar(this);
	}
	public void ocupar() {
		this.state.ocupar(this);
	}
	public void setEstado(Estado state) {
		 //Estado est = new ();
	}

	public void nuevaMesa() {
		System.out.println("Ingrese la capacidad");
		int cap = input.nextInt();
		int consu = 0;
		System.out.println("Ingrese la cantidad de mesas");
		int cant =input.nextInt();
		 	for (int i = 0; i < cant; i++) {
		Mesa mesa = new Mesa(this.state, cap, consu);
		mesa.setConsumo(consu);
		mesa.setCapacidad(cap);
		mesa.setState(state);
		 Resto resto = new Resto();
		resto.agregarMesas(mesa);
		 	}
	}

	
}