package info.agentviolet.hyperspace.model.ship.aggregates;

import info.agentviolet.hyperspace.model.ship.Reactor;
import info.agentviolet.hyperspace.model.ship.SpaceShip;

public class ReactorA extends Reactor {

	private static final String STR_NAME = "Nova";

	public ReactorA(SpaceShip ship) {
		super(ship);
	}

	@Override
	public String getName() {
		return STR_NAME;
	}

	@Override
	public float getMass() {		
		return 5.2f;
	}

	@Override
	public int getPowerOutput() {
		return 10;
	}

}
