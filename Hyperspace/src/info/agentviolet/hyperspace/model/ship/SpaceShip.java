package info.agentviolet.hyperspace.model.ship;

import info.agentviolet.hyperspace.model.DamageType;

public class SpaceShip {

	protected float mass; // in tons
	protected float hullIntegrity = 100f;

	public float getMass() {
		return mass;
	}

	public float getHullIntegrity() {
		return hullIntegrity;
	}

	public void inflictDamage(float damage, DamageType type) {
		
	}

}
