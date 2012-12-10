package info.agentviolet.world.basicObjects;

import info.agentviolet.impl.ObjectAttributesBase;
import info.agentviolet.impl.WorldObjectBase;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.IWorldObject;

public class Rock extends WorldObjectBase implements IWorldObject {

	
	public Rock(IWorld world) {
		attributes = new ObjectAttributesBase();
		this.world = world;
	}
	
	@Override
	public boolean isStatic() { 
		return false;
	}

}
