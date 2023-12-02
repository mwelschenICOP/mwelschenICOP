package Logica;

public interface Estado {

	public void liberar(Mesa mesa);
	
	public void ocupar(Mesa mesa);
	
	public void reservar(Mesa mesa);
	
	public void setMesa(Mesa mesa);

	public void liberar(Mesa mesa, double cons);

}
