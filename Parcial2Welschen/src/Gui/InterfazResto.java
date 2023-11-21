package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Control;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazResto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Control control;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazResto frame = new InterfazResto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfazResto() {
		control = new Control();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione un restó");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(231, 50, 143, 45);
		contentPane.add(lblNewLabel);
		
		
		JComboBox<String> comboBoxresto = new JComboBox();
		control.RellenarCombo("resto", "nombre", comboBoxresto);
		comboBoxresto.setBounds(191, 147, 227, 21);
		contentPane.add(comboBoxresto);
		
		JButton btnAccederResto = new JButton("Acceder");
		btnAccederResto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				control.setearResto(comboBoxresto.getSelectedItem().toString());
				Principal prin = new Principal(control);
				prin.setVisible(true);
				dispose();
			}
		});
		btnAccederResto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAccederResto.setBounds(263, 239, 94, 21);
		contentPane.add(btnAccederResto);
	}
}
