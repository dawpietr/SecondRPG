package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ChooseName extends JFrame {
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseName frame = new ChooseName();
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
	public ChooseName() {
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		
		JButton btnChangeName = new JButton("CHANGE NAME");
		btnChangeName.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		btnChangeName.setBackground(Color.BLACK);
		btnChangeName.setForeground(Color.RED);
		btnChangeName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rpg.Character.setHeroName(textField.getText());
				views.WhichHeroClaass.main();
				dispose();
				
			}
		});
		contentPane.setLayout(null);
		btnChangeName.setBounds(495, 369, 268, 50);
		contentPane.add(btnChangeName);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textField.setBounds(495, 233, 268, 106);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
