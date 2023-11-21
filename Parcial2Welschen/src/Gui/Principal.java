package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Control.Control;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Principal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Control control;
	private JMenuItem mnAcerca;

	

	public Principal(Control control) {
		this.control=control;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 436, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Reserva");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mnNewMenu.add(mntmRegistrar);
		mntmRegistrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfazReserva res = new InterfazReserva(control);
				res.setVisible(true);
			}
		});
		JMenu mnNewMenu_1 = new JMenu("Gestión");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Alta mesa");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					    InterfazAlta alta = new InterfazAlta(control); 
					    alta.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Baja mesa");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					    InterfazBaja baja = new InterfazBaja(control); 
					    baja.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_2 = new JMenu("Info");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Vista actual");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame jf = new JFrame("Vista Actual");
				jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				InterfazVista act= new InterfazVista(control);
				act.setBackground(Color.white);
				jf.add(act);
				jf.setSize(600,700);
			    jf.setPreferredSize(new Dimension(600,700));
				jf.setVisible(true);	
				jf.pack();}
		});
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Vista por fecha");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
				JFrame jf1 = new JFrame("Vista por fecha");
				jf1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				InterfazVistaPorFecha act1= new InterfazVistaPorFecha(control);
				act1.setBackground(Color.white);
				jf1.add(act1);
				jf1.setSize(600,700);
			    jf1.setPreferredSize(new Dimension(600,700));
				jf1.setVisible(true);	
				jf1.pack();
			}
		});
		JMenuItem miAcerca = new JMenuItem("Acerca de");
		mnNewMenu_2.add(miAcerca);
		String mensaje= "Alumno: Marcos Welschen \n" + "2do Examen parcial Programacion II \n" + "14/11/2023";
		miAcerca.addActionListener(e -> {
		    JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
		});
		
		JMenu mnNewMenu_3 = new JMenu("Salir");
		menuBar.add(mnNewMenu_3);
		mnNewMenu_3.addMenuListener((MenuListener) new MenuListener() {

		    @Override
		    public void menuSelected(MenuEvent e) {
		        System.exit(0);  
		    }

			@Override
			public void menuDeselected(MenuEvent e) {
			}

			@Override
			public void menuCanceled(MenuEvent e) {
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
