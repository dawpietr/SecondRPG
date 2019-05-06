package rpg;

public enum ItemType {
	weapon('W',1), 
	armor('A',2);
	
	char letterSign;
	int numberSign;
	
	ItemType (char letterSign, int numberSign){
		this.letterSign=letterSign;
		this.numberSign=numberSign;
	}

}
