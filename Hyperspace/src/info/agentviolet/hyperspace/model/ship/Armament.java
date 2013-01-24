package info.agentviolet.hyperspace.model.ship;

import java.util.ArrayList;
import java.util.List;

public class Armament implements IPowerConsumer {

	private static final String STR_WEAPON_ARRAY = "Weapon Array";
	private final SpaceShip ship;
	private boolean isActivated = true;
	private int energyPool = 0;
	private final List<IWeapon> weaponArray;
	private final int maxWeaponCount;
	private ITargetable target = null;	

	public Armament(SpaceShip ship, int maxWeaponCount) {
		this.ship = ship;
		this.maxWeaponCount = maxWeaponCount;
		weaponArray = new ArrayList<IWeapon>(this.maxWeaponCount);
	}

	public List<IWeapon> getWeaponArray() {
		return weaponArray;
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
		float mass = 0f;
		for (IWeapon weapon : weaponArray) {
			mass += weapon.getMass();
		}
		return mass;
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

	public int getEnergyPool() {
		return energyPool;
	}

	public boolean canFire(IWeapon weapon) {
		return energyPool - weapon.getPowerConsumption() < 0;
	}

	public void fire(IWeapon weapon) {
		energyPool -= weapon.getPowerConsumption();
	}	
	
	public ITargetable getTarget() {
		return target;
	}

	public void setTarget(ITargetable target) {
		this.target = target;
	}
}
