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

public class Sell extends JFrame {

	private JPanel contentPane;
	int numberOfChooseItem=0;
	
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sell frame = new Sell();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Sell() {

		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<Item> chooseItem = new JComboBox();
		chooseItem.setFont(new Font ("Monotype Corsiva", Font.BOLD, 18));
		chooseItem.setBounds(454, 20, 628, 60);
		contentPane.add(chooseItem);
		
		
		String myItemList = "";
		List<Item> actuallyBagItemList = new ArrayList <Item>();
		List<Integer> bagNumber = new ArrayList <Integer>();
		for(int iii =0;iii<Character.bag.size();iii++){
				actuallyBagItemList.add(Character.bag.get(iii));
				bagNumber.add(iii);
				chooseItem.addItem(Character.bag.get(iii));
				myItemList = myItemList.concat(Character.bag.get(iii).name + "\n");
		}
		
		
		JTextArea chooseItemInfo = new JTextArea();
		chooseItemInfo.setEditable(false);
		chooseItemInfo.setBounds(454, 96, 628, 450);
		chooseItemInfo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		contentPane.add(chooseItemInfo);
		
		JTextArea yourHeroItemList = new JTextArea();
		yourHeroItemList.setEditable(false);
		yourHeroItemList.setBounds(70, 20, 369, 620);
		yourHeroItemList.setText(myItemList);
		yourHeroItemList.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		contentPane.add(yourHeroItemList);
		
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
		
		
		JButton upgradeItem = new JButton("SELL ITEM");
		upgradeItem.setBackground(Color.BLACK);
		upgradeItem.setForeground(Color.RED);
		upgradeItem.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		upgradeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Character.getBagItems(numberOfChooseItem).gold > 0)
				Character.sellItem(numberOfChooseItem);
				rpg.SaveLoad.save();
				views.MainMenu.main();
				dispose();
			}});
		upgradeItem.setBounds(800, 580, 282, 60);
		getContentPane().add(upgradeItem);
		
		JTextArea itemSellPrice = new JTextArea();
		itemSellPrice.setEditable(false);
		itemSellPrice.setBounds(454, 580, 331, 60);
		itemSellPrice.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		contentPane.add(itemSellPrice);
		
		chooseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numberOfChooseItem = chooseItem.getSelectedIndex();
				chooseItemInfo.setText(actuallyBagItemList.get(numberOfChooseItem).name + " stats: \n" +
						"LVL: " + actuallyBagItemList.get(numberOfChooseItem).itemLVL + "\n" +
						" HP: " + actuallyBagItemList.get(numberOfChooseItem).HP + "\n" +
						" MP: " + actuallyBagItemList.get(numberOfChooseItem).MP + "\n" +
						" S: " + actuallyBagItemList.get(numberOfChooseItem).S + "\n" +
						" A: " + actuallyBagItemList.get(numberOfChooseItem).A + "\n" +
						" I: " + actuallyBagItemList.get(numberOfChooseItem).I + "\n" +
						" L: " + actuallyBagItemList.get(numberOfChooseItem).L + "\n" +
						" Sell price: " + actuallyBagItemList.get(numberOfChooseItem).gold + " gold coins\n" +
						" Rarity: " + actuallyBagItemList.get(numberOfChooseItem).raritys + "\n" +
						" Typ: " + actuallyBagItemList.get(numberOfChooseItem).itemTypes + "\n" +
						" Class: " + actuallyBagItemList.get(numberOfChooseItem).itemClaass + "\n");
				itemSellPrice.setText("Sell: " + actuallyBagItemList.get(numberOfChooseItem).gold + " gold coins\n");
			}
		});
		
		
		
		
		
	}	
}
