package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.DireccionCtrl;
import Controlador.PersonasCtrl;
import Modelo.Direccion;
import Modelo.Personas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class PrincipalIGU extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JTable table;
	
	Direccion dir = new Direccion();
	DireccionCtrl direccion = new DireccionCtrl();
	Personas per = new Personas();
	PersonasCtrl persona = new PersonasCtrl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalIGU frame = new PrincipalIGU();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalIGU() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 797, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Personas");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Vehiculos");
		menuBar.add(mnNewMenu_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 24, 797, 386);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre y Apellido:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 67, 114, 13);
		panel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(122, 65, 266, 19);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(41, 109, 325, 19);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Calle:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 112, 102, 13);
		panel.add(lblNewLabel_1);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(54, 167, 164, 19);
		panel.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Numero:");
		lblNewLabel_2.setBounds(10, 170, 45, 13);
		panel.add(lblNewLabel_2);
		
		JButton btnGuardar = new JButton("Guardar Nuevo");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!"".equals(txtCalle.getText()) || !"".equals(txtNumero.getText()) || !"".equals(txtNombre.getText()));
				dir.setCalle(txtCalle.getText());
				dir.setNumero(Integer.parseInt(txtNumero.getText()));
				
				per.setNombre(txtNombre.getText());
				
				try {
					direccion.RegistrarDireccion(dir);
					
					persona.RegistrarPersona(per);
					JOptionPane.showMessageDialog(null, "Cliente registrado!");
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Hay al menos un campo vacío");
				}
			}
		});
		btnGuardar.setBounds(41, 284, 114, 21);
		panel.add(btnGuardar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(176, 284, 85, 21);
		panel.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(286, 284, 85, 21);
		panel.add(btnEliminar);
		
		table = new JTable();
		table.setBounds(435, 33, 332, 326);
		panel.add(table);
	}
}
