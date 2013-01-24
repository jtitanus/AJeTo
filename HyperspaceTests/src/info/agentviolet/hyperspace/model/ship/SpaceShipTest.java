package info.agentviolet.hyperspace.model.ship;

import junit.framework.Assert;
import info.agentviolet.hyperspace.model.ship.designs.Hybris;
import info.agentviolet.hyperspace.model.ship.designs.Manta;

import org.junit.Test;

public class SpaceShipTest {

	@Test
	public void testGetMass() {
		SpaceShip ship = new Hybris();
		Assert.assertEquals(60.2f, ship.getMass(), 1E-5f);
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
		ship = new Manta();		
		Assert.assertEquals(100f, ship.getHull().getIntegrityPercentage(), 1E-5f);
	}

	@Test
	public void testEncounterHybrisManta1() {
		Hybris hybris = new Hybris();
		Manta manta = new Manta();
		hybris.getArmament().setTarget(manta);
		manta.getArmament().setTarget(hybris);
		Assert.assertEquals(manta, hybris.getArmament().getTarget());
		Assert.assertEquals(hybris, manta.getArmament().getTarget());
		
		for (int i = 0; i < 10; i++) {
			hybris.update();
			manta.update();
		}
		
		Assert.assertEquals(10f, hybris.getShieldGen().getCurrentCapacity(), 1E-5f);
		Assert.assertEquals(10f, manta.getShieldGen().getCurrentCapacity(), 1E-5f);
		Assert.assertEquals(10, hybris.getArmament().getEnergyPool());
		Assert.assertEquals(10, manta.getArmament().getEnergyPool());
		hybris.getArmament().canFire(hybris.getArmament().getWeaponArray().get(0));
		hybris.getArmament().canFire(hybris.getArmament().getWeaponArray().get(1));
		manta.getArmament().canFire(manta.getArmament().getWeaponArray().get(0));
		manta.getArmament().canFire(manta.getArmament().getWeaponArray().get(1));
		hybris.getArmament().fireAllEnergyWeapons();
		Assert.assertEquals(0f, manta.getShieldGen().getCurrentCapacity(), 1E-5f);
		manta.getArmament().fireAllEnergyWeapons();
		Assert.assertEquals(0f, hybris.getShieldGen().getCurrentCapacity(), 1E-5f);
		Assert.assertEquals(8, hybris.getArmament().getEnergyPool());
		Assert.assertEquals(8, manta.getArmament().getEnergyPool());

		Assert.assertEquals(100f, hybris.getHull().getIntegrityPercentage(), 1E-5f);
		Assert.assertEquals(100f, manta.getHull().getIntegrityPercentage(), 1E-5f);

		hybris.getArmament().fireAllEnergyWeapons();
		Assert.assertTrue(manta.getHull().getIntegrityPercentage() < 99f);
		manta.getArmament().fireAllEnergyWeapons();
		Assert.assertTrue(hybris.getHull().getIntegrityPercentage() < 99f);		
	}
	
}
