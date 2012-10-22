package info.agentviolet.impl;

import info.agentviolet.model.ILocation;
import info.agentviolet.model.ISpaceVector;

public class Location implements ILocation {

	private ISpaceVector pos = new SpaceVector();
	private ISpaceVector lookPos = new SpaceVector();

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

}
