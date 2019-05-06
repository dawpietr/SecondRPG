package views;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rpg.Character;
import rpg.Claass;
import rpg.Item;
import rpg.SaveLoad;

import javax.swing.JButton;


public class WhichHeroClaass extends JFrame {

	private JPanel contentPane;


	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WhichHeroClaass frame = new WhichHeroClaass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WhichHeroClaass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		
		JButton btnNewButton_0 = new JButton("KNIGHT");
		btnNewButton_0.setBackground(Color.BLACK);
		btnNewButton_0.setForeground(Color.RED);
		btnNewButton_0.setFont(new Font("Monotype Corsiva", Font.PLAIN, 70));
		btnNewButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rpg.Character.setHeroClass(Claass.knight);
				rpg.Character.setFirstStat();
				rpg.Character.giveItem(Item.SwordShield, Item.DualSword, Item.TwoSword, Item.HeavyArmor);
				rpg.Character.firstArmorEquip();
				SaveLoad.save();
				views.ChangeWeapon.main();
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnNewButton_0.setBounds(179, 150, 300, 100);
		contentPane.add(btnNewButton_0);
		
		
		JButton btnNewButton_1 = new JButton("RANGER");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 70));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rpg.Character.setHeroClass(Claass.ranger);
				rpg.Character.setFirstStat();
				rpg.Character.giveItem(Item.Bow, Item.Dagger, Item.Crossbow, Item.LightArmor);
				rpg.Character.firstArmorEquip();
				SaveLoad.save();
				views.ChangeWeapon.main();
				dispose();
			}
		});
		btnNewButton_1.setBounds(179, 393, 300, 100);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("MAGE");
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Monotype Corsiva", Font.PLAIN, 70));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rpg.Character.setHeroClass(Claass.mage);
				rpg.Character.setFirstStat();
				rpg.Character.giveItem(Item.Wand, Item.Scepter, Item.Staff, Item.Robe);
				rpg.Character.firstArmorEquip();
				SaveLoad.save();
				views.ChangeWeapon.main();
				dispose();
			}
		});
		btnNewButton_2.setBounds(723, 150, 300, 100);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("VIKING");
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setFont(new Font("Monotype Corsiva", Font.PLAIN, 70));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rpg.Character.setHeroClass(Claass.viking);
				rpg.Character.setFirstStat();
				rpg.Character.giveItem(Item.TwoAxe, Item.DualAxe, Item.AxeShield, Item.MidArmor);
				rpg.Character.firstArmorEquip();
				SaveLoad.save();
				views.ChangeWeapon.main();
				dispose();
			}
		});
		btnNewButton_3.setBounds(723, 393, 300, 100);
		contentPane.add(btnNewButton_3);
	}
}
