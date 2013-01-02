package info.agentviolet.world;

import info.agentviolet.model.IShape;
import info.agentviolet.world.physics.DefaultCollisionDetector;

public abstract class ShapeBase implements IShape {

	private static ICollisionDetector collisionDetector = new DefaultCollisionDetector();	
	
	@Override
	public boolean checkCollision(IShape otherShape) {
		return collisionDetector.detect(this, otherShape);
	}

}
