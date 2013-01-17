package info.agentviolet.hyperspace.model.ship;

public class LifeSupport implements IShipAggregate {

	protected SpaceShip ship;

	public LifeSupport(SpaceShip ship) {
		this.ship = ship;
	}

	@Override
	public SpaceShip getShip() {
		return ship;
	}
}
