package info.agentviolet.hyperspace.model.ship;

import info.agentviolet.hyperspace.model.DamageType;

public abstract class Hull implements IShipAggregate {

	protected float hullIntegrity;
	protected final float hullIntegrityNominal;
	protected final SpaceShip ship;
	
	public Hull(SpaceShip ship, float hullIntegrityNominal) {
		this.ship = ship;
		this.hullIntegrityNominal = hullIntegrityNominal;
		hullIntegrity = hullIntegrityNominal;
	}
	
	@Override
	public SpaceShip getShip() {
		return ship;
	}

	@Override
	public String getName() {		
		return "Hull";
	}
	
	public void receiveDamage(float damage, DamageType type) {
		hullIntegrity -= damage;
	}
	
	public float getIntegrityPercentage() {
		return (hullIntegrity * 100f) / hullIntegrityNominal; 
	}

}
