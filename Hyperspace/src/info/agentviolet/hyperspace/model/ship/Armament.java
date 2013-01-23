package info.agentviolet.hyperspace.model.ship;

public class Armament implements IPowerConsumer {

	private static final String STR_WEAPON_ARRAY = "Weapon Array";
	private SpaceShip ship;	
	private boolean isActivated = true;

	public Armament(SpaceShip ship) {
		this.ship = ship;
	}

	@Override
	public SpaceShip getShip() {
		return ship;
	}

	@Override
	public String getName() {
		return STR_WEAPON_ARRAY;
	}

	@Override
	public float getMass() {
		return 0f; // TODO get mass of weapon array
	}

	
	@Override
	public int getPowerConsumption() {
		return isActivated ? 0 : 0; // TODO get power of all weapons
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
