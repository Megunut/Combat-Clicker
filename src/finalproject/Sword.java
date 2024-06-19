/*
 * Class Sword
 * Initializes Sword object fields
 * @author Sean Alexander Porras
 */

package finalproject;

import javax.swing.ImageIcon;

public class Sword extends Weapon{
	public Sword (){
		this.weaponAtk = 15;
		this.weaponSPCost = 12;
		this.weaponArmorPen = 15;
		this.weaponAccuracy = 15;
		this.sprite = new ImageIcon("Images/sword_unequipped.png");
		this.spriteSelected = new ImageIcon("Images/sword_equipped.png");
	}
}
