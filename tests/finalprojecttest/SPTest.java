/*
 * Class SPTest
 * Tests SP class methods related user spending SP when attacking
 * @author Sean Alexander Porras
 */

package finalprojecttest;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import finalproject.Dagger;
import finalproject.GameFrame;
import finalproject.Hammer;
import finalproject.SP;
import finalproject.Sword;

public class SPTest {
	
	static GameFrame gameFrame;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gameFrame = new GameFrame();
		gameFrame.createGame();
	}

	@Test
	public void testSpendSPUsingSword() {
		Sword sword = new Sword();
		SP sp = new SP();
		assertEquals(88,sp.spendSP(sword.getWeaponSPCost()));
	}
	
	@Test
	public void testSpendSPUsingDagger() {
		Dagger dagger = new Dagger();
		SP sp = new SP();
		assertEquals(90,sp.spendSP(dagger.getWeaponSPCost()));
	}
	
	@Test
	public void testSpendSPUsingHammer() {
		Hammer hammer = new Hammer();
		SP sp = new SP();
		assertEquals(80,sp.spendSP(hammer.getWeaponSPCost()));
	}
}
