package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import Control.Control;
import Logica.Mesa;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VistaPorFecha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFecha;
	private Control control;
	String fecha="";
	public VistaPorFecha(Control control) {
		this.control=control;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1210, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0,5));
		  String input = JOptionPane.showInputDialog("Ingrese fecha a consultar (dd/mm/aaaa):", "");
		  fecha = input;
		  if(fecha != null) {
			  	List<Mesa> reservada = control.reservadaPorFecha(fecha);
				List<Mesa> disponible = control.librePorFecha(fecha);
				if(reservada.size()==0) {
					for(Mesa m : control.verDisponibles()) {
						int capa=m.getCapacidad();
						switch (capa) {
						case 8:
								  Icon icono = new ImageIcon("src/img/mesa8.png");
								  JButton btn = new JButton(icono);
								  this.ajustarTamano(btn, icono);
								  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa()));
								  btn.setBackground(Color.WHITE);
								  menuOpciones(btn, m);
								  contentPane.add(btn);
							break;
						case 6:
								  Icon icono1 = new ImageIcon("src/img/mesa6.png");
								  JButton btn1 = new JButton(icono1);
								  this.ajustarTamano(btn1, icono1);
								  btn1.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa()));
								  btn1.setBackground(Color.WHITE);
								  menuOpciones(btn1, m);
								  contentPane.add(btn1);
							break;				
						case 4:
								  Icon icono2 = new ImageIcon("src/img/mesa4.png");
								  JButton btn2 = new JButton(icono2);
								  this.ajustarTamano(btn2, icono2);
								  btn2.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa()));
								  btn2.setBackground(Color.WHITE);
								  menuOpciones(btn2, m);
								  contentPane.add(btn2);
							break;
						case 2:
								  Icon icono3 = new ImageIcon("src/img/mesa2.png");
								  JButton btn3 = new JButton(icono3);
								  this. ajustarTamano(btn3, icono3);
								  btn3.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa()));
								  btn3.setBackground(Color.WHITE);
								  menuOpciones(btn3, m);
								  contentPane.add(btn3);
							break;
						default:
							break;
						
						}
					}
				}else {
				for(Mesa m : reservada) {
					int capa=m.getCapacidad();
					switch (capa) {
					case 8:
							  Icon icono = new ImageIcon("src/img/mesa8reservada.png");
							  JButton btn = new JButton(icono);
							  this.ajustarTamano(btn, icono);
							  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa()));
							  btn.setBackground(Color.WHITE);
							  
							  contentPane.add(btn);
						break;
					case 6:
							  Icon icono1 = new ImageIcon("src/img/mesa6reservada.png");
							  JButton btn1 = new JButton(icono1);
							  this.ajustarTamano(btn1, icono1);
							  btn1.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa()));
							  btn1.setBackground(Color.WHITE);
							
							  contentPane.add(btn1);
						break;				
					case 4:
							  Icon icono2 = new ImageIcon("src/img/mesa4reservada.png");
							  JButton btn2 = new JButton(icono2);
							  this.ajustarTamano(btn2, icono2);
							  btn2.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa()));
							  btn2.setBackground(Color.WHITE);
							
							  contentPane.add(btn2);
						break;
					case 2:
							  Icon icono3 = new ImageIcon("src/img/mesa2reservada.png");
							  JButton btn3 = new JButton(icono3);
							  this. ajustarTamano(btn3, icono3);
							  btn3.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa()));
							  btn3.setBackground(Color.WHITE);
							 
							  contentPane.add(btn3);
						break;
					default:
						break;
					
					}
				}
				for(Mesa m : disponible) {
					int capa=m.getCapacidad();
					switch (capa) {
					case 8:
							  Icon icono = new ImageIcon("src/img/mesa8.png");
							  JButton btn = new JButton(icono);
							  this.ajustarTamano(btn, icono);
							  btn.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa()));
							  btn.setBackground(Color.WHITE);
							  menuOpciones(btn, m);
							  contentPane.add(btn);
						break;
					case 6:
							  Icon icono1 = new ImageIcon("src/img/mesa6.png");
							  JButton btn1 = new JButton(icono1);
							  this.ajustarTamano(btn1, icono1);
							  btn1.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa()));
							  btn1.setBackground(Color.WHITE);
							  menuOpciones(btn1, m);
							  contentPane.add(btn1);
						break;				
					case 4:
							  Icon icono2 = new ImageIcon("src/img/mesa4.png");
							  JButton btn2 = new JButton(icono2);
							  this.ajustarTamano(btn2, icono2);
							  btn2.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa()));
							  btn2.setBackground(Color.WHITE);
							  menuOpciones(btn2, m);
							  contentPane.add(btn2);
						break;
					case 2:
							  Icon icono3 = new ImageIcon("src/img/mesa2.png");
							  JButton btn3 = new JButton(icono3);
							  this. ajustarTamano(btn3, icono3);
							  btn3.setToolTipText("Mesa: "+String.valueOf(m.getNroMesa()));
							  btn3.setBackground(Color.WHITE);
							  menuOpciones(btn3, m);
							  contentPane.add(btn3);
						break;
					default:
						break;
					
					}
				}
				}
			} else {
			   JOptionPane.showMessageDialog(null, "Ingreso cancelado");
			}
					
				}	
			
	public void ajustarTamano(JButton boton, Icon icono) {
		  boton.setPreferredSize(new Dimension(icono.getIconWidth(), 
		                                       icono.getIconHeight())); 
		}
	public void menuOpciones(JButton btn,Mesa m) {
		 JPopupMenu menu = new JPopupMenu();
			  JMenuItem reservar = new JMenuItem("Reservar");
			  reservar.addActionListener (new ActionListener(){
				  public void actionPerformed(ActionEvent e) {
					  String input = JOptionPane.showInputDialog("Ingrese su nombre y apellido", "");
					  if(input != null) {
						  control.reservarMesa(m.getCapacidad(), fecha, input, m.getNroMesa());
						  JOptionPane.showMessageDialog(null, 
					              "La reserva se ha guardado correctamente",
					              "Reserva",
					              JOptionPane.INFORMATION_MESSAGE);
						  dispose();
			  VistaPorFecha act= new VistaPorFecha(control);
				act.setResizable(false);
				act.pack();
			    act.setVisible(true);
					  }
				  }
			 } );
			  menu.add(reservar);
			  btn.setComponentPopupMenu(menu);
	}
}