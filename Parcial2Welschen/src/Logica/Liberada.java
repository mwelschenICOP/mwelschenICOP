package Logica;

import javax.swing.JOptionPane;

public class Liberada implements Estado{
	private Mesa mesa;

	@Override
	public void liberar(Mesa mesa) {
		String mensaje="La mesa ya se encuentra liberada ";
		System.out.println(mensaje);
		JOptionPane.showMessageDialog(null, mensaje, "Estado", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void ocupar(Mesa mesa) {
		String mensaje="La operacion fue realizada satisfactoriamente: "
				+ "Mesa N° "+mesa.getNroMesa()+"\n"
						+ "capacidad: "+mesa.getCapacidad();
		System.out.println(mensaje);
		JOptionPane.showMessageDialog(null, mensaje, "Estado", JOptionPane.INFORMATION_MESSAGE);
		mesa.setEstado(new Ocupada());
	}

	@Override
	public void reservar(Mesa mesa) {
		String mensaje="La operacion fue realizada satisfactoriamente: "
								+ "Mesa N° "+mesa.getNroMesa()+"\n"
										+ "capacidad: "+mesa.getCapacidad();
		System.out.println(mensaje);
		JOptionPane.showMessageDialog(null, mensaje, "Reserva", JOptionPane.INFORMATION_MESSAGE);
		mesa.setEstado(new Reservada());
	}

	@Override
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	@Override
	public void liberar(Mesa mesa, double cons) {
	}
}
