/*
 * Class SP
 * Responsible for SP related fields and methods
 * @author Sean Alexander Porras
 */

package finalproject;

import java.awt.*;

import javax.swing.*;

public class SP extends ResourceBar{
	
	public SP(){
		this.foreground = new Color(0x91674b);
		this.name = "SP: ";
		this.maxVal = 100;
		this.currentVal = 100;
	}
	
	//calculates remaining SP after user attacks
	public int spendSP(int weaponSPCost) {
		this.currentVal -= weaponSPCost;
		return this.currentVal;
	}
	
	public static int getCurrentSP() {
		return sp.currentVal;
	}
	
	//adds SP bar into a JPanel
	public void addSPBar(ResourceBar[] resourceBars) {
		ResourceBar sp = resourceBars[1];
		
		spBar = new JProgressBar(0,sp.maxVal);
		spBar.setValue(sp.currentVal);
		spBar.setForeground(sp.foreground);
		spBar.setStringPainted(true);
		spBar.setFont(new Font("Arial",Font.BOLD,25));
		spBar.setString(sp.name + sp.currentVal + "/" + sp.maxVal);
		southLeftPanel.add(spBar);		
		
	}
	
	//thread allows SP bar to regenerate
	public static void regenSP() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while(inGame) {
					if (sp.currentVal < sp.maxVal & Block.isBlocking != true) {
						sp.currentVal += 1;
						spBar.setValue(sp.currentVal);
						spBar.setString(sp.name + sp.currentVal + "/" + sp.maxVal);
						spBar.revalidate();
					}
					try {
						Thread.sleep(80);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
			}	
		});
		thread.start();
	}
	
	//updates SP bar when user attacks
	public static void updateSPBar (int weaponSPCost) {
		sp.currentVal = sp.spendSP(weaponSPCost);
		spBar.setValue(sp.currentVal);
		spBar.setString(sp.name + sp.currentVal + "/" + sp.maxVal);
	}
	
	//locks SP Bar when user is blocking
	public static void spLocked() {
		spBar.setString("LOCKED");
		spBar.setForeground(Color.GRAY);
		spBar.setValue(sp.currentVal);
	}
	
	//unlocks SP Bar when user is no longer blocking
	public static void spUnlocked() {
		spBar.setString(sp.name + sp.currentVal + "/" + sp.maxVal);
		spBar.setForeground(sp.foreground);
	}

}
