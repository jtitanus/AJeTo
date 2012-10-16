package info.agentviolet.model;

public interface IWorld {
	
	void addObject(IWorldObject worldObject);
	
	void update();
	
	void draw(IPresentationContext context);
}
