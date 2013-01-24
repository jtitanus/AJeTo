package info.agentviolet.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import info.agentviolet.model.IAttributes;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.view.IViewLayer;
import info.agentviolet.view.ViewLayerBase;

public abstract class WorldBase extends TimeSubject implements IWorld {

	protected static final int DEFAULT_LAYER = 0;
	protected IAttributes attributes;
	protected final List<IViewLayer> viewLayers = new ArrayList<IViewLayer>(5);
	protected final List<IWorldObject> worldObjects = new ArrayList<IWorldObject>();

	public WorldBase() {
		attributes = new WorldAttributesBase();
		for (int i = 0; i < DEFAULT_LAYER+1; i++) {
			viewLayers.add(new ViewLayerBase(null));
		}
	}

	@Override
	public void update() {
		for (IViewLayer viewLayer : viewLayers) {
			if (viewLayer != null && !viewLayer.isStatic()) {
				for (IWorldObject worldObject : viewLayer.getWorldObjects()) {
					if (worldObject.isActive()) {
						worldObject.update();
					}
				}
			}
		}
	}

	@Override
	public void addObject(IWorldObject worldObject) {
		viewLayers.get(DEFAULT_LAYER).addObject(worldObject);
		worldObjects.add(worldObject);
	}

	@Override
	public void addObjectToLayer(int layer, IWorldObject worldObject) {
		viewLayers.get(layer).addObject(worldObject);
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
