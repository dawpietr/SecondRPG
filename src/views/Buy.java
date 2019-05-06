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
import javax.swing.JOptionPane;

import java.awt.Scrollbar;

public class Buy extends JFrame {

	private JPanel contentPane;
	int numberOfChooseItem=0;
	
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buy frame = new Buy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Buy() {

		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<Item> chooseItem = new JComboBox();
		chooseItem.setFont(new Font ("Monotype Corsiva", Font.BOLD, 18));
		chooseItem.setBounds(454, 20, 628, 60);
		contentPane.add(chooseItem);
		
		
		String allItemShowList = "";
		List<Item> allItemList = new ArrayList <Item>();
		Item[] itemis = Item.values();
		 for (Item itemy : itemis) {
			 allItemList.add(itemy);
				chooseItem.addItem(itemy);
				allItemShowList = allItemShowList.concat(itemy.name) + "\n";
            }
		
		
		JTextArea chooseItemInfo = new JTextArea();
		chooseItemInfo.setEditable(false);
		chooseItemInfo.setBounds(454, 96, 628, 450);
		chooseItemInfo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		contentPane.add(chooseItemInfo);
		
		JTextArea yourHeroItemList = new JTextArea();
		yourHeroItemList.setEditable(false);
		yourHeroItemList.setBounds(70, 20, 369, 620);
		yourHeroItemList.setText(allItemShowList);
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
		
		
		JButton buyItem = new JButton("BUY ITEM");
		buyItem.setBackground(Color.BLACK);
		buyItem.setForeground(Color.RED);
		buyItem.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		buyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Character.getGold() >= allItemList.get(numberOfChooseItem).gold){
				Character.bag.add(allItemList.get(numberOfChooseItem));
				Character.costGold(allItemList.get(numberOfChooseItem).gold);
				}else JOptionPane.showMessageDialog(contentPane, "JEBANY BIEDAK, WYDUPCZEJ NO!");
				rpg.SaveLoad.save();
				views.MainMenu.main();
				dispose();
			}});
		buyItem.setBounds(800, 580, 282, 60);
		getContentPane().add(buyItem);
		
		JTextArea itemBuyPrice = new JTextArea();
		itemBuyPrice.setEditable(false);
		itemBuyPrice.setBounds(454, 580, 331, 60);
		itemBuyPrice.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		contentPane.add(itemBuyPrice);
		
		chooseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numberOfChooseItem = chooseItem.getSelectedIndex();
				chooseItemInfo.setText(allItemList.get(numberOfChooseItem).name + " stats: \n" +
						"LVL: " + allItemList.get(numberOfChooseItem).itemLVL + "\n" +
						" HP: " + allItemList.get(numberOfChooseItem).HP + "\n" +
						" MP: " + allItemList.get(numberOfChooseItem).MP + "\n" +
						" S: " + allItemList.get(numberOfChooseItem).S + "\n" +
						" A: " + allItemList.get(numberOfChooseItem).A + "\n" +
						" I: " + allItemList.get(numberOfChooseItem).I + "\n" +
						" L: " + allItemList.get(numberOfChooseItem).L + "\n" +
						" Sell price: " + allItemList.get(numberOfChooseItem).gold + " gold coins\n" +
						" Rarity: " + allItemList.get(numberOfChooseItem).raritys + "\n" +
						" Typ: " + allItemList.get(numberOfChooseItem).itemTypes + "\n" +
						" Class: " + allItemList.get(numberOfChooseItem).itemClaass + "\n");
				itemBuyPrice.setText("Buy cost: " + allItemList.get(numberOfChooseItem).gold + " gold coins\n");
			}
		});
			
		
	}	
}
