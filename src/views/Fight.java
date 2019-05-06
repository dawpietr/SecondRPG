package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.PopupMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rpg.Character;
import rpg.Item;
import rpg.ItemType;
import rpg.SaveLoad;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import java.awt.Scrollbar;
import javax.swing.JEditorPane;




public class Fight extends JFrame {

	private JPanel contentPane;
	int numberOfChooseItem = 0;
	
	/**
	 * Launch the application.
	 */
	
	public static void main() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fight frame = new Fight();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Fight() {
		
		try {
			rpg.Fight.main(1);
		} catch (InterruptedException e1) {
			System.out.println("we have an errors");
			e1.printStackTrace();
		}
		
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea figthLog = new JTextArea();
		figthLog.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		figthLog.setText(rpg.Fight.getFightLog());
		
		JScrollPane fightLogScroll = new JScrollPane(figthLog);
		fightLogScroll.setLocation(70, 96);
		fightLogScroll.setSize(915, 531);
		contentPane.add(fightLogScroll);
		contentPane.setVisible(true);
		

		
		
		JTextField yourName = new JTextField();
		yourName.setEditable(false);
		yourName.setBounds(535, 20, 450, 60);
		yourName.setText("Hero: " + rpg.Character.getHeroName());
		yourName.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		contentPane.add(yourName);
		
		JTextField oponentName = new JTextField();
		oponentName.setEditable(false);
		oponentName.setBounds(70, 20, 450, 60);
		oponentName.setText("Monster: " + rpg.Monster.monstrum.monsterName);
		oponentName.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		contentPane.add(oponentName);
			
		JButton back = new JButton("BACK");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.RED);
		back.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rpg.SaveLoad.save();
				rpg.Fight.setFightLogZero();
				views.MainMenu.main();
				dispose();
			}});
		back.setBounds(993, 588, 250, 60);
		getContentPane().add(back);
		
		
		
	}	
}
