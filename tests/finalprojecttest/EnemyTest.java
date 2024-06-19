/*
 * Class EnemyTest
 * Tests Enemy class methods related to attacking
 * @author Sean Alexander Porras
 */

package finalprojecttest;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import finalproject.*;


public class EnemyTest {

	static GameFrame gameFrame;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gameFrame = new GameFrame();
		gameFrame.createGame();	
	}

	@Test
	public void testUserAttackedWarriorUsingSword() {
		Weapon sword = new Sword();
		Enemy.getEquippedWeapon(sword);
		Warrior warrior = new Warrior(); 
		assertEquals(1,warrior.userAttacked());
	}
	
	@Test
	public void testUserAttackedWarriorUsingDagger() {
		Weapon dagger = new Dagger();
		Enemy.getEquippedWeapon(dagger);
		Warrior warrior = new Warrior(); 
		assertEquals(1,warrior.userAttacked());
	}
	
	@Test
	public void testUserAttackedWarriorUsingHammer() {
		Weapon hammer = new Hammer();
		Enemy.getEquippedWeapon(hammer);
		Warrior warrior = new Warrior(); 
		assertEquals(1,warrior.userAttacked());
	}
	
	@Test
	public void testUserAttackedThiefUsingDagger() {
		Weapon dagger = new Dagger();
		Enemy.getEquippedWeapon(dagger);
		Thief thief = new Thief(); 
		assertEquals(1,thief.userAttacked());
	}
	
	@Test
	public void testUserAttackedTankUsingHammer() {
		Weapon hammer = new Hammer();
		Enemy.getEquippedWeapon(hammer);
		Tank tank = new Tank(); 
		assertEquals(1,tank.userAttacked());
	}
	
	@Test
	public void testMousePressedNoEquippedWeapon() {
		Warrior warrior = new Warrior();
		warrior.mousePressed(null);
	}

}
