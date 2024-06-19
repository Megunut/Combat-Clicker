/*
 * Class WeaponManager
 * Responsible for creating weapon objects and adding them to the window
 * @author Sean Alexander Porras
 */

package finalproject;


public class WeaponManager{
	static Weapon[] weapons;
	
	public WeaponManager(){
		weapons = this.createWeapons();
		this.addWeaponButtons();
	}
	
	public static Weapon[] createWeapons() {
		Sword sword = new Sword();
		Dagger dagger = new Dagger();
		Hammer hammer = new Hammer();
		Weapon[] weapons = {sword,dagger,hammer};	
		return weapons;
	}
		
	public void addWeaponButtons() {
		for(Weapon x: weapons) {
			x.createWeaponButton();	
		}
	}
	
	//used to reset weapon icons when a weapon is equipped
	public static void weaponIconResetter() {
		for(Weapon x: weapons) {
			x.weaponIconToDefault();
		}
	}

}
