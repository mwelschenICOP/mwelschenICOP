package Logica;

public class Liberada implements Estado{
	private Mesa mesa;

	@Override
	public void liberar(Mesa mesa) {
		System.out.println("La mesa ya se encuentra libre");
	}

	@Override
	public void ocupar(Mesa mesa) {
		System.out.println("Puede ocupar la mesa");
		mesa.setEstado(new Ocupada());
	}

	@Override
	public void reservar(Mesa mesa) {
		System.out.println("Perfecto, mesa reservada");
		mesa.setEstado(new Reservada());
	}

	@Override
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	

}
