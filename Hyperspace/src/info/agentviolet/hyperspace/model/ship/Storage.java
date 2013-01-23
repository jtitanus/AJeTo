package info.agentviolet.hyperspace.model.ship;

public class Storage implements IShipAggregate {

	private static final String STR_STORAGE = "Storage";
	protected SpaceShip ship;

	public Storage(SpaceShip ship) {
		this.ship = ship;
	}

	@Override
	public SpaceShip getShip() {
		return ship;
	}

	@Override
	public String getName() {
		return STR_STORAGE;
	}

	@Override
	public float getMass() {		
		return 0f; // maybe return the mass of the cargo
	}
}
