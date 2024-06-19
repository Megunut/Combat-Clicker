/*
 * Class Weapon
 * Parent class for weapon objects, contains weapon related fields and methods
 * @author Sean Alexander Porras
 */

package finalproject;

import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Weapon implements ActionListener{
	//weapon fields
	protected int weaponAtk;
	protected int weaponAccuracy;
	protected int weaponSPCost;
	protected int weaponArmorPen;
	protected ImageIcon sprite;
	protected ImageIcon spriteSelected;
	
	//GUI related variables	
	JButton weaponButton;
	static JPanel southMiddlePanel;

	
	public static void setPanel(JPanel panel) {
		southMiddlePanel = panel;
	}
	
	public JPanel getPanel(){;
		return southMiddlePanel;
	}
	
	public int getWeaponSPCost() {
		return weaponSPCost;
	}
	
	//creates weapon button
	public void createWeaponButton() {
		weaponButton = new JButton(sprite);
		weaponButton.setFocusable(false);	
		weaponButton.addActionListener(this);
		southMiddlePanel.add(weaponButton);
	}
	
	//used to reset weapon button icons
	public void weaponIconToDefault() {
		weaponButton.setIcon(sprite);
	}

	//Equips weapon when weapon button is pressed
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==weaponButton) {
			WeaponManager.weaponIconResetter();
			weaponButton.setIcon(spriteSelected);
			Enemy.getEquippedWeapon(this);
		}	
	}	
}
