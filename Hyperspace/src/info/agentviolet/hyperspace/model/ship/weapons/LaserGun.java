package info.agentviolet.hyperspace.model.ship.weapons;

import info.agentviolet.hyperspace.model.DamageType;
import info.agentviolet.hyperspace.model.ship.SpaceShip;

public class LaserGun extends WeaponBase {

	private static final String STR_NAME = "Laser MkI";

	public LaserGun(SpaceShip ship) {
		super(ship);
	}

	@Override
	public float getNominalDamage() {
		return 5f;
	}

	@Override
	public DamageType getDamageType() {
		return DamageType.LASER;
	}

	@Override
	public int getPowerConsumption() {
		return 1;
	}

	@Override
	public String getName() {	
		return STR_NAME;
	}

	@Override
	public float getMass() {
		return 0.25f;
	}

}
