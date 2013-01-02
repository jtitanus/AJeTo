package info.agentviolet.model;


public interface IWorldObject {

	IWorld getWorld();
	
	ILocation getLocation();
	
	IAttributes getAttributes();

	void update();
	
	boolean isStatic();
	
	boolean isActive();
	
	void setActive(boolean isActive);
	
	long getLastUpdateTime();
	
	IShape getShape();
}
