package info.agentviolet.hyperspace.model.ship.aggregates;

import info.agentviolet.hyperspace.model.ship.Hull;
import info.agentviolet.hyperspace.model.ship.SpaceShip;

public class StandardHull extends Hull {

	public StandardHull(SpaceShip ship, float hullIntegrityNominal) {
		super(ship, hullIntegrityNominal);
	}

	@Override
	public float getMass() {
		return ship.getNetMass();
	}

}
