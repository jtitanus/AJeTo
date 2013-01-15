package info.agentviolet.model;

import info.agentviolet.view.IViewLayer;

import java.util.Collection;
import java.util.List;

public interface IWorld {

	Collection<IWorldObject> getWorldObjects();

	/***
	 * Adds the specified world object to the default layer.
	 * 
	 * @param worldObject
	 */
	void addObject(IWorldObject worldObject);
	
	/***
	 * Adds the specified world object to the specified layer.
	 * 
	 * @param worldObject
	 */
	void addObjectToLayer(int layer, IWorldObject worldObject);

	void update();
	
	IAttributes getAttributes();
	
	List<IViewLayer> getViewLayers();

}
