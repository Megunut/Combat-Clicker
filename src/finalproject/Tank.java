/*
 * Class Warrior
 * Enemy child class for tank type enemies
 * @author Sean Alexander Porras
 */

package finalproject;

import java.awt.event.MouseEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class Tank extends Enemy implements IEnemyCanAttack{
	
	public Tank(){
		this.enemyType = "tank";
		this.enemyHP = 90;
		this.enemyAttack = 8;
		this.enemyDefense = 50;
		this.enemyPoints = 17;
		this.enemyAtkTimer = 80;
		this.enemyAtkSpeed = 80;
		
		this.sprite = new ImageIcon("Images/Maple_Default.png");
		this.spriteAttacked = new ImageIcon("Images/Maple_Attacked.png");
		this.spriteDodged = new ImageIcon("Images/Maple_Dodged.png");
		this.spriteBlocked = new ImageIcon("Images/Maple_Blocked.png");
	}

	//thread allows enemy to attack the user repeatedly until it is killed
	@Override
	public void enemyAttack() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while(isAttacking) {
					if (enemyAtkTimer > 0) {
						enemyAtkTimer -= 1;
						enemyAtkIndicator.setValue(enemyAtkTimer);
						enemyAtkIndicator.revalidate();
					}
					//enemy attacks
					else if (enemyAtkTimer == 0){
						enemyAtkTimer = enemyAtkSpeed;
						if(Block.isBlocking != true) {
							int currentHP = HP.getCurrentHP();
							HP.updateHPBar(enemyAttack);
							result.checkLose(HP.getCurrentHP());
						}
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}	
		});
		thread.start();
	}
}
