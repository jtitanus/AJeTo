package info.agentviolet.impl;

import info.agentviolet.model.ILocation;
import info.agentviolet.model.ISpaceVector;

public final class Location implements ILocation {

	private final ISpaceVector pos = new SpaceVector();
	private ISpaceVector lookPos = new SpaceVector();	
	private float velocity = 0f;
	private float heading = 0f;
	private boolean isHeadingLookingInterlocked = true;

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
		if(isHeadingLookingInterlocked) {
			// TODO compute angle 
		}
	}

	

	@Override
	public float getVelocity() {
		return velocity;
	}

	@Override
	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}

	@Override
	public float getHeading() {
		return heading;
	}

	@Override
	public void setHeading(float heading) {
		this.heading = heading;
	}

	public boolean isHeadingLookingInterlocked() {
		return isHeadingLookingInterlocked;
	}
	
}
