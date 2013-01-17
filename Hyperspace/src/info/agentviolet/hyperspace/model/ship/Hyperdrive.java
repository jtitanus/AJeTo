package info.agentviolet.hyperspace.model.ship;

public class Hyperdrive implements IShipAggregate {

	protected SpaceShip ship;

	public Hyperdrive(SpaceShip ship) {
		this.ship = ship;
	}

	@Override
	public SpaceShip getShip() {
		return ship;
	}

}
