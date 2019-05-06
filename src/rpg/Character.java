package rpg;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Character extends main{

	public Character(String[] args) {

	}

	public static String heroName;
	static Claass heroClaass;
	static int heroHP,heroMP,heroS,heroA,heroI,heroL;
	static double heroEXP=0;
	static double heroLVL=1;
	static Item eWeapon = Item.fists;
	static Item eArmor = Item.nakedBody;
	static public List<Item> bag = new ArrayList <Item>();
	static int gold;
	
	
	
	public final static void setFirstStat(){
		heroHP=heroClaass.HP;
		heroMP=heroClaass.MP;
		heroS=heroClaass.S;
		heroA=heroClaass.A;
		heroI=heroClaass.I;
		heroL=heroClaass.L;
	}
	
	public final static void setHeroName(){
		views.ChooseName.main();
	}
	
	final static void getEXP (int EXP) {
		heroEXP += EXP;
		if (heroEXP >= (100*(Math.pow((1.2),heroLVL)))){
			heroEXP = heroEXP - (int) (100*(Math.pow((1.2),heroLVL)));
			heroLVL++;
		}
	}
	final static void getGold (int allGold){
		Character.gold = Character.gold + allGold;
	}
	
	public final static void giveItem(Item item0, Item...items){
		System.out.println("You have received: ");
		//Item.showShortItemDescription(item0);
		bag.add(item0);
		for(int i=0; i<items.length; i++)
			{System.out.println("You have received: ");
			//Item.showShortItemDescription(items[i]);
			bag.add(items[i]);
			}
	}
	
	final public static void equipWeapon(int wI){
		if (bag.isEmpty())System.out.println("You don't have any items to equip! [LOOSER]");
		else {
			bag.add(eWeapon);
			eWeapon = bag.get(wI);
			heroHP = heroClaass.HP + bag.get(wI).HP +eArmor.HP;
			heroMP = heroClaass.MP + bag.get(wI).MP + eArmor.MP;
			heroS = heroClaass.S + bag.get(wI).S + eArmor.S;
			heroA = heroClaass.A + bag.get(wI).A + eArmor.A;
			heroI = heroClaass.I + bag.get(wI).I + eArmor.I;
			heroL = heroClaass.L + bag.get(wI).L + eArmor.L;
			bag.remove(wI);
			}
		}
	
	final public static void equipArmor(int wI){
		if (bag.isEmpty())System.out.println("You don't have any items to equip! [LOOSER]");
		else {
			bag.add(eArmor);
			eWeapon = bag.get(wI);
			heroHP = heroClaass.HP + bag.get(wI).HP +eWeapon.HP;
			heroMP = heroClaass.MP + bag.get(wI).MP + eWeapon.MP;
			heroS = heroClaass.S + bag.get(wI).S + eWeapon.S;
			heroA = heroClaass.A + bag.get(wI).A + eWeapon.A;
			heroI = heroClaass.I + bag.get(wI).I + eWeapon.I;
			heroL = heroClaass.L + bag.get(wI).L + eWeapon.L;
			bag.remove(wI);
			}
		}
	
	public final static void firstArmorEquip() {
		{
			bag.add(eArmor);
			eArmor = bag.get(3);
			heroHP = heroClaass.HP + bag.get(3).HP + eWeapon.HP;
			heroMP = heroClaass.MP + bag.get(3).MP + eWeapon.MP;
			heroS = heroClaass.S + bag.get(3).S + eWeapon.S;
			heroA = heroClaass.A + bag.get(3).A + eWeapon.A;
			heroI = heroClaass.I + bag.get(3).I + eWeapon.I;
			heroL = heroClaass.L + bag.get(3).L + eWeapon.L;
			bag.remove(3);
			}
	}
	
	final static void showBag() {
		if (bag.isEmpty())System.out.println("You don't have any items! [LOOSER]");
		else {
		System.out.println("You have " + bag.size() + " items.");
		for(int iii =0;iii<bag.size();iii++){
			System.out.print(iii +" item: ");
			Item.showShortItemDescription(bag.get(iii));
		}
		}
		//mozliwosc rozwiniecia opisu konkretnego przedmiotu jako showFullItemDescription
			
	}

	
		

	
	final static void showLVL() { 
	System.out.println("Your actually LVL is: " + heroLVL + " and you have " + heroEXP + "/" + (int)(100*(Math.pow((1.2),heroLVL))) + " EXP.");	//mozna sparsowac na int przy wyswietlaniu
	}
	
	final public static String heroInfo(){
		return (
				 "heroName: " + Character.getHeroName() + "\n"+
				 " heroClaass : " +  Character.heroClaass+"\n"+
				 " heroHP: " +  Character.heroHP+"\n"+
				 " heroMP: " +  Character.heroMP+"\n"+
				 " heroS: " +  Character.heroS+"\n"+
				 " heroA: " +  Character.heroA+"\n"+
				 " heroI: " +  Character.heroI+"\n"+
				 " heroL: " +  Character.heroL+"\n"+
				 " heroEXP: " +  Character.heroEXP+"/"+(int)(100*(Math.pow((1.2),heroLVL)))+"\n"+
				 " heroLVL: " +  Character.heroLVL+"\n"+
				 " eWeapon: " +  Character.eWeapon+"\n"+
				 " eArmor: " +  Character.eArmor+"\n"+
				 " gold: " +  Character.gold+"\n"
				  );
	}
	public static String getHeroName() {
		return Character.heroName;
	}
	public static void setHeroName(String heroName) {
		Character.heroName = heroName;
	}
	
	public static Item geteWeapon() {
		return eWeapon;
	}
	public static void seteWeapon(Item eWeapon) {
		Character.eWeapon = eWeapon;
	}
	
	public static Item geteArmor() {
		return eArmor;
	}
	public static void seteArmor(Item eArmor) {
		Character.eArmor = eArmor;
	}
	public static Item getBagItems(int jjj){
		return bag.get(jjj);
	}
	public static Item setBagItems(int jjj, Item newItem){
		return bag.set(jjj, newItem);
	}
	
	
	public static void setHeroClass(Claass newHeroClaass) {
		Character.heroClaass = newHeroClaass;
	}
	
	public static int costGold(int cost){
		return gold = gold - cost;
	}
	
	public static int getGold(){
		return gold;
	}
	
	public static void sellItem(int whichItem) {
		gold = gold + bag.get(whichItem).gold;
		bag.remove(whichItem);
		}	
	
}
