package info.agentviolet.hyperspace.model.ship;

import info.agentviolet.hyperspace.model.DamageType;

public interface IWeapon extends IShipAggregate  {

//	boolean canFire();
//	
//	void fireAt(ITargetable target);
	
	float getNominalDamage();
	
	DamageType getDamageType();
	
	int getPowerConsumption();
}
