package info.agentviolet.model;

public interface IWorldObject {

	IWorld getWorld();
	
	ILocation getLocation();
	
	IObjectAttributes getAttributes();

	void update();
	
	boolean isStatic();
	
	boolean isActive();
	
	void setActive(boolean isActive);
}
