package Logica;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Mesa {
	private Estado state;
	private static int contador = 0;
	private int nroMesa;
	private int capacidad;
	private double consumo;
	private ArrayList<Reserva> listaReservas;
	
	private static Scanner input = new Scanner(System.in);
	
	public Mesa() {
		super();
		contador++;
		this.nroMesa=contador;
		setEstado(new Liberada());
	}
	
	public Mesa( int capacidad, double consumo) {
		super();
		contador++;
		this.nroMesa=contador;
		setEstado(new Liberada());
		this.capacidad = capacidad;
		this.consumo = consumo;
		this.listaReservas = new ArrayList<Reserva>();
	}

	public ArrayList<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
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
		this.nroMesa = nroMesa;
	}

	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public double getConsumo() {
		return consumo;
	}
	public void setConsumo(double consumo) {
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
		this.state = state;
		this.state.setMesa(this);
	}
	
	public String estadoActual() {
		String est="";
		if(this.state instanceof Liberada){
			est="Liberada";
		}else if(this.state instanceof Ocupada) {
			est="Ocupada";
		}else if(this.state instanceof Reservada) {
			est="Reservada";
		}
		return est;
	}
	
	public void reservaFutura(int nro, Date fecha, String nomape, int comen) {
		Reserva reserv = new Reserva(nro, fecha, nomape, comen);
		listaReservas.add(reserv);
	}

	@Override
	public String toString() {
		return "Mesa: "+ nroMesa +", Estado: " + estadoActual() +  ", Capacidad: " + capacidad + ", Consumo:" + consumo
				+ "\n";
	}
	
}