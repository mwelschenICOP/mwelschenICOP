package Logica;
import java.util.Scanner;

public class Ocupada implements Estado{
	private Mesa mesa;
	
	private static Scanner input = new Scanner(System.in);
	
	@Override
	public void liberar(Mesa mesa) {
		System.out.println("Ingrese el consumo de la mesa: ");
		double consu = input.nextDouble();
		mesa.setConsumo(consu);
		System.out.println("Mesa liberada");
		mesa.setEstado(new Liberada());
	}

	@Override
	public void ocupar(Mesa mesa) {
		try {
			if(mesa.estadoActual() != "Ocupada"){
				mesa.setEstado(new Ocupada());
				System.out.println("Puede ocupar la mesa");
			}	
			else{
				throw new MesaException("La mesa ya se encuentra ocupada");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void reservar(Mesa mesa) {
		System.out.println("La mesa se encuentra ocupada");
	}

	@Override
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;	
	}
}