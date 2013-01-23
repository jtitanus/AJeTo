package info.agentviolet.hyperspace.model.ship;

import info.agentviolet.hyperspace.model.DamageType;

public interface ITargetable {

	void receiveDamage(float damage, DamageType type);
	
}
