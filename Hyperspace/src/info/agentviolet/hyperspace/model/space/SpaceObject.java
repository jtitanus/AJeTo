package info.agentviolet.hyperspace.model.space;

import java.util.ArrayList;
import java.util.List;

import info.agentviolet.view.VioletColor;

public class SpaceObject {

	public final static int TYPE_SPACE_STATION = 1;
	public final static int TYPE_ASTEROID = 2;
	public final static int TYPE_PLANETOID = 4;
	public final static int TYPE_MOON_LIKE = 8;
	public final static int TYPE_SOLID = 16;
	public final static int TYPE_EARTH_LIKE = 32;
	public final static int TYPE_GAS_GIANT = 64;
	public final static int TYPE_MASSIVE_GAS_GIANT = 128;
	public final static int TYPE_SUPER_MASSIVE_GAS_GIANT = 256;
	public final static int TYPE_ASTEROID_BELT = 1024;
	
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
