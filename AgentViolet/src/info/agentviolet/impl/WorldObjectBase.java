package info.agentviolet.impl;

import info.agentviolet.model.ILocation;
import info.agentviolet.model.IWorldObject;

public abstract class WorldObjectBase implements IWorldObject {

	ILocation location = new Location();
	private boolean isActive = true;
	
	@Override
	public ILocation getLocation() {	
		return location;
	}

	@Override
	public void update() {
	}

	@Override
	public abstract boolean isStatic();

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
