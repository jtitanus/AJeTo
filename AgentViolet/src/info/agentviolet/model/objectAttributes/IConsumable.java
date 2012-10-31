package info.agentviolet.model.objectAttributes;

import info.agentviolet.model.IAgent;
import info.agentviolet.model.ISatisfactionGiver;
import info.agentviolet.model.IWorldObject;

public interface IConsumable extends IWorldObject, ISatisfactionGiver {
	
	void consume(IAgent subject);
	
	String getEatMessage();
		
}
