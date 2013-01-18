package info.agentviolet.hyperspace.model.space;

import java.util.ArrayList;
import java.util.List;

import info.agentviolet.view.VioletColor;

public class SpaceObject {

	public final static int TYPE_SPACE_STATION = 0;
	public final static int TYPE_ASTEROID = 1;
	public final static int TYPE_PLANETOID = 2;
	public final static int TYPE_SOLID = 3;
	public final static int TYPE_EARTH_LIKE = 4;
	public final static int TYPE_GAS_GIANT = 5;
	public final static int TYPE_MASSIVE_GAS_GIANT = 6;
	public final static int TYPE_SUPER_MASSIVE_GAS_GIANT = 7;

	protected final int type;
	protected final VioletColor color;
	protected final List<SpaceObject> orbits = new ArrayList<SpaceObject>();

	public SpaceObject(int type, VioletColor color) {
		this.type = type;
		this.color = color;
	}

	public int getType() {
		return type;
	}

	public VioletColor getColor() {
		return color;
	}

	public List<SpaceObject> getOrbits() {
		return orbits;
	}
}
