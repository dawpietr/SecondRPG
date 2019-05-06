package rpg;

import java.util.Random;

public enum Monster {
	skeletonKnight(50, 20, 6, 10, "Skeleton Knight"),
	skeletonRanger(25, 32, 3, 10, "Skeleton Ranger"),
	skeletonMage(15, 60, 2, 20, "Skeleton Mage"),
	zombie(80, 12, 6, 15, "Zombie"),
	dryad(100, 28, 7, 20, "Dryad"),
	wywern(50, 20, 8, 20, "Wywern"),
	dragon(200, 40, 10, 100, "Dragon"),
	litch(70, 40, 5, 18, "Litch"),
	rabbit(5, 1, 1, 5, "Rabbit"),
	monstrum (0,0,0,0, "");
	
	int monsterHP;
	int monsterATT;
	int monsterDEF;
	double monsterEXP;
	public String monsterName;
	
	private Monster(int monsterHP, int monsterATT, int monsterDEF, double monsterEXP, String monsterName){
		this.monsterHP = monsterHP;
		this.monsterATT= monsterATT;
		this.monsterDEF = monsterDEF;
		this.monsterEXP= monsterEXP;
		this.monsterName = monsterName;
		
	}
	
	public static Monster getRandomMonster() {
        Random randomm = new Random();
        return values()[randomm.nextInt(values().length-1)];
	}

}
