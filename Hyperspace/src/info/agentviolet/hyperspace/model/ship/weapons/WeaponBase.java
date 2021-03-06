package info.agentviolet.hyperspace.model.ship.weapons;

import info.agentviolet.hyperspace.model.ship.IWeapon;
import info.agentviolet.hyperspace.model.ship.SpaceShip;

public abstract class WeaponBase implements IWeapon {
	
	private final SpaceShip ship;
	
	public WeaponBase(SpaceShip ship) {
		this.ship = ship;
	}
	
	@Override
	public SpaceShip getShip() {
		return ship;
	}

//	@Override
//	public boolean canFire() {
//		return ship.getArmament().canFire(this);
//	}	
//	
//	@Override
//	public void fireAt(ITargetable target) {
//		if(ship.getArmament().canFire(this)){
//			ship.getArmament().fireAtTarget(this);			
//		}
//	}	

}
