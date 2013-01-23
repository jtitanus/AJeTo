package info.agentviolet.hyperspace.model.ship.aggregates;

import info.agentviolet.hyperspace.model.ship.Hull;
import info.agentviolet.hyperspace.model.ship.SpaceShip;

public class LightHull extends Hull {

	public LightHull(SpaceShip ship, float hullIntegrityNominal) {
		super(ship, hullIntegrityNominal);
	}

	@Override
	public float getMass() {
		return ship.getNetMass() * 0.8f;
	}

}
