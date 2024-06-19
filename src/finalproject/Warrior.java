/*
 * Class Warrior
 * Enemy child class for warrior type enemies
 * @author Sean Alexander Porras
 */

package finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class Warrior extends Enemy implements IEnemyCanAttack{
	
	public Warrior(){
		this.enemyType = "warrior";
		this.enemyHP = 70;
		this.enemyAttack = 15;
		this.enemyEvasion = 0;
		this.enemyDefense = 0;
		this.enemyPoints = 10;
		this.enemyAtkTimer = 50;
		this.enemyAtkSpeed = 50;
		
		this.sprite = new ImageIcon("Images/Katsumi_Default.png");
		this.spriteAttacked = new ImageIcon("Images/Katsumi_Attacked.png");
		this.spriteDodged = new ImageIcon("Images/Katsumi_Dodged.png");
		this.spriteBlocked = new ImageIcon("Images/Katsumi_Blocked.png");
			
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
