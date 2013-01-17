package info.agentviolet.hyperspace.model.ship;

public class Armament implements IShipAggregate {

	protected SpaceShip ship;

	public Armament(SpaceShip ship) {
		this.ship = ship;
	}

	@Override
	public SpaceShip getShip() {
		return ship;
	}
}
