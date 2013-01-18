package info.agentviolet.hyperspace.model.space;

import java.util.Random;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StarSystemGeneratorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRandomSeed() {		
		Random rnd = new Random(13);
		int i1 = rnd.nextInt();
		int i2 = rnd.nextInt();
		int i3 = rnd.nextInt();
		int i4 = rnd.nextInt();
		int i5 = rnd.nextInt();
		Assert.assertEquals(-1160486312, i1);
		Assert.assertEquals(1412442200, i2);
		Assert.assertEquals(1909600750, i3);
		Assert.assertEquals(88367997, i4);
		Assert.assertEquals(220262727, i5);
	}
	
	@Test
	public void testGenerate13() {
		StarSystem system = StarSystemGenerator.generate(13);
		Assert.assertNotNull(system);
		Assert.assertNotNull(system.getStar());
		Assert.assertEquals(1, system.getOrbits().size());
		Assert.assertNotNull(system.getSpaceStation());
		Assert.assertSame(system.getSpaceStation(), system.getOrbits().get(0));
		Assert.assertEquals(1, StarSystem.getAllSpaceObjectsOf(system.getStar()).size());
	}
	

	@Test
	public void testGenerateNeg13() {
		StarSystem system = StarSystemGenerator.generate(-13);
		Assert.assertNotNull(system);
		Assert.assertNotNull(system.getStar());
		Assert.assertEquals(1, system.getOrbits().size());
		Assert.assertNotNull(system.getSpaceStation());
		Assert.assertSame(system.getSpaceStation(), system.getOrbits().get(0).getOrbits().get(0));
		Assert.assertEquals(2, StarSystem.getAllSpaceObjectsOf(system.getStar()).size());
	}
	
}
