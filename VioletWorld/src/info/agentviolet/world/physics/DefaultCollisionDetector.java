package info.agentviolet.world.physics;

import java.awt.Shape;

import info.agentviolet.model.IShape;
import info.agentviolet.world.ICollisionDetector;

public class DefaultCollisionDetector implements ICollisionDetector {

	@Override
	public boolean detect(IShape shape1, IShape shape2) {		
		return ((Shape)shape1.getGraphicShape()).intersects(((Shape)shape2.getGraphicShape()).getBounds2D());
	}

}
