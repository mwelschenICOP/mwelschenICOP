package Logica;

public class Mesa {
	private Estado state;
	private static int contador = 0;
	private int nroMesa;
	private int capacidad;
	private double consumo;

	public Mesa(int nroMesa,Estado state, int capacidad, double consumo) {
		super();
		this.nroMesa=nroMesa;
		this.state=state;
		this.capacidad=capacidad;
		this.consumo=consumo;
	}
	public Mesa() {
		super();
		contador++;
		this.nroMesa=contador;
		this.state=new Liberada();
	}
	public Mesa( int capacidad, double consumo) {
		super();
		contador++;
		this.nroMesa=contador;
		this.state=new Liberada();
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
		this.consumo+=consumo;
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
	
	@Override
	public String toString() {
		return "Mesa: "+ nroMesa +", Estado: " + estadoActual() +  ", Capacidad: " + capacidad + ", Consumo:" + consumo
				+ "\n";
	}

	public void setEstado(String string) {
		this.estadoActual();
	}
	public void liberar(double cons) {
		this.state.liberar(this, cons);;
		
	}
}