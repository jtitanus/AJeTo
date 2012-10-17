package info.agentviolet.impl;

import info.agentviolet.model.ILocation;
import info.agentviolet.model.ISpaceVector;

public class Location implements ILocation {

	private ISpaceVector pos = new SpaceVector();
	
	@Override
	public ISpaceVector getPosition() {		
		return pos;
	}

}
