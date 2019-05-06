package rpg;

public enum Rarity {
common('c',0),
uncommon('u',1),
rare('r',2),
special('s',3),
legendary('l',4),
mythical('m',5);
	
	char letterSign;
	int numberSign;
	
	Rarity(char letterSign, int numberSign) {
		this.letterSign=letterSign;
		this.numberSign=numberSign;
	}
	
	
}
