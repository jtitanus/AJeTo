package info.agentviolet.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import info.agentviolet.model.IAttributes;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.view.IViewLayer;

public class WorldBase implements IWorld {

	protected IAttributes attributes;
	protected final List<IWorldObject> worldObjects = new ArrayList<IWorldObject>();
	protected final List<IViewLayer> viewLayers = new ArrayList<IViewLayer>();

	public WorldBase() {
		attributes = new WorldAttributesBase();
	}

	@Override
	public void update() {
		for (IWorldObject worldObject : worldObjects) {
			if (worldObject.isActive()) {
				worldObject.update();
			}
		}

		for (IViewLayer viewLayer : viewLayers) {
			for (IWorldObject worldObject : viewLayer.getWorldObjects()) {
				if (worldObject.isActive()) {
					worldObject.update();
				}
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

	@Override
	public List<IViewLayer> getViewLayers() {
		return viewLayers;
	}

}
