package info.agentviolet.model;

public interface IShape {
	
	Object getGraphicShape();
	
	boolean checkCollision(IShape otherShape);
	
	Class<?> getType();

	
}
