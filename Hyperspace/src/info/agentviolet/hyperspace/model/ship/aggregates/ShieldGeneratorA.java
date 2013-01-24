package info.agentviolet.hyperspace.model.ship.aggregates;

import info.agentviolet.hyperspace.model.ship.ShieldGenerator;
import info.agentviolet.hyperspace.model.ship.SpaceShip;

public class ShieldGeneratorA extends ShieldGenerator {

	public ShieldGeneratorA(SpaceShip ship) {
		super(ship, 100f);
	}

	@Override
	public String getName() {
		return "100";
	}

	@Override
	public float getMass() {
		return 1f;
	}
	
	@Override
	public int getPowerConsumption() {
		return isActivated ? 1 : 0;
	}

}
