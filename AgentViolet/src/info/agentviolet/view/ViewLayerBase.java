package info.agentviolet.view;

import info.agentviolet.model.IWorldObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class ViewLayerBase implements IViewLayer {

	protected final List<IWorldObject> worldObjects = new ArrayList<IWorldObject>();
	protected IViewLayerPresentationContext presentationContext;
		
	@Override
	public IWorldObject addObject(IWorldObject worldObject) {
		worldObjects.add(worldObject);
		return worldObject;
	}

	@Override
	public Collection<IWorldObject> getWorldObjects() {		
		return worldObjects;
	}
	
	@Override	
	public void update() {
		for(IWorldObject wo : worldObjects) {
			wo.update();
		}
	}
	
	@Override
	public void draw() {
		presentationContext.draw(this);	
	}
	
	@Override
	public IViewLayerPresentationContext getViewLayerPresentationContext() {		
		return presentationContext;
	}

}
