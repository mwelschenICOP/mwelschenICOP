package Logica;

import javax.swing.JOptionPane;

public class Reservada implements Estado{
	private Mesa mesa;
	
	@Override
	public void liberar(Mesa mesa) {
		String mensaje="No puede liberar una mesa reservada";
		JOptionPane.showMessageDialog(null, mensaje, "Estado", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void ocupar(Mesa mesa) {
		String mensaje="La operacion fue realizada satisfactoriamente: "
				+ "Mesa N° "+mesa.getNroMesa()+"\n"
						+ "capacidad: "+mesa.getCapacidad();
		JOptionPane.showMessageDialog(null, mensaje, "Estado", JOptionPane.INFORMATION_MESSAGE);
		mesa.setEstado(new Ocupada());
	}

	@Override
	public void reservar(Mesa mesa) {
		String mensaje="No puede reservar una mesa ya reservada";
		JOptionPane.showMessageDialog(null, mensaje, "Estado", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
}
