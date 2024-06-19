/*
 * Class Dagger
 * Initializes Dagger object fields
 * @author Sean Alexander Porras
 */

package finalproject;

import javax.swing.ImageIcon;

public class Dagger extends Weapon{
	public Dagger (){
		this.weaponAtk = 10;
		this.weaponSPCost = 10;
		this.weaponArmorPen = 0;
		this.weaponAccuracy = 50;
		this.sprite = new ImageIcon("Images/dagger_unequipped.png");
		this.spriteSelected = new ImageIcon("Images/dagger_equipped.png");
	}
}
