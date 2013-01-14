package info.agentviolet.world.basicObjects;

import java.awt.geom.Rectangle2D;

import info.agentviolet.impl.ObjectAttributesBase;
import info.agentviolet.impl.WorldObjectBase;
import info.agentviolet.model.IShape;
import info.agentviolet.model.IWorld;
import info.agentviolet.world.ShapeBase;

public class FixedBox extends WorldObjectBase{

	private FixedBoxShape fixedBoxShape = new FixedBoxShape();
	
	public FixedBox(IWorld world, float width, float height) {
		attributes = new ObjectAttributesBase();
		this.world = world;

		fixedBoxShape.shape.height = height;
		fixedBoxShape.shape.width = width;		
	}
	
	@Override
	public boolean isStatic() {	
		return true;
	}

	@Override
	public IShape getShape() {
		fixedBoxShape.shape.x = getLocation().getPosition().getX();
		fixedBoxShape.shape.y = getLocation().getPosition().getY();
		return fixedBoxShape;
	}

	private class FixedBoxShape extends ShapeBase implements IShape {

		Rectangle2D.Float shape = new Rectangle2D.Float();
		
		@Override
		public Object getGraphicShape() {			
			return shape;
		}

		@Override
		public Class<?> getType() {
			return Rectangle2D.Float.class;
		}
	}
}
