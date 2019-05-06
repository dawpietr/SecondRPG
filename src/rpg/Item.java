package rpg;

public enum Item {
	//knight weapon
	//     		LVL, 	HP, 	MP, S, 	A, 	I, 	L, 	gold
SwordShield		(1, 	60, 	0,	5,	0,	0,	2,	5,	Claass.knight,Rarity.common, ItemType.weapon, "Sword with shield"),
DualSword		(1, 	30, 	0,	10,	0,	0,	1,	5,	Claass.knight,Rarity.common, ItemType.weapon, "Two-handed Sword"),
TwoSword		(1, 	45, 	0,	7,	0,	0,	3,	5,	Claass.knight,Rarity.common, ItemType.weapon, "Two Swords"),
	//ranger weapon
Bow				(1, 	20, 	0,	2,	6,	0,	5,	5,	Claass.ranger,Rarity.common, ItemType.weapon, "Bow"),
Dagger			(1, 	30, 	0,	1,	8,	0,	2,	5,	Claass.ranger,Rarity.common, ItemType.weapon, "Dagger"),
Crossbow		(1, 	10, 	0,	3,	10,	0,	1,	5,	Claass.ranger,Rarity.common, ItemType.weapon, "Crossbow"),
	//mage weapon
Wand			(1, 	20, 	20,	0,	0,	6,	2,	5,	Claass.mage,Rarity.common, ItemType.weapon, "Wand"),
Scepter			(1, 	10, 	30,	0,	0,	8,	2,	5,	Claass.mage,Rarity.common, ItemType.weapon, "Scepter"),
Staff			(1, 	15, 	25,	2,	0,	7,	2,	5,	Claass.mage,Rarity.common, ItemType.weapon, "Staff"),
	//viking weapon
TwoAxe			(1, 	40, 	10,	0,	0,	0,	4,	5,	Claass.viking,Rarity.common, ItemType.weapon, "Two Axes"),
DualAxe			(1, 	40, 	10,	0,	0,	0,	4,	5,	Claass.viking,Rarity.common, ItemType.weapon, "Two-handed Axe"),
AxeShield		(1, 	40, 	10,	0,	0,	0,	4,	5,	Claass.viking,Rarity.common, ItemType.weapon, "Axe with Shield"),
	//knight armor
HeavyArmor		(1, 	100, 	0,	10,	2,	0,	3,	10,	Claass.knight,Rarity.common, ItemType.armor, "Heavy Armor"),
	//ranger armor
LightArmor		(1, 	50, 	20,	2,	10,	4,	7,	10,	Claass.ranger,Rarity.common, ItemType.armor, "Light Armor"),
	//mage armor
Robe			(1, 	20, 	80,	0,	2,	10,	5,	10,	Claass.mage,Rarity.common, ItemType.armor, "Robe"),
	//viking armor
MidArmor		(1, 	60, 	0,	7,	3,	3,	5,	10,	Claass.viking,Rarity.common, ItemType.armor, "Medium Armor"),
	//first Items
fists			(1,1,1,1,1,1,1,0,Claass.all,Rarity.common, ItemType.weapon, "fists"),
nakedBody		(1,1,1,1,1,1,1,0,Claass.all,Rarity.common, ItemType.armor, "naked body");


	public ItemType itemTypes;
	public Claass itemClaass;
	public int itemLVL,HP,MP,S,A,I,L,gold;
	public Rarity raritys;
	public String name;
	
	private Item (int itemLVL,int HP,int MP,int S,int A,int I,int L,int gold,Claass itemClaass, Rarity raritys, ItemType itemTypes, String name) {
		this.itemClaass=itemClaass;
		this.itemLVL=itemLVL;
		this.HP=HP;
		this.MP=MP;
		this.S=S;
		this.A=A;
		this.I=I;
		this.L=L;
		this.gold=gold;
		this.itemTypes=itemTypes;
		this.raritys=raritys;
		this.name=name;
		
	}
	
	
	
	public static String showFullItemDescription(Item itemName){
		return(itemName.name + " \nposiada nastêpuj¹ce statystyki: \n" +
		"LVL: " + itemName.itemLVL + "\n" +
		" HP: " + itemName.HP + "\n" +
		" MP: " + itemName.MP + "\n" +
		" S: " + itemName.S + " " +
		" A: " + itemName.A + " " +
		" I: " + itemName.I + " " +
		" L: " + itemName.L + " " +
		"\n" + " Sell price: " + itemName.gold + " gold coins\n" +
		" Rarity: " + itemName.raritys + "\n" +
		" Typ: " + itemName.itemTypes + "\n" +
		" Class: " + itemName.itemClaass + "\n");	
	}
	
	public static String showShortItemDescription(Item itemName){
		return (itemName.raritys + itemName.name + " w skrocie: \n" + 
		"LVL: " + itemName.itemLVL +
		"\n Sell price: " + itemName.gold + " gold coins" +
		"\n Rarity: " + itemName.raritys +
		"\n Typ: " + itemName.itemTypes +
		"\n Class: " + itemName.itemClaass);	
	}
	
	public static Item loadItemStats(Item oldItem){
		oldItem.HP=oldItem.itemLVL*oldItem.HP;
		oldItem.MP=oldItem.itemLVL*oldItem.MP;
		oldItem.S=oldItem.itemLVL*oldItem.S;
		oldItem.A=oldItem.itemLVL*oldItem.A;
		oldItem.I=oldItem.itemLVL*oldItem.I;
		oldItem.L=oldItem.itemLVL*oldItem.L;
		oldItem.gold=oldItem.itemLVL*oldItem.gold;
		return oldItem;
	}
	
	public static Item reloadItemStats(Item oldItem){
		oldItem.HP=oldItem.HP/oldItem.itemLVL;
		oldItem.MP=oldItem.MP/oldItem.itemLVL;
		oldItem.S=oldItem.S/oldItem.itemLVL;
		oldItem.A=oldItem.A/oldItem.itemLVL;
		oldItem.I=oldItem.I/oldItem.itemLVL;
		oldItem.L=oldItem.L/oldItem.itemLVL;
		oldItem.gold=oldItem.gold/oldItem.itemLVL;
		oldItem.itemLVL++;
		oldItem.HP=oldItem.itemLVL*oldItem.HP;
		oldItem.MP=oldItem.itemLVL*oldItem.MP;
		oldItem.S=oldItem.itemLVL*oldItem.S;
		oldItem.A=oldItem.itemLVL*oldItem.A;
		oldItem.I=oldItem.itemLVL*oldItem.I;
		oldItem.L=oldItem.itemLVL*oldItem.L;
		oldItem.gold=oldItem.itemLVL*oldItem.gold;
		return oldItem;
	}
}
