package rpg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import java.io.PrintWriter;

public class SaveLoad extends Character{
	public SaveLoad(String[] args) {
		super(args);
	}

	static File save = new File("save.txt");

	public static void main(String[] args) {
	
    
	}
	
	static public void save () {
		 try {
				if(save.createNewFile())
				System.out.println("save.txt" + " File Created");
				else System.out.println("File "+"save.txt"+" already exists");
				} catch (IOException e1) {e1.printStackTrace();}
		
		PrintWriter save = null;
		try {
			save = new PrintWriter("save.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  save.print(
				  Character.getHeroName() + ";"+
				  Character.heroClaass+";"+
				  Character.heroHP+";"+
				  Character.heroMP+";"+
				  Character.heroS+";"+
				  Character.heroA+";"+
				  Character.heroI+";"+
				  Character.heroL+";"+
				  Character.heroEXP+";"+
				  Character.heroLVL+";"+
				  Character.eWeapon+";"+
				  Character.eWeapon.itemLVL+";"+
				  Character.eArmor+";"+
				  Character.eArmor.itemLVL+";"+
				  Character.gold+";"+
				  bag.size()+";"
				  );
		  for(int iii =0;iii<Character.bag.size();iii++){
			  save.print(Character.bag.get(iii) + ";");
			  save.print(Character.bag.get(iii).itemLVL + ";");
		  }
		  save.close();
		  System.out.println("!GAME SAVED!");
		
	}
	
	static public void load () {
		save = new File("save.txt");
		Scanner in = null;
		try {
			in = new Scanner(save);
			String zdanie = in.nextLine();
			String[] split = zdanie.split(";");
			Character.setHeroName(split[0]);
			 Character.heroClaass = Claass.valueOf(split[1]);
			  Character.heroHP = Integer.parseInt(split[2]);
			  Character.heroMP = Integer.parseInt(split[3]);
			  Character.heroS = Integer.parseInt(split[4]);
			  Character.heroA = Integer.parseInt(split[5]);
			  Character.heroI = Integer.parseInt(split[6]);
			  Character.heroL = Integer.parseInt(split[7]);
			  Character.heroEXP = Double.parseDouble(split[8]);
			  Character.heroLVL = Double.parseDouble(split[9]);
			  if (split[10].equalsIgnoreCase("null")) System.out.println("You don't have any weapon!");
			  else {
				  Character.eWeapon = Item.valueOf(split[10]);
				  Character.eWeapon.itemLVL = Integer.parseInt(split[11]);
				  Character.eWeapon = Item.loadItemStats(eWeapon);
			  }
			  if (split[11].equalsIgnoreCase("null")) System.out.println("You don't have any armor!");
			  else{
				  Character.eArmor = Item.valueOf(split[12]);
				  Character.eArmor.itemLVL = Integer.parseInt(split[13]);
				  Character.eArmor = Item.loadItemStats(eArmor);
			  }
			  Character.gold = Integer.parseInt(split[14]);
			  int bagSize = Integer.parseInt(split[15]);
			  int jjj=0;
			  for(int iii =16; iii<((2*bagSize)+16); iii=iii+2){
				  Character.bag.add(Item.valueOf(split[iii]));
				  getBagItems(jjj).itemLVL = Integer.parseInt(split[iii+1]);
				  setBagItems(jjj, rpg.Item.loadItemStats(getBagItems(jjj)));
				  jjj++;
			  }
		      
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("!GAME LOAD!");
		Character.heroInfo();
	}


}
