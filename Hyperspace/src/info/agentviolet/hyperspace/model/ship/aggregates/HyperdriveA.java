package info.agentviolet.hyperspace.model.ship.aggregates;

import info.agentviolet.hyperspace.model.ship.Hyperdrive;
import info.agentviolet.hyperspace.model.ship.SpaceShip;

public class HyperdriveA extends Hyperdrive {

	private boolean isActivated = true;
	private static final String STR_NAME = "Hermes 2200";

	public HyperdriveA(SpaceShip ship) {
		super(ship);
		maxVelocityNominal = 200f;
		rangeNominal = 8f;
	}

	@Override
	public String getName() {
		return STR_NAME;
	}

	@Override
	public float getMass() {
		return 2.5f;
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
