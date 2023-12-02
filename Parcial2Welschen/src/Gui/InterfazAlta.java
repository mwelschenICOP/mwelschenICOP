package Gui;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Control.Control;
import Logica.Mesa;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InterfazAlta extends JFrame {
	private JTable table;
	private DefaultTableModel modeloTabla;
	private Control control;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtConsu;
	private JTextField txtnMesa;

	public InterfazAlta(Control control) {
		this.control=control;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Mesas ocupadas", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(218, 10, 330, 411);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane spAltas = new JScrollPane();
		spAltas.setBounds(10, 21, 310, 379);
		panel.add(spAltas);
		
		
		 modeloTabla = new DefaultTableModel(new Object[]{"Mesa", "Capacidad", "Estado"}, 0) {
		 
			private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
             return false;
		 }
		};
		table = new JTable(modeloTabla);
		table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer());
		spAltas.setViewportView(table);
		table.setRowHeight(20);
		
		for (Mesa mesa : control.verOcupadas()) {
			int nroMesa = mesa.getNroMesa();
			int capa = mesa.getCapacidad();
			String estado = mesa.estadoActual();
			modeloTabla.addRow(new Object[] {nroMesa, capa, estado});
		}
		JLabel lblNewLabel = new JLabel("Consumo(#.##): ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(21, 42, 97, 13);
		contentPane.add(lblNewLabel);
		
		txtConsu = new JTextField();
		txtConsu.setToolTipText("");
		txtConsu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean numero = (key >=48 && key<=57 || key == 46);
				if (!numero) {
					e.consume();
				}
			}	
		});
		txtConsu.setBounds(121, 40, 73, 19);
		contentPane.add(txtConsu);
		txtConsu.setColumns(10);
		
		JButton btnLiberar = new JButton("Liberar");
		btnLiberar.setBounds(109, 136, 85, 21);
		contentPane.add(btnLiberar);
		btnLiberar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double cons = Double.parseDouble(txtConsu.getText());
				int nMesa = Integer.parseInt(txtnMesa.getText());
				control.liberarMesa(cons, nMesa);
				modeloTabla.removeRow(table.getSelectedRow());	
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Mesa N°:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(21, 90, 59, 13);
		contentPane.add(lblNewLabel_1);
		
		txtnMesa = new JTextField();
		txtnMesa.setEditable(false);
		txtnMesa.setBounds(84, 88, 110, 19);
		contentPane.add(txtnMesa);
		txtnMesa.setColumns(10);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(109, 365, 85, 21);
		contentPane.add(btnNewButton);
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent Mouse_evt) {
				Point point=Mouse_evt.getPoint();
				int row = table.rowAtPoint(point);
				if(Mouse_evt.getClickCount()==1) {
				txtnMesa.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				}
			}
		});
	}
}
