package info.agentviolet.impl;

import java.lang.reflect.Field;

import info.agentviolet.model.IObjectAttributes;

/***
 * Defines an extensible storage of world object attributes.
 */
public class ObjectAttributesBase implements IObjectAttributes {

	// Attributes definition
	public static final int MAX_HITPOINTS = 0;	// value float
	public static final int HITPOINTS = 1;		// value float
	public static final int MAX_VELOCITY = 2;	// value float
	
	protected Object[] attributes;
	
	public ObjectAttributesBase() {
		Field[] fields =  this.getClass().getFields();
		int len = 0;
		for(int i=0; i<fields.length; i++) {			
			try {
				int j = fields[i].getInt(fields[i]);
				len = Math.max(len, j);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		attributes = new Object[++len];
		
		// check collisions, can be removed in production release
		for(int i=0; i<fields.length; i++) {			
			try {
				int j = fields[i].getInt(fields[i]);
				if(attributes[j] ==null) {
					attributes[j] = Integer.MIN_VALUE;
				}
				else {
					// collision
					System.out.println("World object attributes contain a coliding definition");
					System.err.println("World object attributes contain a coliding definition");
					System.exit(-1);
				}
				attributes[j] = null; // reset to null
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	
		// set default values
		setAttribute(MAX_HITPOINTS, -1f);
		setAttribute(HITPOINTS, -1f);
		setAttribute(MAX_VELOCITY, 0f);
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
