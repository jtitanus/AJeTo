/**
 * 
 */
package info.agentviolet.utils;

import static org.junit.Assert.*;
import info.agentviolet.impl.SpaceVector;
import info.agentviolet.model.ISpaceVector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 */
public class VectorUtilsTest {

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

	/**
	 * Test method for {@link info.agentviolet.utils.VectorUtils#isAtPosition(info.agentviolet.model.ISpaceVector, info.agentviolet.model.ISpaceVector, float)}.
	 */
	@Test
	public void testIsAtPositionTrue() {
		ISpaceVector from = new SpaceVector(3f, 4f, 0f);
		ISpaceVector to = new SpaceVector(3f, 4f, 0f);
		assertEquals(true, VectorUtils.isAtPosition(from, to, 0.01f));
		
		from = new SpaceVector(3f, 4.002f, 0f);
		to = new SpaceVector(3f, 4f, 0f);
		assertEquals(true, VectorUtils.isAtPosition(from, to, 0.01f));
		
		from = new SpaceVector(3f, 4.002f, 0f);
		to = new SpaceVector(3.01f, 4f, 0f);
		assertEquals(true, VectorUtils.isAtPosition(from, to, 0.01f));
	}

	@Test
	public void testIsAtPositionFalse() {
		ISpaceVector from = new SpaceVector(3f, 4f, 0f);
		ISpaceVector to = new SpaceVector(3f, 4.02f, 0f);
		assertEquals(false, VectorUtils.isAtPosition(from, to, 0.01f));
		
		from = new SpaceVector(3f, 4f, 0.02f);
		to = new SpaceVector(3f, 4f, 0f);
		assertEquals(false, VectorUtils.isAtPosition(from, to, 0.01f));
		
		from = new SpaceVector(3f, 4f, 0.0f);
		to = new SpaceVector(3.2f, 4f, 0f);
		assertEquals(false, VectorUtils.isAtPosition(from, to, 0.01f));
	}
	
	@Test
	public void testSubtract() {
		ISpaceVector from = new SpaceVector(3f, 4f, 5f);
		ISpaceVector to = new SpaceVector(3f, 4f, 5f);
		ISpaceVector diff = VectorUtils.subtract(to, from);
		
		assertEquals(0f, diff.getX(), 1E-5f);
		assertEquals(0f, diff.getY(), 1E-5f);
		assertEquals(0f, diff.getZ(), 1E-5f);
	}
	
	@Test
	public void testAdd() {
		ISpaceVector from = new SpaceVector(3f, 4f, 5f);
		ISpaceVector to = new SpaceVector(3f, 4f, 5f);
		ISpaceVector addition = VectorUtils.add(to, from);
		
		assertEquals(6f, addition.getX(), 1E-5f);
		assertEquals(8f, addition.getY(), 1E-5f);
		assertEquals(10f, addition.getZ(), 1E-5f);
	}
	
	@Test
	public void testGetDistance0() {
		ISpaceVector from = new SpaceVector(3f, 4f, 5f);
		ISpaceVector to = new SpaceVector(3f, 4f, 5f);
		float dist = VectorUtils.getDistance(from, to);
		
		assertEquals(0f, dist, 1E-5f);		
	}
	
	@Test
	public void testGetDistance1() {
		ISpaceVector from = new SpaceVector(3f, 4f, 5f);
		ISpaceVector to = new SpaceVector(2f, 4f, 5f);
		float dist = VectorUtils.getDistance(from, to);
		
		assertEquals(1f, dist, 1E-5f);		
	}
	
	@Test
	public void testGetDistance2() {
		ISpaceVector from = new SpaceVector(3f, 4f, 5f);
		ISpaceVector to = new SpaceVector(3f, 2f, 5f);
		float dist = VectorUtils.getDistance(from, to);
		
		assertEquals(2f, dist, 1E-5f);		
	}
	
	@Test
	public void testGetDistance3() {
		ISpaceVector from = new SpaceVector(3f, 4f, 2f);
		ISpaceVector to = new SpaceVector(3f, 4f, 5f);
		float dist = VectorUtils.getDistance(from, to);
		
		assertEquals(3f, dist, 1E-5f);		
	}
	
	/**
	 * Test method for {@link info.agentviolet.utils.VectorUtils#getAngle(info.agentviolet.model.ISpaceVector, info.agentviolet.model.ISpaceVector)}.
	 */
	@Test
	public void testGetAngle() {
		ISpaceVector testPos = new SpaceVector(1f, 1f, 0f);
		assertEquals(45f, VectorUtils.getAngleXY(testPos), 1E-4f);
		testPos = new SpaceVector(0f, 1f, 0f);
		assertEquals(90f, VectorUtils.getAngleXY(testPos), 1E-4f);
		testPos = new SpaceVector(1f, 0f, 0f);
		assertEquals(0f, VectorUtils.getAngleXY(testPos), 1E-4f);
		testPos = new SpaceVector(-1f, -1f, 0f);
		assertEquals(225f, VectorUtils.getAngleXY(testPos), 1E-4f);
		testPos = new SpaceVector(-1f, 0f, 0f);
		assertEquals(180f, VectorUtils.getAngleXY(testPos), 1E-4f);
		testPos = new SpaceVector(0f, -1f, 0f);
		assertEquals(270f, VectorUtils.getAngleXY(testPos), 1E-4f);
		testPos = new SpaceVector(1f, -1f, 0f);
		assertEquals(315f, VectorUtils.getAngleXY(testPos), 1E-4f);
		testPos = new SpaceVector(-1f, 1f, 0f);
		assertEquals(135f, VectorUtils.getAngleXY(testPos), 1E-4f);		
	}

	@Test
	public void testGetVectorByAngle() {
		ISpaceVector testPos = VectorUtils.getVectorByAngle(0f, 1f);
		assertEquals(1f, testPos.getX(), 1E-4f);
		assertEquals(0f, testPos.getY(), 1E-4f);
		testPos = VectorUtils.getVectorByAngle(90f, 1f);
		assertEquals(0f, testPos.getX(), 1E-4f);
		assertEquals(1f, testPos.getY(), 1E-4f);
		testPos = VectorUtils.getVectorByAngle(180f, 1f);
		assertEquals(-1f, testPos.getX(), 1E-4f);
		assertEquals(0f, testPos.getY(), 1E-4f);
		testPos = VectorUtils.getVectorByAngle(270f, 1f);
		assertEquals(0f, testPos.getX(), 1E-4f);
		assertEquals(-1f, testPos.getY(), 1E-4f);
		testPos = VectorUtils.getVectorByAngle(45f, 1f);
		assertEquals(0.7071067f, testPos.getX(), 1E-4f);
		assertEquals(0.7071067f, testPos.getY(), 1E-4f);
	}
}
