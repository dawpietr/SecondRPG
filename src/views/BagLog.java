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
import javax.swing.JMenuBar;
import java.awt.Scrollbar;

public class BagLog extends JFrame {

	private JPanel contentPane;
	int numberOfChooseItem=0;
	
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BagLog frame = new BagLog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public BagLog() {

		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextField weaponName = new JTextField();
		weaponName.setEditable(false);
		weaponName.setBounds(70, 20, 450, 60);
		weaponName.setText(rpg.Character.getHeroName() + " items: \n");
		weaponName.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		contentPane.add(weaponName);
		
		JComboBox<String> yourItems = new JComboBox();
		yourItems.setFont(new Font ("Monotype Corsiva", Font.BOLD, 18));
		yourItems.setBounds(600, 20, 450, 60);
		contentPane.add(yourItems);
		String myItemList = "";
		List<Item> actuallyBagList = new ArrayList <Item>();
		for(int iii =0;iii<Character.bag.size();iii++){
				actuallyBagList.add(Character.bag.get(iii));
				yourItems.addItem(Character.bag.get(iii).name);
				myItemList = myItemList.concat(Character.bag.get(iii).name + "\n");
				}
		
		JTextArea yourHero = new JTextArea();
		yourHero.setEditable(false);
		yourHero.setBounds(70, 90, 450, 550);
		yourHero.setText(myItemList);
		yourHero.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		contentPane.add(yourHero);
		
		JTextArea yourBagInfo = new JTextArea();
		yourBagInfo.setEditable(false);
		yourBagInfo.setBounds(600, 90, 450, 482);
		yourBagInfo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		contentPane.add(yourBagInfo);
		
		
		yourItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numberOfChooseItem = yourItems.getSelectedIndex();
				yourBagInfo.setText(Item.showFullItemDescription(actuallyBagList.get(numberOfChooseItem)));
			}});
		
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
		back.setBounds(1097, 580, 146, 60);
		getContentPane().add(back);
		
		
		JButton changeWeapon = new JButton("CHANGE WEAPON");
		changeWeapon.setBackground(Color.BLACK);
		changeWeapon.setForeground(Color.RED);
		changeWeapon.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		changeWeapon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				views.ChangeWeapon.main();
				dispose();
			}});
		changeWeapon.setBounds(800, 580, 282, 60);
		getContentPane().add(changeWeapon);
		
		JButton changeArmor = new JButton("CHANGE ARMOR");
		changeArmor.setBackground(Color.BLACK);
		changeArmor.setForeground(Color.RED);
		changeArmor.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		changeArmor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				views.ChangeArmor.main();
				dispose();
			}});
		
		changeArmor.setBounds(535, 580, 250, 60);
		getContentPane().add(changeArmor);
	}	
}
