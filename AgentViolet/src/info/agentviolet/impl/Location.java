package info.agentviolet.impl;

import info.agentviolet.model.ILocation;
import info.agentviolet.model.ISpaceVector;
import info.agentviolet.model.IWorldObject;

public final class Location implements ILocation {

	private IWorldObject lookingTarget = null;
	private ISpaceVector pos = new SpaceVector();
	private ISpaceVector lookPos = new SpaceVector();
	private float velocity = 0f;
	private float heading = 0f;
	private boolean isHeadingLookingInterlocked = true;

	@Override
	public ISpaceVector getPosition() {
		return pos;
	}

	@Override
	public void setPosition(ISpaceVector newPosition) {
		pos = newPosition;
	}

	@Override
	public ISpaceVector getLookingPosition() {
		if (lookingTarget == null) {
			return lookPos;
		} else {
			return lookingTarget.getLocation().getPosition();
		}
	}

	@Override
	public void setLookingPosition(ISpaceVector lookingPosition) {		
		lookPos = lookingPosition;
		if (isHeadingLookingInterlocked) {
			// TODO compute angle and set heading
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

	@Override
	public IWorldObject getLookingTarget() {		
		return lookingTarget;
	}

	@Override
	public void setLookingTarget(IWorldObject targetWorldObject) {
		lookingTarget = targetWorldObject;
	}

}
