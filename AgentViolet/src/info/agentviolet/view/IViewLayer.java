package info.agentviolet.view;

import java.util.Collection;

import info.agentviolet.model.IWorldObject;

public interface IViewLayer {
	
	void setViewLayerPresentationContext(IViewLayerPresentationContext presentationContext);
	
	IViewLayerPresentationContext getViewLayerPresentationContext();
	
	void update();
	
	void draw();
	
	void setVisibility(boolean isVisible);
	
	IWorldObject addObject(IWorldObject worldObject);
	
	Collection<IWorldObject> getWorldObjects();

	boolean isStatic();
	
}
