/*
 * Class EnemySpawner
 * Involves a thread that is responsible for creating enemy objects
 * Also creates more enemies when enemies are killed
 * @author Sean Alexander Porras
 */

package finalproject;

import java.util.ArrayList;
import java.util.Random;

public class EnemySpawner {
	//enemy objects
	private Warrior warrior;
	private Thief thief;
	private Tank tank;
	
	static ArrayList<Enemy> enemies = new ArrayList<>();
	static int enemyCount;
	
	public EnemySpawner(){
		Enemy.createScoreCounter();
		Enemy.createWinCondition();
		Enemy.createResultChecker();
		this.spawnEnemies();
	}
	
	public static ArrayList<Enemy> getEnemies(){
		return enemies;
	}
	
	//thread responsible for creating enemies
	//every enemy created is added to an ArrayList
	public void spawnEnemies() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				
				while(true) {
					if (Enemy.enemyCount < 5) {
						Random random = new Random();
						int randomNumberHolder = random.nextInt(3)+1;
						switch (randomNumberHolder) {
						case 1:
							warrior = new Warrior();
							warrior.addEnemyPanel();
							warrior.enemyAttack();
							enemies.add(warrior);
							break;
						case 2:
							thief = new Thief();
							thief.addEnemyPanel();
							thief.enemyAttack();
							enemies.add(thief);
							break;
						case 3:
							tank = new Tank();
							tank.addEnemyPanel();
							tank.enemyAttack();
							enemies.add(tank);
							break;
						}	
					}
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}	
		});
		thread.start();
	}
}


