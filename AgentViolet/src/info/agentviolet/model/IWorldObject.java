package info.agentviolet.model;

public interface IWorldObject {

	ILocation getLocation();

	void update();
	
	boolean isStatic();
	
	boolean isActive();
	
	void setActive(boolean isActive);
}
