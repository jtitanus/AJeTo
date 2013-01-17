package info.agentviolet.hyperspace.model.ship;

public class Reactor implements IShipAggregate {

	protected SpaceShip ship;

	public Reactor(SpaceShip ship) {
		this.ship = ship;
	}

	@Override
	public SpaceShip getShip() {
		return ship;
	}
}
