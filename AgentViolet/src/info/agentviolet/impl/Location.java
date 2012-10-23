package info.agentviolet.impl;

import java.util.Date;

import info.agentviolet.model.ILocation;
import info.agentviolet.model.ISpaceVector;

public class Location implements ILocation {

	private ISpaceVector pos = new SpaceVector();
	private ISpaceVector lookPos = new SpaceVector();
	private Date lastUpdateTime = new Date();
	private float velocity = 0f;

	@Override
	public ISpaceVector getPosition() {
		return pos;
	}

	@Override
	public ISpaceVector getLookingPosition() {
		return lookPos;
	}

	@Override
	public void setLookingPosition(ISpaceVector lookingPosition) {
		lookPos = lookingPosition;
	}

	@Override
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	@Override
	public float getVelocity() {
		return velocity;
	}

	@Override
	public void setVelocity(float velocity) {
		this.velocity = velocity;		
	}

}
