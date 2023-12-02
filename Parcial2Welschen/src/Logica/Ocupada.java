package Logica;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ocupada implements Estado{
	private Mesa mesa;
	private static Scanner input = new Scanner(System.in);
	
	@Override
	public void liberar(Mesa mesa) {
		System.out.println("Ingrese el consumo de la mesa: ");
		int con=input.nextInt();
		mesa.setConsumo(con);
		String mensaje="La operacion fue realizada satisfactoriamente: "
				+ "Mesa N° "+mesa.getNroMesa()+"\n"
						+ "capacidad: "+mesa.getCapacidad();
		System.out.println(mensaje);
		JOptionPane.showMessageDialog(null, mensaje, "Estado", JOptionPane.INFORMATION_MESSAGE);
		mesa.setEstado(new Liberada());
	}
	@Override
	public void ocupar(Mesa mesa) {
		try {
			if(mesa.estadoActual() != "Ocupada"){
				mesa.setEstado(new Ocupada());
				String mensaje="La operacion fue realizada satisfactoriamente: "
						+ "Mesa N° "+mesa.getNroMesa()+"\n"
								+ "capacidad: "+mesa.getCapacidad();
				System.out.println(mensaje);
				JOptionPane.showMessageDialog(null, mensaje, "Estado", JOptionPane.INFORMATION_MESSAGE);
				mesa.setEstado(new Liberada());
			}	
			else{
				throw new MesaException("La mesa ya se encuentra ocupada");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Estado", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	@Override
	public void reservar(Mesa mesa) {
		String mensaje="La mesa se encuentra ocupada";
		JOptionPane.showMessageDialog(null, mensaje, "Estado", JOptionPane.INFORMATION_MESSAGE);
	}
	@Override
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;	
	}
	@Override
	public void liberar(Mesa mesa, double cons) {
		mesa.setConsumo(cons);
		String mensaje="La operacion fue realizada satisfactoriamente: "
				+ "Mesa N° "+mesa.getNroMesa()+"\n"
						+ "capacidad: "+mesa.getCapacidad();
		System.out.println(mensaje);
		JOptionPane.showMessageDialog(null, mensaje, "Estado", JOptionPane.INFORMATION_MESSAGE);
		mesa.setEstado(new Liberada());
	}
}