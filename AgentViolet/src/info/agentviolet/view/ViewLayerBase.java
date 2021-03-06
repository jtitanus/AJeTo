package info.agentviolet.view;

import info.agentviolet.model.IWorldObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ViewLayerBase implements IViewLayer {

	protected final List<IWorldObject> worldObjects = new ArrayList<IWorldObject>();
	protected IViewLayerPresentationContext presentationContext;
	protected boolean isVisible = true;

	public ViewLayerBase(IViewLayerPresentationContext presentationContext) {
		this.presentationContext = presentationContext;
	}

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
		if (isVisible && !isStatic()) {
			for (IWorldObject wo : worldObjects) {
				wo.update();
			}
		}
	}

	@Override
	public void draw() {
		if (isVisible) {
			presentationContext.draw(this);
		}
	}

	@Override
	public IViewLayerPresentationContext getViewLayerPresentationContext() {
		return presentationContext;
	}

	@Override
	public void setViewLayerPresentationContext(IViewLayerPresentationContext presentationContext) {
		this.presentationContext = presentationContext;
	}

	@Override
	public boolean isStatic() {
		return false;
	}

	@Override
	public void setVisibility(boolean isVisible) {
		this.isVisible = isVisible;
	}

}
