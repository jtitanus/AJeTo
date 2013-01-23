package info.agentviolet.hyperspace.model.space;

import info.agentviolet.utils.Dice;

import java.text.DecimalFormat;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Random;

import org.junit.Test;


public class NameGeneratorTest {

	@Test
	public void testCompose() {
		Random rnd = new Random(13L);
		NameGenerator gen = new NameGenerator(rnd);
		HashSet<String> names = new HashSet<String>();
		int collisions = 0;
		long duration = 0L;
		for (int i = 0; i < 100000; i++) {
			int length = Dice.rollInt(rnd, 4) + 2;
			String genName;
			long time1 = System.nanoTime();
			genName = gen.compose(length);
			long time2 = System.nanoTime();
			duration += time2-time1;
			String name = "(" + length + ") : " + genName.trim();
			if(names.contains(name)) {
				collisions++;
			}
			else {
				names.add(name);
			}
		}
		for(String name:names){
			System.out.println(name);
		}
		System.out.println("\nDuration: " + new DecimalFormat("###,###").format(duration)); // 682.174.169
		System.out.println("Collisions: " + collisions);
		System.out.println("Unique names: " + names.size());
	}

}
