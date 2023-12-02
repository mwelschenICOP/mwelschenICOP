package Gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Control.Control;
import Logica.Mesa;

public class InterfazVistaPorFecha extends JPanel{
	private Control control;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public InterfazVistaPorFecha(Control control) {
		this.control=control;
		repaint();
	}
	public void paint(Graphics g) {
		super.paint(g);
		
		String fech="";
		fech=JOptionPane.showInputDialog("Ingrese la fecha \n (dd/mm/aaaa):");
		ArrayList<Mesa> reservadas =control.verReservadasXFecha(fech);
		//ArrayList<Mesa> dispo = control.verDisponiblesXFecha(fech);
		//ArrayList<Mesa> todas = control.verDisponibles();
		int xPos=0;
		int yPos=0;
		g.setColor(Color.black);
		for (int i=0; i < reservadas.size(); i++) {
			int capa=reservadas.get(i).getNroMesa();
			
			if(i==0){
				 xPos=0;
				 yPos=0;
			}else if(i<5) {
			 xPos=xPos+100;
				}else if (i==5) {
				xPos=0;
				yPos=130;
			}else if (i<10) {
				 xPos=xPos+100;
			}else if (i==10) {
				xPos=0;
				yPos=260;
			}else if (i<15) {
				xPos=xPos+100;
			}else if (i==15) {
				xPos=0;
				yPos=390;
			}else if (i<20) {
				xPos=xPos+100;
			}
			else if (i==20){
				xPos=0;
				yPos=520;
			}else if (i<25) {
				xPos=xPos+100;
			}
			switch (capa) {
			case 8:
				g.fillOval(40+xPos, 10+yPos, 20, 20);
				g.fillOval(60+xPos, 10+yPos, 20, 20);
				g.fillOval(80+xPos, 10+yPos, 20, 20);
				g.fillOval(100+xPos, 10+yPos, 20, 20);
				//if(!reservadas.isEmpty())
				//for(Mesa mesa : reservadas) {
				//if(todas.get(i).getNroMesa()==mesa.getNroMesa()){
					g.setColor(Color.yellow);
					g.fillRoundRect(35+xPos, 40+yPos, 90, 40, 6, 6);
				/*	}
				else {
					g.drawRoundRect(35+xPos, 40+yPos, 90, 40, 6, 6);
				}
				}*/
				g.setColor(Color.black);
				g.fillOval(40+xPos, 90+yPos, 20, 20);
				g.fillOval(60+xPos, 90+yPos, 20, 20);
				g.fillOval(80+xPos,90+yPos, 20, 20);
				g.fillOval(100+xPos, 90+yPos,20, 20);
				break;
			case 6:
				g.fillOval(40+xPos, 10+yPos, 20, 20);
				g.fillOval(60+xPos, 10+yPos, 20, 20);
				g.fillOval(80+xPos, 10+yPos, 20, 20);
				//for(Mesa mesa : reservadas) {
				//	if(todas.get(i).getNroMesa()==mesa.getNroMesa()){
					g.setColor(Color.yellow);
					g.fillRoundRect(35+xPos, 40+yPos, 70, 40, 6, 6);
				/*	}
					else {
						g.drawRoundRect(35+xPos, 40+yPos, 70, 40, 6, 6);
					}
				}*/
				g.setColor(Color.black);
				g.fillOval(40+xPos, 90+yPos, 20, 20);
				g.fillOval(60+xPos, 90+yPos, 20, 20);
				g.fillOval(80+xPos,90+yPos, 20, 20);
				break;
			case 4:
				g.fillOval(40+xPos, 10+yPos, 20, 20);
				g.fillOval(60+xPos, 10+yPos, 20, 20);
			//	for(Mesa mesa : reservadas) {
				//	if(todas.get(i).getNroMesa()==mesa.getNroMesa()){
					g.setColor(Color.yellow);
					g.fillRoundRect(35+xPos, 40+yPos, 50, 40, 6, 6);
					/*}
					else {
						g.drawRoundRect(35+xPos, 40+yPos, 50, 40, 6, 6);
					}
				}*/
				g.setColor(Color.black);
				g.fillOval(40+xPos, 90+yPos, 20, 20);
				g.fillOval(60+xPos, 90+yPos, 20, 20);
				break;
			case 2:
				g.fillOval(48+xPos, 10+yPos, 20, 20);
				//for(Mesa mesa : reservadas) {
				//	if(todas.get(i).getNroMesa()==mesa.getNroMesa()){
					g.setColor(Color.yellow);
					g.fillRoundRect(35+xPos, 40+yPos, 40, 40, 6, 6);
				/*	}
					else {
						g.drawRoundRect(40+xPos, 40+yPos, 40, 40, 6, 6);
					}
					}*/
				g.setColor(Color.black);
				g.fillOval(48+xPos, 90+yPos, 20, 20);
				break;
			default:
				break;
			}
		}
	}
}
