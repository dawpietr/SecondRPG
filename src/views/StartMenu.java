package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import rpg.Character;
import rpg.SaveLoad;

import java.awt.Color;
import java.awt.Font;

public class StartMenu extends JFrame{

	private JPanel contentPane;
	private JFrame frmMenusTart;
	private JTextField txtChooseOption;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMenu frame = new StartMenu();
					frame.frmMenusTart.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public StartMenu() {
		frmMenusTart = new JFrame();
		frmMenusTart.setTitle("Menu Start");
		frmMenusTart.setBounds(100, 100, 1280, 720);
		frmMenusTart.getContentPane().setLayout(null);
		
		txtChooseOption = new JTextField();
		txtChooseOption.setBackground(Color.GRAY);
		txtChooseOption.setFont(new Font("Monotype Corsiva", Font.BOLD, 29));
		txtChooseOption.setForeground(Color.BLUE);
		txtChooseOption.setHorizontalAlignment(SwingConstants.CENTER);
		txtChooseOption.setEditable(false);
		txtChooseOption.setText("Choose option");
		txtChooseOption.setBounds(390, 100, 500, 60);
		frmMenusTart.getContentPane().add(txtChooseOption);
		txtChooseOption.setColumns(10);
		
		JButton newGame = new JButton("New Game");
		newGame.setBackground(Color.BLACK);
		newGame.setForeground(Color.RED);
		newGame.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Character.setHeroName();
				frmMenusTart.dispose();
			}});
		newGame.setBounds(515, 250, 250, 60);
		frmMenusTart.getContentPane().add(newGame);
		
		JButton loadGame = new JButton("Load Game");
		loadGame.setBackground(Color.BLACK);
		loadGame.setForeground(Color.RED);
		loadGame.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rpg.SaveLoad.load();
				views.MainMenu.main();
				frmMenusTart.dispose();
			}});
		loadGame.setBounds(515, 400, 250, 60);
		frmMenusTart.getContentPane().add(loadGame);
		
		
	}
}
