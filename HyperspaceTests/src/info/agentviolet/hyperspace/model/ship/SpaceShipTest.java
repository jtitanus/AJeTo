package info.agentviolet.hyperspace.model.ship;

import junit.framework.Assert;
import info.agentviolet.hyperspace.model.ship.designs.Hybris;

import org.junit.Test;

public class SpaceShipTest {

	@Test
	public void testGetMass() {
		SpaceShip ship = new Hybris();
		Assert.assertEquals(59.7f, ship.getMass(), 1E-5f);
	}

	@Test
	public void testGetNetMass() {
		SpaceShip ship = new Hybris();
		Assert.assertEquals(50f, ship.getNetMass(), 1E-5f);
	}

	@Test
	public void testGetHull() {
		SpaceShip ship = new Hybris();		
		Assert.assertEquals(100f, ship.getHull().getIntegrityPercentage(), 1E-5f);
	}

}
