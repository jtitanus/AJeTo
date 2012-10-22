package info.agentviolet.model.objectAttributes;

import info.agentviolet.model.IWorldObject;

public interface IConsumable extends IWorldObject {
	
	void consume(IWorldObject subject);
	
	String getEatMessage();
}
