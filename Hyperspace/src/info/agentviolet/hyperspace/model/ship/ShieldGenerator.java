package info.agentviolet.hyperspace.model.ship;

public abstract class ShieldGenerator implements IPowerConsumer {

	protected SpaceShip ship;

	public ShieldGenerator(SpaceShip ship) {
		this.ship = ship;
	}

	@Override
	public SpaceShip getShip() {
		return ship;
	}

}
