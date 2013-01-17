package info.agentviolet.hyperspace.model.space;

import java.util.ArrayList;
import java.util.List;

import info.agentviolet.view.VioletColor;

public class SpaceObject {

	public enum Type {
		GAS_GIANT, SOLID, MASSIVE_GAS_GIANT, SUPER_MASSIVE_GAS_GIANT, // (star)
		EARTH_LIKE,
		PLANETOID,
		ASTEROID,
	}

	protected SpaceObject.Type type;	
	protected VioletColor color;
	protected final List<SpaceObject> orbits = new ArrayList<SpaceObject>();
	
	public SpaceObject(SpaceObject.Type type, VioletColor color) {
		this.type = type;
		this.color = color;
	}

	public SpaceObject.Type getType() {
		return type;
	}

	public VioletColor getColor() {
		return color;
	}
	
	public List<SpaceObject> getOrbits() {
		return orbits;
	}
}
