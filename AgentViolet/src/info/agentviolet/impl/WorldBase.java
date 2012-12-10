package info.agentviolet.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import info.agentviolet.model.IAttributes;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.IWorldObject;

public class WorldBase implements IWorld {

	protected IAttributes attributes;
	
	private List<IWorldObject> worldObjects = new ArrayList<IWorldObject>();
	
	public WorldBase() {
		attributes = new ObjectAttributesBase();
	}
	
	@Override
	public void update() {
		for (IWorldObject worldObject : worldObjects) {
			if(worldObject.isActive()) {
				worldObject.update();
			}
		}
	}

	@Override
	public void addObject(IWorldObject worldObject) {
		worldObjects.add(worldObject);
	}

	@Override
	public Collection<IWorldObject> getWorldObjects() {		
		return worldObjects;
	}

	@Override
	public IAttributes getAttributes() {
		return attributes;
	}


}
