package rpg;

import java.util.Random;

public class Fight extends Character {
	public Fight(String[] args) {
		super(args);
	}

	static double monsterLVL = 0;
	public static String myFightLog = "";
	static int allGold = 0;
	
	static Random rand = new Random();

	public static void main(int manyBattles) throws InterruptedException {
		int thisHeroHP = Character.heroHP;
		if (manyBattles == 1){
			thisHeroHP = battle(thisHeroHP);
			if (thisHeroHP>0) getGold(allGold);
		}
		else if (manyBattles>1){
			int ll = 0;
			do {
				thisHeroHP = battle(thisHeroHP);
				ll= ll+1;
			}while ((ll<manyBattles));
		if (thisHeroHP>0) getGold(allGold);
		myFightLog = myFightLog.concat("You havee earn: " +allGold+ " gold.\n");
		
		//dodanie przydzielanie przeedmiotów
		}
		rpg.SaveLoad.save();
		}
	
	//public static Monster monsterek;

	static int battle (int thiseheroHP) throws InterruptedException{
		Monster oponent = createMonster();
		int thisHeroHP = thiseheroHP;
		if (thisHeroHP > 0){
		do {int thisAttack = Fight.attack();
			myFightLog = myFightLog.concat("Hero attack in this turn: " + thisAttack + "\n");
			if (thisAttack>oponent.monsterDEF)
			oponent.monsterHP= (oponent.monsterHP) + (oponent.monsterDEF - thisAttack);
			thisHeroHP = thisHeroHP - oponent.monsterATT ;
			myFightLog = myFightLog.concat("Hero attack: " + (thisAttack - oponent.monsterDEF) +" damage.\t");
			if ((oponent.monsterATT- (Character.heroS*5))>0)
				myFightLog = myFightLog.concat("Monster attack: " + (oponent.monsterATT- (Character.heroS*5)) + " damage.\n");
			else myFightLog = myFightLog.concat("\n");
			myFightLog = myFightLog.concat(Character.getHeroName() + " HP: " + thisHeroHP + "/" + Character.heroHP + "\t");
			myFightLog = myFightLog.concat(oponent.monsterName + " HP: " + oponent.monsterHP + "\n");
			
		}while(oponent.monsterHP>=0 && thisHeroHP>=0);
		if (thisHeroHP<=0) {
			myFightLog = myFightLog.concat("YOU DIED, LOOOSER :)\n");
		}
		else if (oponent.monsterHP<=0) {
			getEXP ((int) oponent.monsterEXP); 
			myFightLog = myFightLog.concat("You have won and get " + oponent.monsterEXP + " EXP from monster." + "\n");
			allGold= allGold + randGold();
		}
		else System.out.println("Co sie do cholery jasnej niby stalo?");
		return (thisHeroHP);
		}myFightLog = myFightLog.concat("Dead people can't fight");
		return (thisHeroHP);
	}
	
	final static int randGold () {
		Random rand = new Random();
		int m = rand.nextInt(9);
		return (int) ((m+1) * (Character.heroLVL*(Math.pow(1.3, heroLVL))));
	}
	
	public static Monster createMonster(){
		Monster monstrum = Monster.monstrum;
		Monster.monstrum.monsterATT = 0;
		Monster.monstrum.monsterDEF = 0;
		Monster.monstrum.monsterEXP = 0;
		Monster.monstrum.monsterHP = 0;
		Monster.monstrum.monsterName = "monstrum";
		Monster monsterek = Monster.getRandomMonster();
		Monster.monstrum.monsterATT = monsterek.monsterATT;
		Monster.monstrum.monsterDEF= monsterek.monsterDEF;
		Monster.monstrum.monsterEXP= monsterek.monsterEXP;
		Monster.monstrum.monsterHP= monsterek.monsterHP;
		Monster.monstrum.monsterName= monsterek.monsterName;
		myFightLog = myFightLog.concat("You meet " + monstrum.monsterName + ": ");
		monstrum.monsterATT = (int) ((int) monstrum.monsterATT * Math.pow(1.3,monsterLVL));
		monstrum.monsterDEF= (int) ((int) monstrum.monsterDEF * Math.pow(1.3,monsterLVL));
		monstrum.monsterEXP= (int) ((int) monstrum.monsterEXP * Math.pow(1.3,monsterLVL));
		monstrum.monsterHP= (int) ((int) monstrum.monsterHP * Math.pow(1.3,monsterLVL));
		myFightLog = myFightLog.concat("HP: " +monstrum.monsterHP+ " DEF: " +monstrum.monsterDEF+ " ATT: " + monstrum.monsterATT + "\n");
		return(monstrum);
	}
	
	/*public void monster (double monsterHP, double monsterAttack, double monsterDef, int difficulty){
		
	if (difficulty == 0) monsterLVL = heroLVL;
		else if (difficulty == 1) monsterLVL = heroLVL +1;
		else if (difficulty == 2) monsterLVL = heroLVL +2;
		else if (difficulty == 3) monsterLVL = heroLVL+4;
		monsterHP = monsterHP * monsterLVL;
		monsterAttack = monsterAttack * monsterLVL;
		monsterDef = monsterDef * monsterLVL;
		
	}*/
	
	public static int attack () {
		int attack = 0;
		double h = rand.nextDouble();
		double luck;
		if (h<heroL/10) luck =(5+(2*h));  //critical attack
		else luck = 5;
		if (heroClaass == Claass.knight || heroClaass == Claass.viking)
			attack = (int) ((double)heroS*luck);
			else if (heroClaass == Claass.mage)
			attack = (int) ((double)heroI*luck);
			else if (heroClaass == Claass.ranger)
			attack = (int) ((double)heroA*luck);
		return attack;
	}
	
	public static String getFightLog(){
		return (myFightLog);
	}
	public static void setFightLogZero(){
		myFightLog = "";
	}
}
