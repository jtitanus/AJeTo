package info.agentviolet.hyperspace.model.space;

import info.agentviolet.utils.Dice;

import java.util.Random;

import org.junit.Test;


public class NameGeneratorTest {

	@Test
	public void testCompose() {
		NameGenerator gen = new NameGenerator();
		Random rnd = new Random(13L);
		for (int i = 0; i < 10000; i++) {
			int length = Dice.rollInt(rnd, 3) + 2;
			System.out.print("(" + length + ") :");
			String name = gen.compose(length);
			System.out.println(name);
		}
	}

}
