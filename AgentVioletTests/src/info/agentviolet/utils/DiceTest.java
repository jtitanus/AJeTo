package info.agentviolet.utils;

import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;

public class DiceTest {

	@Test
	public void testRoll() {
		Random rnd = new Random(13);
		Object o = Dice.roll(new Object[] { 3, "Yellow",
											10, "Violet",
											33, "Red", 
											66, "Blue",
											100, "Greenbird" }, rnd);
		Assert.assertEquals("Red", (String) o);
	}

	@Test
	public void testRollInt() {
		Random rnd = new Random(13);
		Assert.assertEquals(11, Dice.rollInt(rnd, 13));
		rnd = new Random(13);
		Assert.assertEquals(8, Dice.rollInt(rnd, 12));
		rnd = new Random(13);
		Assert.assertEquals(12, Dice.rollInt(rnd, 20));
		for (int i = 0; i < 1000; i++) {
			Assert.assertTrue(20 > Dice.rollInt(rnd, 20));
			Assert.assertTrue(0 <= Dice.rollInt(rnd, 20));
		}
	}
}
