package Logica;

import javax.swing.JOptionPane;

public class Ocupada implements Estado{
	private Mesa mesa;
	
	
	@Override
	public void liberar(Mesa mesa) {
		String mensaje="La operacion fue realizada satisfactoriamente: "
				+ "Mesa N° "+mesa.getNroMesa()+"\n"
						+ "capacidad: "+mesa.getCapacidad();
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
}