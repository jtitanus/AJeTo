package info.agentviolet.model.objectAttributes;

import info.agentviolet.model.IWorldObject;

public interface IConsumable {
	
	void consume(IWorldObject subject);
	
	String getEatMessage();
}
