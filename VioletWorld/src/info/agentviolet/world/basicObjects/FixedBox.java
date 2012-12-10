package info.agentviolet.world.basicObjects;

import java.awt.geom.Rectangle2D;

import info.agentviolet.impl.ObjectAttributesBase;
import info.agentviolet.impl.WorldObjectBase;
import info.agentviolet.model.IWorld;

public class FixedBox extends WorldObjectBase{

	public FixedBox(IWorld world) {
		attributes = new ObjectAttributesBase();
		this.world = world;
		Rectangle2D.Float shape = new Rectangle2D.Float();
		shape.height = 25f;
		shape.width = 250f;
		attributes.setAttribute(ObjectAttributesBase.SHAPE, shape);
	}
	
	@Override
	public boolean isStatic() {	
		return true;
	}

}
