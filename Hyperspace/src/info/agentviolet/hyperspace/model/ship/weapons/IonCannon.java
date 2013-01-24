package info.agentviolet.hyperspace.model.ship.weapons;

import info.agentviolet.hyperspace.model.DamageType;
import info.agentviolet.hyperspace.model.ship.SpaceShip;

public class IonCannon extends WeaponBase {

	public IonCannon(SpaceShip ship) {
		super(ship);
	}

	@Override
	public float getNominalDamage() {
		return 10f;
	}

	@Override
	public DamageType getDamageType() {
		return DamageType.ION;
	}

	@Override
	public int getPowerConsumption() {
		return 1;
	}

	@Override
	public String getName() {
		return "Ion Cannon MkI";
	}

	@Override
	public float getMass() {
		return 1.5f;
	}

}
