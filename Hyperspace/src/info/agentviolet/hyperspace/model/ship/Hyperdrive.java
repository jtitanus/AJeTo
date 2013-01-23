package info.agentviolet.hyperspace.model.ship;

public abstract class Hyperdrive implements IPowerConsumer {

	protected SpaceShip ship;
	protected float maxVelocityNominal;
	protected float rangeNominal;

	public Hyperdrive(SpaceShip ship) {
		this.ship = ship;
	}

	@Override
	public SpaceShip getShip() {
		return ship;
	}	
	
	public float getMaxVelocityNominal() {
		return maxVelocityNominal;
	}
			
	public float getRangeNominal() {
		return rangeNominal;
	}
	
	
}
