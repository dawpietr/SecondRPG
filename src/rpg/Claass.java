package rpg;

public enum Claass {
	knight('w',1,170,50,8,4,4,4), 
	ranger('r',2,90,80,3,9,4,5), 
	mage('m',3,70,150,2,3,9,6), 
	viking('v',4,220,20,10,1,1,8), 
	all('a',0,0,0,0,0,0,0);
	
	
	
	char claassSign;
	int claassNumber;
	int HP,MP,S,A,I,L;
	private Claass(char claassSign, int claassNumber,int HP,int MP,int S,int A,int I,int L){
		this.claassSign=claassSign;
		this.claassNumber=claassNumber;
		this.HP=HP;
		this.MP=MP;
		this.S=S;
		this.A=A;
		this.I=I;
		this.L=L;
	}
}
