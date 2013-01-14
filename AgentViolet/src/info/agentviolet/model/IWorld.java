package info.agentviolet.model;

import info.agentviolet.view.IViewLayer;

import java.util.Collection;
import java.util.List;

public interface IWorld {

	Collection<IWorldObject> getWorldObjects();

	void addObject(IWorldObject worldObject);

	void update();
	
	IAttributes getAttributes();
	
	List<IViewLayer> getViewLayers();

}
