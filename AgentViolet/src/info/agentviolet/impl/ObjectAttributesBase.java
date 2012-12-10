package info.agentviolet.impl;

import info.agentviolet.model.IAttributes;
import info.agentviolet.utils.AttributesUtils;

/***
 * Defines an extensible storage of world object attributes.
 */
public class ObjectAttributesBase implements IAttributes {

	// Attributes definition
	public static final int MAX_HITPOINTS = 0; // value float
	public static final int HITPOINTS = 1; // value float
	public static final int MAX_VELOCITY = 2; // value float
	public static final int THINKING_TIME = 3; // value long (milliseconds)
	public static final int MASS = 4; // value float [kg]
	public static final int SHAPE = 5; // value java.awt.Shape

	protected Object[] attributes;

	public ObjectAttributesBase() {
		attributes = AttributesUtils.initAttributes(this);
		// set default values
		setAttribute(MAX_HITPOINTS, -1f);
		setAttribute(HITPOINTS, -1f);
		setAttribute(MAX_VELOCITY, 0f);
		setAttribute(MASS, 1f);
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
