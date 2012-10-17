package info.agentviolet.impl;

import java.util.ArrayList;
import java.util.List;

import info.agentviolet.model.IPresentationContext;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.IWorldObject;

public class World implements IWorld {

	private List<IWorldObject> worldObjects = new ArrayList<IWorldObject>();
	
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
	public void draw(IPresentationContext context) {
		context.draw(this);
	}


}
