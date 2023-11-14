import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LayoutTP extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayoutTP frame = new LayoutTP();
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
	public LayoutTP() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Flow Layout", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 832, 83);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_19 = new JButton("New button");
		panel.add(btnNewButton_19);
		
		JButton btnNewButton_17 = new JButton("New button");
		panel.add(btnNewButton_17);
		
		JButton btnNewButton_16 = new JButton("New button");
		panel.add(btnNewButton_16);
		
		JButton btnNewButton_18 = new JButton("New button");
		panel.add(btnNewButton_18);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Free Layout", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 83, 174, 257);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 27, 85, 21);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(79, 214, 85, 21);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(31, 109, 85, 21);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBounds(658, 83, 174, 257);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Box layout", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 3, 161, 251);
		panel_3.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_12 = new JButton("New button");
		panel_6.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("New button");
		panel_6.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("New button");
		panel_6.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("New button");
		panel_6.add(btnNewButton_15);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Border Layout", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(178, 83, 478, 257);
		getContentPane().add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_7 = new JButton("New button");
		panel_4.add(btnNewButton_7, BorderLayout.NORTH);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel_4.add(btnNewButton_8, BorderLayout.SOUTH);
		
		JButton btnNewButton_9 = new JButton("New button");
		panel_4.add(btnNewButton_9, BorderLayout.WEST);
		
		JButton btnNewButton_10 = new JButton("New button");
		panel_4.add(btnNewButton_10, BorderLayout.CENTER);
		
		JButton btnNewButton_11 = new JButton("New button");
		panel_4.add(btnNewButton_11, BorderLayout.EAST);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Grid Layout", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(0, 344, 832, 98);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(62, 35, 673, 39);
		panel_5.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel_2.add(btnNewButton_6);

	}
}
