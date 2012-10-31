package info.agentviolet.model.objectAttributes;

import info.agentviolet.model.ISatisfactionGiver;
import info.agentviolet.model.IWorldObject;

public interface IHitable extends IWorldObject, ISatisfactionGiver {
	
	boolean isDestroyable();
	
	int getHitpoints();
	
	int getMaxHitpoints();
	
	void hit(int damage);
}
