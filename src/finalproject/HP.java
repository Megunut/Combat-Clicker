/*
 * Class HP
 * Responsible for HP related fields and methods
 * @author Sean Alexander Porras
 */

package finalproject;

import java.awt.*;

import javax.swing.*;

public class HP extends ResourceBar{
	
	public HP(){
		this.foreground = new Color(0x684e3c);
		this.name = "HP: ";
		this.maxVal = 100;
		this.currentVal = 100;
	}
	
	//calculates remaining HP after being attacked
	public int takeDamage(int enemyAtk) {
		this.currentVal -= enemyAtk;
		return this.currentVal;
	}
	
	public static int getCurrentHP() {
		return hp.currentVal;
	}
	
	//adds HP bar into a JPanel
	public void addHPBar(ResourceBar[] resourceBars) {
		ResourceBar hp = resourceBars[0];
		
		hpBar = new JProgressBar(0,hp.maxVal);
		hpBar.setValue(hp.currentVal);
		hpBar.setForeground(hp.foreground);
		hpBar.setStringPainted(true);
		hpBar.setFont(new Font("Arial",Font.BOLD,25));
		hpBar.setString(hp.name + hp.currentVal + "/" + hp.maxVal);
		southLeftPanel.add(hpBar);		
	}
	
	//thread allows HP bar to regenerate
	public static void regenHP() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while(inGame) {
					if (hp.currentVal < hp.maxVal & Block.isBlocking != true) { //
						hp.currentVal += 1;
						hpBar.setValue(hp.currentVal);
						hpBar.setString(hp.name + hp.currentVal + "/" + hp.maxVal);
						hpBar.revalidate();
					}
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
			}	
		});
		thread.start();
	}
	
	//updates HP bar when user is attacked
	public static void updateHPBar (int enemyAtk) {
		hp.currentVal = hp.takeDamage(enemyAtk);
		hpBar.setValue(hp.currentVal);
		hpBar.setString(hp.name + hp.currentVal + "/" + hp.maxVal);
	}
	
	//locks HP Bar when user is blocking
	public static void hpLocked() {
		hpBar.setString("LOCKED");
		hpBar.setForeground(Color.GRAY);
		hpBar.setValue(hp.currentVal);
	}
	
	//unlocks HP Bar when user is no longer blocking
	public static void hpUnlocked() {
		hpBar.setString(hp.name + hp.currentVal + "/" + hp.maxVal);
		hpBar.setForeground(hp.foreground);
	}
}
