/*
 * Class ResourceBar
 * Parent class for resource bar objects
 * @author Sean Alexander Porras
 */

package finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class ResourceBar {
	//resource bar fields
	protected String name;
	protected int currentVal;
	protected int maxVal;
	protected Color foreground;
	
	//GUI related variables
	static JPanel southLeftPanel;
	
	//static variables
	static HP hp;
	static SP sp;
	static JProgressBar hpBar;
	static JProgressBar spBar;
	static boolean inGame;
	
	ResourceBar[] resourceBars;
	
	//creates resource bars and adds to a JPanel
	public void addResourceBars() {
		resourceBars = this.createResourceBars();
		hp.addHPBar(resourceBars);
		sp.addSPBar(resourceBars);
	}
	
	public static void setPanel(JPanel panel) {
		southLeftPanel = panel;
	}
	
	//used to stop HP/SP regeneration
	public static void setStopRegen() {
		inGame = false;
	}
	
	public JPanel getPanel(){
		return southLeftPanel;
	}
	
	public static ResourceBar[] createResourceBars() {
		hp = new HP();
		sp = new SP();
		inGame = true;
		ResourceBar[] resourceBars = {hp,sp};
		return resourceBars;
	}
	
}
