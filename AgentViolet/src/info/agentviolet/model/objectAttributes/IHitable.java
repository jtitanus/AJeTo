package info.agentviolet.model.objectAttributes;

import info.agentviolet.model.IWorldObject;

public interface IHitable extends IWorldObject {
	
	boolean isDestroyable();
	
	int getHitpoints();
	
	int getMaxHitpoints();
	
	void hit(int damage);
}
