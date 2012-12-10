package info.agentviolet.world;

import info.agentviolet.model.IAttributes;
import info.agentviolet.utils.AttributesUtils;

public class WorldAttributesBase implements IAttributes {

	// Attributes definition
	public static final int IS_2D = 0; // value boolean
	public static final int DELTA_TIME = 1; // value int in milliseconds - the time step of a world update
	public static final int GRAVITY = 2; // value float
	
	protected Object[] attributes;

	public WorldAttributesBase() {
		attributes = AttributesUtils.initAttributes(this);

		// set default values
		setAttribute(IS_2D, true);
		setAttribute(DELTA_TIME, 30);
		setAttribute(GRAVITY, 9.81f);
	}

	@Override
	public Object getAttribute(int attributeName) {
		return attributes[attributeName];
	}

	@Override
	public void setAttribute(int attribute, Object value) {
		attributes[attribute] = value;
	}

}
