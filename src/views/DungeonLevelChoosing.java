package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DungeonLevelChoosing extends JFrame {

	private JPanel contentPane;
	static int dungeonLevel=0;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DungeonLevelChoosing frame = new DungeonLevelChoosing();
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
	public DungeonLevelChoosing() {
		setTitle("YOUR CHOICE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
					JButton hard = new JButton("HARD (10)");
					hard.setBackground(Color.BLACK);
					hard.setForeground(Color.RED);
					hard.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
					hard.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dungeonLevel=10;
							views.Dungeon.main();
							dispose();
						}});
					hard.setBounds(557, 373, 159, 60);
					getContentPane().add(hard);
					
					JButton impossible = new JButton("IMPOSSIBLE (20)");
					impossible.setBackground(Color.BLACK);
					impossible.setForeground(Color.RED);
					impossible.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
					impossible.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dungeonLevel=20;
							views.Dungeon.main();
							dispose();
						}});
					impossible.setBounds(219, 505, 842, 60);
					getContentPane().add(impossible);
					
							
						JButton easy = new JButton("EASY (3)");
						easy.setBackground(Color.BLACK);
						easy.setForeground(Color.RED);
						easy.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
						easy.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dungeonLevel=3;
								views.Dungeon.main();
								dispose();
							}});
						easy.setBounds(504, 16, 250, 181);
						getContentPane().add(easy);
						
						JButton medium = new JButton("MEDIUM (5)");
						medium.setBackground(Color.BLACK);
						medium.setForeground(Color.RED);
						medium.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
						medium.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dungeonLevel=5;
								views.Dungeon.main();
								dispose();
							}});
						medium.setBounds(351, 239, 575, 60);
						getContentPane().add(medium);
						
						JButton back = new JButton("BACK");
						back.setBackground(Color.BLACK);
						back.setForeground(Color.RED);
						back.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
						back.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								rpg.SaveLoad.save();
								views.MainMenu.main();
								dispose();
							}});
						back.setBounds(993, 588, 250, 60);
						getContentPane().add(back);
						
	}
	
	
	public static int getDungeonLevel() {
		return (dungeonLevel);
	}
}
