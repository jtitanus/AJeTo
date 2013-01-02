package info.agentviolet.world.basicObjects;

import java.awt.geom.Ellipse2D;

import info.agentviolet.impl.ObjectAttributesBase;
import info.agentviolet.impl.WorldObjectBase;
import info.agentviolet.model.IShape;
import info.agentviolet.model.IWorld;
import info.agentviolet.world.ShapeBase;

public class Rock extends WorldObjectBase {
	
	private RockShape rockShape = new RockShape();
	
	public Rock(IWorld world, float width, float height) {
		attributes = new ObjectAttributesBase();
		this.world = world;
		rockShape.shape.height = height;
		rockShape.shape.width = width;
	}
	
	@Override
	public boolean isStatic() { 
		return false;
	}

	@Override
	public IShape getShape() {
		rockShape.shape.x = getLocation().getPosition().getX();
		rockShape.shape.y = getLocation().getPosition().getY();
		return rockShape;
	}

	private class RockShape extends ShapeBase implements IShape {

		Ellipse2D.Float shape = new Ellipse2D.Float();
		
		@Override
		public Object getGraphicShape() {		
			return shape;
		}

		@Override
		public Class<?> getType() {
			return Ellipse2D.Float.class;
		}		
	}
}
