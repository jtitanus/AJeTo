package info.agentviolet.world.basicObjects;

import java.awt.geom.Ellipse2D;

import info.agentviolet.impl.ObjectAttributesBase;
import info.agentviolet.impl.WorldObjectBase;
import info.agentviolet.model.IWorld;

public class Rock extends WorldObjectBase {
	
	public Rock(IWorld world) {
		attributes = new ObjectAttributesBase();
		this.world = world;
		Ellipse2D.Float shape = new Ellipse2D.Float();		
		shape.height = 25f;
		shape.width = 25f;
		attributes.setAttribute(ObjectAttributesBase.SHAPE, shape);
	}
	
	@Override
	public boolean isStatic() { 
		return false;
	}

}
