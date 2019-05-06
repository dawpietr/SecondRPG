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

public class City extends JFrame{

	private JPanel contentPane;
	private JFrame frmMenusTart;
	private JTextField txtChooseOption;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					City frame = new City();
					frame.frmMenusTart.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public City() {
		frmMenusTart = new JFrame();
		frmMenusTart.setTitle("Menu Start");
		frmMenusTart.setBounds(100, 100, 1280, 720);
		frmMenusTart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenusTart.getContentPane().setLayout(null);
		
		txtChooseOption = new JTextField();
		txtChooseOption.setBackground(Color.GRAY);
		txtChooseOption.setFont(new Font("Monotype Corsiva", Font.BOLD, 85));
		txtChooseOption.setForeground(Color.BLUE);
		txtChooseOption.setHorizontalAlignment(SwingConstants.CENTER);
		txtChooseOption.setText("CITY");
		txtChooseOption.setEditable(false);
		txtChooseOption.setBounds(387, 61, 500, 60);
		frmMenusTart.getContentPane().add(txtChooseOption);
		txtChooseOption.setColumns(10);
		
		JButton forge = new JButton("FORGE");
		forge.setBackground(Color.BLACK);
		forge.setForeground(Color.RED);
		forge.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		forge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rpg.SaveLoad.save();
				views.Forge.main();
				frmMenusTart.dispose();
			}});
		forge.setBounds(157, 200, 250, 60);
		frmMenusTart.getContentPane().add(forge);
		
		JButton tavern = new JButton("TAVERN");
		tavern.setBackground(Color.BLACK);
		tavern.setForeground(Color.RED);
		tavern.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		tavern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rpg.SaveLoad.save();
				views.MainMenu.main();
				frmMenusTart.dispose();
			}});
		tavern.setBounds(157, 331, 250, 60);
		frmMenusTart.getContentPane().add(tavern);
		
		JButton sell = new JButton("SELL");
		sell.setBackground(Color.BLACK);
		sell.setForeground(Color.RED);
		sell.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		sell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rpg.SaveLoad.save();
				views.Sell.main();
				frmMenusTart.dispose();
			}});
		sell.setBounds(864, 200, 250, 60);
		frmMenusTart.getContentPane().add(sell);
		
		JButton buy = new JButton("BUY");
		buy.setBackground(Color.BLACK);
		buy.setForeground(Color.RED);
		buy.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rpg.SaveLoad.save();
				views.Buy.main();
				frmMenusTart.dispose();
			}});
		buy.setBounds(864, 331, 250, 60);
		frmMenusTart.getContentPane().add(buy);
		
		JButton back = new JButton("BACK");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.RED);
		back.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rpg.SaveLoad.save();
				views.MainMenu.main();
				frmMenusTart.dispose();
			}});
		back.setBounds(993, 588, 250, 60);
		frmMenusTart.getContentPane().add(back);
		
	}
}