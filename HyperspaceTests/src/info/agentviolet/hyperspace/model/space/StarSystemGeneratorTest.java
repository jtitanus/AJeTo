package info.agentviolet.hyperspace.model.space;

import static org.junit.Assert.*;

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
		long seed = 13;
		Random rnd = new Random(seed);
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
	public void testGenerate() {
		
	}

}
