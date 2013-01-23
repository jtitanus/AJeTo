package info.agentviolet.hyperspace.model.ship;

public abstract class Reactor implements IShipAggregate {

	protected SpaceShip ship;

	public Reactor(SpaceShip ship) {
		this.ship = ship;
	}

	@Override
	public SpaceShip getShip() {
		return ship;
	}
	
	/**
	 * @return output in mega watt
	 */
	public abstract int getPowerOutput();
}
