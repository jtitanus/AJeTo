package info.agentviolet.hyperspace.model.ship;

public class ShieldGenerator implements IShipAggregate {

	protected SpaceShip ship;

	public ShieldGenerator(SpaceShip ship) {
		this.ship = ship;
	}

	@Override
	public SpaceShip getShip() {
		return ship;
	}

}
