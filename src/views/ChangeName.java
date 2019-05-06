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

public class ChangeName extends JFrame {
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeName frame = new ChangeName();
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
	public ChangeName() {
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
				views.MainMenu.main();
				dispose();
				
			}
		});
		contentPane.setLayout(null);
		btnChangeName.setBounds(508, 335, 274, 50);
		contentPane.add(btnChangeName);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textField.setBounds(508, 211, 274, 87);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
