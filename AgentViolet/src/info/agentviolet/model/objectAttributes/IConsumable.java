package info.agentviolet.model.objectAttributes;

import info.agentviolet.model.IAgent;
import info.agentviolet.model.IWorldObject;

public interface IConsumable extends IWorldObject {
	
	void consume(IAgent subject);
	
	String getEatMessage();
}
