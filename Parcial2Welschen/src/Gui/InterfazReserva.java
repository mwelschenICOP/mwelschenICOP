package Gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import Control.Control;
import Logica.Mesa;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;


public class InterfazReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCant;
	private JTextField txtFecha;
	private JTable table;
	private JTextField txtNombre;
	private DefaultTableModel modeloTabla;
	private Control control;
	private JTextField txtNroMesa;
	
	

	public InterfazReserva(Control control) {
		this.control=control;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 616, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad de comensales:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(50, 30, 150, 25);
		contentPane.add(lblNewLabel);
		
		txtCant = new JTextField();
		txtCant.setToolTipText("");
		txtCant.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numero = (key >=48 && key<=57);
				if (!numero) {
					e.consume();
				}
			}	
		});
		txtCant.setBounds(193, 34, 39, 19);
		contentPane.add(txtCant);
		txtCant.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Fecha (dd/mm/aaaa):");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(50, 79, 128, 13);
		contentPane.add(lblNewLabel_1);
		
		txtFecha = new JTextField();
		txtFecha.setToolTipText("");
		txtFecha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numero = (key >=48 && key<=57 || key==47);
				if (!numero) {
					e.consume();
				}
			}	
		});
		txtFecha.setBounds(50, 102, 182, 19);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int cant = Integer.parseInt(txtCant.getText());
				String fecha = txtFecha.getText();
				if(fecha.isEmpty()) {
				for (Mesa mesa : control.verDisponibles(cant)) {
					int nroMesa = mesa.getNroMesa();
					int capa = mesa.getCapacidad();
					String estado = "Libre";
					modeloTabla.addRow(new Object[] {nroMesa, capa, estado});
				}
				}else {
				for (Mesa mesa : control.verDisponibles(cant, fecha)){
					int nroMesa = mesa.getNroMesa();
					int capa = mesa.getCapacidad();
					String estado = "Libre";
					modeloTabla.addRow(new Object[] {nroMesa, capa, estado});
				}
				}
			}
		});
		btnBuscar.setBounds(120, 147, 112, 21);
		contentPane.add(btnBuscar);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("");
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean letra = (key >=65 && key<=99 || key >=97 && key<=122 || key ==32 || key ==165|| key ==164);
				if (!letra) {
					e.consume();
				}
			}	
		});
		txtNombre.setBounds(48, 213, 184, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnReserv = new JButton("Reservar");
		btnReserv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int cant = Integer.parseInt(txtCant.getText());
				String fecha = txtFecha.getText();
				String nombre = txtNombre.getText();
				int mesa = Integer.parseInt(txtNroMesa.getText());
				if(fecha.isEmpty()) {
					control.reservarMesa(mesa);
					modeloTabla.removeRow(table.getSelectedRow());					
					((DefaultTableModel) table.getModel()).setRowCount(0);
				}else {
				control.reservarMesa(cant, fecha, nombre, mesa);
				modeloTabla.removeRow(table.getSelectedRow());
				String mensaje="La operacion fe realizada satisfactoriamente: \n"
						+ "Fecha: "+fecha +"\n"
								+ "A nombre de: "+nombre+"\n"
										+ "Mesa N° "+mesa+"\n"
												+ "cantidad de comensales: "+cant;
				JOptionPane.showMessageDialog(null, mensaje, "Reserva", JOptionPane.INFORMATION_MESSAGE);
				
				((DefaultTableModel) table.getModel()).setRowCount(0);
				}
			}
		});
		btnReserv.setBounds(119, 296, 113, 21);
		contentPane.add(btnReserv);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre y apellido:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(50, 178, 140, 13);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Mesas libres", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(262, 10, 330, 457);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane spReservas = new JScrollPane();
		spReservas.setBounds(10, 21, 310, 426);
		panel.add(spReservas);
		
		 modeloTabla = new DefaultTableModel(new Object[]{"Mesa", "Capacidad", "Estado"}, 0) {
		
			private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
             return false;
		 }
		};
        
		
		table = new JTable(modeloTabla);
		table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer());
		spReservas.setViewportView(table);
		table.setRowHeight(20);
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent Mouse_evt) {
				Point point=Mouse_evt.getPoint();
				int row = table.rowAtPoint(point);
				if(Mouse_evt.getClickCount()==1) {
					txtNroMesa.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				}
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Mesa N°:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(54, 255, 58, 13);
		contentPane.add(lblNewLabel_3);
		
		txtNroMesa = new JTextField();
		txtNroMesa.setEditable(false);
		txtNroMesa.setBounds(112, 253, 120, 19);
		contentPane.add(txtNroMesa);
		txtNroMesa.setColumns(10);
	}
}
