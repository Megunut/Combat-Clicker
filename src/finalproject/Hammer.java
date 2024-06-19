/*
 * Class Hammer
 * Initializes Hammer object fields
 * @author Sean Alexander Porras
 */

package finalproject;

import javax.swing.ImageIcon;

public class Hammer extends Weapon{
	public Hammer (){
		this.weaponAtk = 20;
		this.weaponSPCost = 20;
		this.weaponArmorPen = 50;
		this.weaponAccuracy = 0;
		this.sprite = new ImageIcon("Images/hammer_unequipped.png");
		this.spriteSelected = new ImageIcon("Images/hammer_equipped.png");
	}
}
