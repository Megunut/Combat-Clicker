/*
 * Class HPTest
 * Tests HP class methods related user being attacked
 * @author Sean Alexander Porras
 */

package finalprojecttest;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import finalproject.GameFrame;
import finalproject.HP;
import finalproject.Tank;
import finalproject.Thief;
import finalproject.Warrior;

public class HPTest {

	static GameFrame gameFrame;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gameFrame = new GameFrame();
		gameFrame.createGame();	
	}

	@Test
	public void testTakeDamageFromWarrior() {
		Warrior warrior = new Warrior();
		HP hp = new HP();
		assertEquals(85,hp.takeDamage(warrior.getAtk()));
	}
	
	@Test
	public void testTakeDamageFromThief() {
		Thief thief = new Thief();
		HP hp = new HP();
		assertEquals(90,hp.takeDamage(thief.getAtk()));
	}
	
	@Test
	public void testTakeDamageFromTank() {
		Tank tank = new Tank();
		HP hp = new HP();
		assertEquals(92,hp.takeDamage(tank.getAtk()));
	}

}
