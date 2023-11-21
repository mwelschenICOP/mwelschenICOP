package Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Control;
import Logica.Mesa;
import javax.swing.SpringLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

public class InterfazVista extends JPanel {
	private Control control;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public InterfazVista(Control control) {
		this.control=control;

		repaint();
	}
		
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		
		ArrayList<Mesa> mesas = control.verDisponibles();
		int xPos=0;
		int yPos=0;
		
		for (int i=0; i < mesas.size(); i++) {
			int capa=mesas.get(i).getCapacidad();
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
				if(mesas.get(i).estadoActual().equals("Ocupada")) {
					g.setColor(Color.red);
					g.fillRoundRect(35+xPos, 40+yPos, 90, 40, 6, 6);
				}else if(mesas.get(i).estadoActual().equals("Reservada")) {
					g.setColor(Color.yellow);
					g.fillRoundRect(35+xPos, 40+yPos, 90, 40, 6, 6);
				}else {
					g.setColor(Color.black);
				g.drawRoundRect(35+xPos, 40+yPos, 90, 40, 6, 6);
				}g.setColor(Color.black);
				g.fillOval(40+xPos, 90+yPos, 20, 20);
				g.fillOval(60+xPos, 90+yPos, 20, 20);
				g.fillOval(80+xPos,90+yPos, 20, 20);
				g.fillOval(100+xPos, 90+yPos,20, 20);
				break;
			case 6:
				g.fillOval(40+xPos, 10+yPos, 20, 20);
				g.fillOval(60+xPos, 10+yPos, 20, 20);
				g.fillOval(80+xPos, 10+yPos, 20, 20);
				if(mesas.get(i).estadoActual().equals("Ocupada")) {
					g.setColor(Color.red);
					g.fillRoundRect(35+xPos, 40+yPos, 70, 40, 6, 6);
				}else if(mesas.get(i).estadoActual().equals("Reservada")) {
					g.setColor(Color.yellow);
					g.fillRoundRect(35+xPos, 40+yPos, 70, 40, 6, 6);
				}else {
					g.setColor(Color.black);
					g.drawRoundRect(35+xPos, 40+yPos, 70, 40, 6, 6);
				}g.setColor(Color.black);
				g.fillOval(40+xPos, 90+yPos, 20, 20);
				g.fillOval(60+xPos, 90+yPos, 20, 20);
				g.fillOval(80+xPos,90+yPos, 20, 20);
				break;
				
			case 4:
				g.fillOval(40+xPos, 10+yPos, 20, 20);
				g.fillOval(60+xPos, 10+yPos, 20, 20);
				if(mesas.get(i).estadoActual().equals("Ocupada")) {
					g.setColor(Color.red);
					g.fillRoundRect(35+xPos, 40+yPos, 50, 40, 6, 6);
				}else if(mesas.get(i).estadoActual().equals("Reservada")) {
					g.setColor(Color.yellow);
					g.fillRoundRect(35+xPos, 40+yPos, 50, 40, 6, 6);
				}else {
					g.setColor(Color.black);
					g.drawRoundRect(35+xPos, 40+yPos, 50, 40, 6, 6);
				}g.setColor(Color.black);
				g.fillOval(40+xPos, 90+yPos, 20, 20);
				g.fillOval(60+xPos, 90+yPos, 20, 20);
				break;
			case 2:
				g.fillOval(48+xPos, 10+yPos, 20, 20);
				if(mesas.get(i).estadoActual().equals("Ocupada")) {
					g.setColor(Color.red);
					g.fillRoundRect(35+xPos, 40+yPos, 40, 40, 6, 6);
				}else if(mesas.get(i).estadoActual().equals("Reservada")) {
					g.setColor(Color.yellow);
					g.fillRoundRect(35+xPos, 40+yPos, 40, 40, 6, 6);
				}else {
					g.setColor(Color.black);
					g.drawRoundRect(40+xPos, 40+yPos, 40, 40, 6, 6);
				}g.setColor(Color.black);
				g.fillOval(48+xPos, 90+yPos, 20, 20);
				break;
			default:
				break;
			
			}
		}
	}

}
