package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import Control.Control;
import Logica.Mesa;
import Logica.Resto;

public class VistaActual extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Control control;
	

	public VistaActual(Control control) {
		this.control=control;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 788, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	
		contentPane.setLayout(new GridLayout(0,5));
		
		List<Mesa> mesa = control.verDisponibles(); 
		for(Mesa m : mesa) {
			int capa=m.getCapacidad();
			switch (capa) {
			case 8:
				  if(m.estadoActual()=="Ocupada") {
					  Icon icono = new ImageIcon("src/img/mesa8ocupada.png");
					  JButton btn = new JButton(icono);
					  this.ajustarTamano(btn, icono);
					  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa())+ " " + m.estadoActual());
					  btn.setBackground(Color.WHITE);
					  menuOpciones(btn, m);
					  contentPane.add(btn);
				  }else if(m.estadoActual()=="Reservada") {
					  Icon icono = new ImageIcon("src/img/mesa8reservada.png");
					  JButton btn = new JButton(icono);
					  this.ajustarTamano(btn, icono);
					  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa())+ " " + m.estadoActual());
					  btn.setBackground(Color.WHITE);
					  menuOpciones(btn, m);
					  contentPane.add(btn);
				  }else {
				  Icon icono = new ImageIcon("src/img/mesa8.png");
				  JButton btn = new JButton(icono);
				  this.ajustarTamano(btn, icono);
				  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa())+ " " + m.estadoActual());
				  btn.setBackground(Color.WHITE);
				  menuOpciones(btn, m);
				  contentPane.add(btn);
				  }
				break;
			case 6:
				  if(m.estadoActual()=="Ocupada") {
					  Icon icono = new ImageIcon("src/img/mesa6ocupada.png");
					  JButton btn = new JButton(icono);
					  this.ajustarTamano(btn, icono);
					  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa())+ " " + m.estadoActual());
					  btn.setBackground(Color.WHITE);
					  menuOpciones(btn, m);
					  contentPane.add(btn);
				  }else if(m.estadoActual()=="Reservada") {
					  Icon icono = new ImageIcon("src/img/mesa6reservada.png");
					  JButton btn = new JButton(icono);
					  this.ajustarTamano(btn, icono);
					  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa())+ " " + m.estadoActual());
					  btn.setBackground(Color.WHITE);
					  menuOpciones(btn, m);
					  contentPane.add(btn);
				  }else {
				  Icon icono = new ImageIcon("src/img/mesa6.png");
				  JButton btn = new JButton(icono);
				  this.ajustarTamano(btn, icono);
				  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa())+ " " + m.estadoActual());
				  btn.setBackground(Color.WHITE);
				  menuOpciones(btn, m);
				  contentPane.add(btn);
				  }
				break;				
			case 4:
				  if(m.estadoActual()=="Ocupada") {
					  Icon icono = new ImageIcon("src/img/mesa4ocupada.png");
					  JButton btn = new JButton(icono);
					  this.ajustarTamano(btn, icono);
					  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa())+ " " + m.estadoActual());
					  btn.setBackground(Color.WHITE);
					  menuOpciones(btn, m);
					  contentPane.add(btn);
				  }else if(m.estadoActual()=="Reservada") {
					  Icon icono = new ImageIcon("src/img/mesa4reservada.png");
					  JButton btn = new JButton(icono);
					  this.ajustarTamano(btn, icono);
					  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa())+ " " + m.estadoActual());
					  btn.setBackground(Color.WHITE);
					  menuOpciones(btn, m);
					  contentPane.add(btn);
				  }else {
				  Icon icono = new ImageIcon("src/img/mesa4.png");
				  JButton btn = new JButton(icono);
				  this.ajustarTamano(btn, icono);
				  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa())+ " " + m.estadoActual());
				  btn.setBackground(Color.WHITE);
				  menuOpciones(btn, m);
				  contentPane.add(btn);
				  }
				break;
			case 2:
				  if(m.estadoActual()=="Ocupada") {
					  Icon icono = new ImageIcon("src/img/mesa2ocupada.png");
					  JButton btn = new JButton(icono);
					  this.ajustarTamano(btn, icono);
					  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa())+ " " + m.estadoActual());
					  btn.setBackground(Color.WHITE);
					  menuOpciones(btn, m);
					  contentPane.add(btn);
				  }else if(m.estadoActual()=="Reservada") {
					  Icon icono = new ImageIcon("src/img/mesa2reservada.png");
					  JButton btn = new JButton(icono);
					  this.ajustarTamano(btn, icono);
					  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa())+ " " + m.estadoActual());
					  btn.setBackground(Color.WHITE);
					  menuOpciones(btn, m);
					  contentPane.add(btn);
				  }else {
				  Icon icono = new ImageIcon("src/img/mesa2.png");
				  JButton btn = new JButton(icono);
				  this.ajustarTamano(btn, icono);
				  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa())+ " " + m.estadoActual());
				  btn.setBackground(Color.WHITE);
				  menuOpciones(btn, m);
				  contentPane.add(btn);
				  }
				break;
			default:
				break;
			
			}
		}
	}
	public void ajustarTamano(JButton boton, Icon icono) {
		  boton.setPreferredSize(new Dimension(icono.getIconWidth(), 
		                                       icono.getIconHeight())); 
		}
	public void menuOpciones(JButton btn,Mesa m) {
		 JPopupMenu menu = new JPopupMenu();
		 if(m.estadoActual()=="Ocupada") {
		  JMenuItem liberar = new JMenuItem("Liberar");
		  liberar.addActionListener (new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
		  String input = JOptionPane.showInputDialog("Ingrese consumo de la mesa:", "");
		  int cons = -1;
		  if(input != null) {
			  cons = Integer.parseInt(input);
			  control.liberarMesa(cons, m.getNroMesa());
			  dispose();
			  VistaActual act= new VistaActual(control);
				act.setResizable(false);
				act.pack();
			    act.setVisible(true);
			} else {
			   JOptionPane.showMessageDialog(null, "Ingreso cancelado");
			}
		 
			  }
			});
		  menu.add(liberar);
		  btn.setComponentPopupMenu(menu);
		 }else if(m.estadoActual()=="Liberada") {
			 JMenuItem ocupar = new JMenuItem("Ocupar");
			  ocupar.addActionListener( e -> {control.ocuparMesa(m.getNroMesa()); 
			  this.dispose();
			  VistaActual act= new VistaActual(control);
				act.setResizable(false);
				act.pack();
			    act.setVisible(true);
			  }); 
			  JMenuItem reservar = new JMenuItem("Reservar");
			  reservar.addActionListener( e -> {control.reservarMesa(m.getNroMesa());
			  this.dispose();
			  VistaActual act= new VistaActual(control);
				act.setResizable(false);
				act.pack();
			    act.setVisible(true);
			  } );
			  
			  menu.add(ocupar);
			  menu.add(reservar);
			  btn.setComponentPopupMenu(menu);
		 }else {
			 JMenuItem ocupar = new JMenuItem("Ocupar");
			  ocupar.addActionListener( e -> {control.ocuparMesa(m.getNroMesa());
			  this.dispose();
			  VistaActual act= new VistaActual(control);
				act.setResizable(false);
				act.pack();
			    act.setVisible(true);
			  } );
			  menu.add(ocupar);
			  btn.setComponentPopupMenu(menu);
		 }
	}
}
