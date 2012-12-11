package info.agentviolet.impl;

import java.util.Date;

import info.agentviolet.model.ILocation;
import info.agentviolet.model.IAttributes;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.IWorldObject;

public abstract class WorldObjectBase implements IWorldObject {

	protected IWorld world;
	protected ILocation location = new Location();
	protected IAttributes attributes;
	protected Date lastUpdateTime = new Date();	
	protected boolean isActive = true;	
	
    @Override
    public IWorld getWorld() {
    	return world;
    }	
	
	@Override
	public ILocation getLocation() {	
		return location;
	}
	
	@Override
	public void update() {
		location.update();
		lastUpdateTime = new Date(System.nanoTime());
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

	@Override
	public IAttributes getAttributes() {
		return attributes;
	}
	
	@Override
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

}
