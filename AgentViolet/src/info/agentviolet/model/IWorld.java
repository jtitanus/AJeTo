package info.agentviolet.model;

import java.util.Collection;

public interface IWorld {

	Collection<IWorldObject> getWorldObjects();

	void addObject(IWorldObject worldObject);

	void update();
	
	IAttributes getAttributes();		

}
