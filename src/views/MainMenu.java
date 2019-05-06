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

public class MainMenu extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frmMenusTart;
	private JTextField txtChooseOption;


	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.frmMenusTart.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MainMenu() {
		frmMenusTart = new JFrame();
		frmMenusTart.setTitle("YOUR JOURNEY");
		frmMenusTart.setBounds(100, 100, 1280, 720);
		frmMenusTart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenusTart.getContentPane().setLayout(null);
		
		JButton city = new JButton("CITY");
		city.setBackground(Color.BLACK);
		city.setForeground(Color.RED);
		city.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		city.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				views.City.main();
				frmMenusTart.dispose();
			}});
		city.setBounds(498, 285, 250, 60);
		frmMenusTart.getContentPane().add(city);
		
		JButton dungeon = new JButton("DUNGEON");
		dungeon.setBackground(Color.BLACK);
		dungeon.setForeground(Color.RED);
		dungeon.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		dungeon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				views.DungeonLevelChoosing.main();
				frmMenusTart.dispose();
			}});
		dungeon.setBounds(61, 174, 250, 60);
		frmMenusTart.getContentPane().add(dungeon);
		
		JButton fight = new JButton("FIGHT");
		fight.setBackground(Color.BLACK);
		fight.setForeground(Color.RED);
		fight.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		fight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				views.Fight.main();
				frmMenusTart.dispose();
			}});
		fight.setBounds(61, 98, 250, 60);
		frmMenusTart.getContentPane().add(fight);
		
		JButton items = new JButton("YOUR ITEMS");
		items.setBackground(Color.BLACK);
		items.setForeground(Color.RED);
		items.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		items.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				views.BagLog.main();
				frmMenusTart.dispose();
			}});
		items.setBounds(947, 174, 250, 60);
		frmMenusTart.getContentPane().add(items);
		
		JButton hero = new JButton("HERO");
		hero.setBackground(Color.BLACK);
		hero.setForeground(Color.RED);
		hero.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		hero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				views.HeroLog.main();
				frmMenusTart.dispose();
			}});
		hero.setBounds(947, 98, 250, 60);
		frmMenusTart.getContentPane().add(hero);
		
		JButton save = new JButton("SAVE");
		save.setBackground(Color.BLACK);
		save.setForeground(Color.RED);
		save.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveLoad.save();
			}});
		save.setBounds(728, 588, 250, 60);
		frmMenusTart.getContentPane().add(save);
		
		JButton exit = new JButton("EXIT");
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.RED);
		exit.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close
				frmMenusTart.dispose();
			}});
		exit.setBounds(993, 588, 250, 60);
		frmMenusTart.getContentPane().add(exit);
		
		
		
	}
}