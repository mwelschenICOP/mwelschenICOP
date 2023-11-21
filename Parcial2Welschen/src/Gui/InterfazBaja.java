package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Control.Control;
import Logica.Mesa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

public class InterfazBaja extends JFrame {
	private JTable table;
	private DefaultTableModel modeloTabla;
	private Control control;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtnMesa;

	public InterfazBaja(Control control) {
		this.control=control;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 506, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Mesas liberadas", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(153, 10, 329, 411);
		contentPane.add(panel);
		panel.setLayout(null);
		JScrollPane spBajas = new JScrollPane();
		spBajas.setBounds(10, 21, 309, 380);
		panel.add(spBajas);
		 modeloTabla = new DefaultTableModel(new Object[]{"Mesa", "Capacidad", "Estado"}, 0) {
		 
			private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
             return false;
		 }
		};
		table = new JTable(modeloTabla);
		table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer());
		spBajas.setViewportView(table);
		table.setRowHeight(20);
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent Mouse_evt) {
				Point point=Mouse_evt.getPoint();
				int row = table.rowAtPoint(point);
				if(Mouse_evt.getClickCount()==1) {
					txtnMesa.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				}
			}
		});
		for (Mesa mesa : control.verLiberadas()) {
			int nroMesa = mesa.getNroMesa();
			int capa = mesa.getCapacidad();
			String estado = mesa.estadoActual();
			modeloTabla.addRow(new Object[] {nroMesa, capa, estado});
		}
		JLabel lblNewLabel = new JLabel("Mesa N°:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 53, 55, 13);
		contentPane.add(lblNewLabel);
		
		txtnMesa = new JTextField();
		txtnMesa.setEditable(false);
		txtnMesa.setBounds(66, 51, 77, 19);
		contentPane.add(txtnMesa);
		txtnMesa.setColumns(10);
		
		JButton btnOcupar = new JButton("Ocupar");
		btnOcupar.setBounds(66, 90, 77, 21);
		contentPane.add(btnOcupar);
		btnOcupar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int mesa =Integer.parseInt(txtnMesa.getText());
				control.ocuparMesa(mesa);
				modeloTabla.removeRow(table.getSelectedRow());	
			}
	});
}
}