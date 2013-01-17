package info.agentviolet.hyperspace.model.ship;

public class Storage implements IShipAggregate {

	protected SpaceShip ship;

	public Storage(SpaceShip ship) {
		this.ship = ship;
	}

	@Override
	public SpaceShip getShip() {
		return ship;
	}
}
