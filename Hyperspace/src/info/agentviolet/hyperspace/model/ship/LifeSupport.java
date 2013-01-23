package info.agentviolet.hyperspace.model.ship;

public class LifeSupport implements IPowerConsumer {

	private boolean isActivated = true;
	private static final String STR_LIFE_SUPPORT = "Life Support";
	protected SpaceShip ship;

	public LifeSupport(SpaceShip ship) {
		this.ship = ship;
	}

	@Override
	public SpaceShip getShip() {
		return ship;
	}

	@Override
	public String getName() {		
		return STR_LIFE_SUPPORT;
	}

	@Override
	public float getMass() {
		return 1f;
	}
		
	@Override
	public int getPowerConsumption() {
		return isActivated ? 1 : 0; // TODO get power of all weapons
	}

	@Override
	public boolean isActivated() {		
		return isActivated;
	}

	@Override
	public void switchActivation() {
		isActivated = !isActivated;
	}
}
