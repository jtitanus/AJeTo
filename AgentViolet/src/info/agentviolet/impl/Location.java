package info.agentviolet.impl;

import info.agentviolet.model.ILocation;
import info.agentviolet.model.ISpaceVector;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.utils.VectorUtils;

public final class Location implements ILocation {

	private IWorldObject lookingTarget = null;
	private ISpaceVector pos = new SpaceVector();
	private ISpaceVector lookPos = null;
	private ISpaceVector velocity = null;
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

	@Override
	public void setVelocity(ISpaceVector velocityVector) {
		velocity = velocityVector;
	}

	@Override
	public ISpaceVector getVelocity() {		
		return velocity;
	}

	@Override
	public void update() {
		if(velocity!=null) {
			pos = VectorUtils.add(pos, velocity);
		}
	}

}
