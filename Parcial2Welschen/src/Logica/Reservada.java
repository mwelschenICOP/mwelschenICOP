package Logica;

public class Reservada implements Estado{
	private Mesa mesa;
	@Override
	public void liberar(Mesa mesa) {
		System.out.println("No se puede liberar una mesa reservada");
	}

	@Override
	public void ocupar(Mesa mesa) {
		System.out.println("Perfecto, puede ocupar la mesa");
		mesa.setEstado(new Ocupada());
	}

	@Override
	public void reservar(Mesa mesa) {
		System.out.println("La mesa ya se encuentra reservada");
	}

	@Override
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
}
