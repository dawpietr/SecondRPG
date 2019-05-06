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

public class ChangeArmor extends JFrame {

	private JPanel contentPane;
	int numberOfChooseItem=0;
	
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeArmor frame = new ChangeArmor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ChangeArmor() {
		rpg.Item equipedArmor = rpg.Character.geteArmor();
		
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextField armorName = new JTextField();
		
		armorName.setEditable(false);
		armorName.setBounds(70, 20, 450, 60);
		armorName.setText("Equiped armor:" + rpg.Character.geteArmor().name);
		armorName.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		contentPane.add(armorName);
		
		JComboBox<Item> chooseArmor = new JComboBox();
		chooseArmor.setFont(new Font ("Monotype Corsiva", Font.BOLD, 18));
		chooseArmor.setBounds(600, 20, 450, 60);
		contentPane.add(chooseArmor);
		List<Item> actuallyArmorList = new ArrayList <Item>();
		int g =0;
		List<Integer> bagNumber = new ArrayList <Integer>();
		for(int iii =0;iii<Character.bag.size();iii++){
			if (Character.bag.get(iii).itemTypes == ItemType.armor){
				actuallyArmorList.add(Character.bag.get(iii));
				bagNumber.add(iii);
				chooseArmor.addItem(actuallyArmorList.get(g));
				g=g+1;
				}
		}
		
		
		JTextArea eArmorInfo = new JTextArea();
		eArmorInfo.setEditable(false);
		eArmorInfo.setBounds(70, 90, 450, 450);
		eArmorInfo.setText(equipedArmor.name + " stats: \n" +
		"LVL: " + equipedArmor.itemLVL + "\n" +
		" HP: " + equipedArmor.HP + "\n" +
		" MP: " + equipedArmor.MP + "\n" +
		" S: " + equipedArmor.S + "\n" +
		" A: " + equipedArmor.A + "\n" +
		" I: " + equipedArmor.I + "\n" +
		" L: " + equipedArmor.L + "\n" +
		" Sell price: " + equipedArmor.gold + " gold coins\n" +
		" Rarity: " + equipedArmor.raritys + "\n" +
		" Typ: " + equipedArmor.itemTypes + "\n" +
		" Class: " + equipedArmor.itemClaass + "\n");
		eArmorInfo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		contentPane.add(eArmorInfo);
		
		
		JTextArea newArmorInfo = new JTextArea();
		newArmorInfo.setEditable(false);
		newArmorInfo.setBounds(600, 90, 450, 450);
		newArmorInfo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		contentPane.add(newArmorInfo);
		chooseArmor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numberOfChooseItem = chooseArmor.getSelectedIndex();
				newArmorInfo.setText(actuallyArmorList.get(numberOfChooseItem).name + " stats: \n" +
						"LVL: " + actuallyArmorList.get(numberOfChooseItem).itemLVL + "\n" +
						" HP: " + actuallyArmorList.get(numberOfChooseItem).HP + "\n" +
						" MP: " + actuallyArmorList.get(numberOfChooseItem).MP + "\n" +
						" S: " + actuallyArmorList.get(numberOfChooseItem).S + "\n" +
						" A: " + actuallyArmorList.get(numberOfChooseItem).A + "\n" +
						" I: " + actuallyArmorList.get(numberOfChooseItem).I + "\n" +
						" L: " + actuallyArmorList.get(numberOfChooseItem).L + "\n" +
						" Sell price: " + actuallyArmorList.get(numberOfChooseItem).gold + " gold coins\n" +
						" Rarity: " + actuallyArmorList.get(numberOfChooseItem).raritys + "\n" +
						" Typ: " + actuallyArmorList.get(numberOfChooseItem).itemTypes + "\n" +
						" Class: " + actuallyArmorList.get(numberOfChooseItem).itemClaass + "\n");
			}
		});
		
		JButton changeArmor = new JButton("CHANGE ARMOR");
		changeArmor.setBackground(Color.BLACK);
		changeArmor.setForeground(Color.RED);
		changeArmor.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		changeArmor.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Character.equipArmor(bagNumber.get(numberOfChooseItem));
				views.MainMenu.main();
				SaveLoad.save();
				dispose();
			}
		});
		changeArmor.setBounds(968, 588, 275, 60);
		contentPane.add(changeArmor);
		
		JButton mainMenu = new JButton("MAIN MENU");
		mainMenu.setBackground(Color.BLACK);
		mainMenu.setForeground(Color.RED);
		mainMenu.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		mainMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				rpg.SaveLoad.save();
				views.MainMenu.main();
				dispose();
			}});
		mainMenu.setBounds(706, 588, 247, 60);
		getContentPane().add(mainMenu);
		
	}
	
		}


