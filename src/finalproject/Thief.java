/*
 * Class Warrior
 * Enemy child class for thief type enemies
 * @author Sean Alexander Porras
 */

package finalproject;

import java.awt.event.MouseEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class Thief extends Enemy implements IEnemyCanAttack{
	
	public Thief(){
		this.enemyType = "thief";
		this.enemyHP = 50;
		this.enemyAttack = 10;
		this.enemyEvasion = 50;
		this.enemyPoints = 12;
		this.enemyAtkTimer = 30;
		this.enemyAtkSpeed = 30;
		
		this.sprite = new ImageIcon("Images/Sally_Default.png");
		this.spriteAttacked = new ImageIcon("Images/Sally_Attacked.png");
		this.spriteDodged = new ImageIcon("Images/Sally_Dodged.png");
		this.spriteBlocked = new ImageIcon("Images/Sally_Blocked.png");
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
