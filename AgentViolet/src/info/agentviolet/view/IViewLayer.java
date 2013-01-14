package info.agentviolet.view;

import java.util.Collection;

import info.agentviolet.model.IWorldObject;

public interface IViewLayer {
	
	IViewLayerPresentationContext getViewLayerPresentationContext();
	
	void update();
	
	void draw();
	
	IWorldObject addObject(IWorldObject worldObject);
	
	Collection<IWorldObject> getWorldObjects();
	
}
