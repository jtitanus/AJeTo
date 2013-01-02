package info.agentviolet.world;

import info.agentviolet.model.IShape;

public interface ICollisionDetector {

	boolean detect(IShape shape1, IShape shape2);
	
}
