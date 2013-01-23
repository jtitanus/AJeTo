package info.agentviolet.hyperspace.model.ship.aggregates;

import info.agentviolet.hyperspace.model.ship.ShieldGenerator;
import info.agentviolet.hyperspace.model.ship.SpaceShip;

public class ShieldGeneratorA extends ShieldGenerator {

	private boolean isActivated = true;
	
	public ShieldGeneratorA(SpaceShip ship) {
		super(ship);
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
		return isActivated ? 1 : 0; // TODO get power of all weapons
	}

	@Override
	public boolean isActivated() {		
		return isActivated;
	}

	@Override
	public void switchActivation() {
		isActivated = !isActivated;
	}
	
}
