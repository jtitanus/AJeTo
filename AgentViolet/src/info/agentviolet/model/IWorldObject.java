package info.agentviolet.model;

import java.util.Date;

public interface IWorldObject {

	IWorld getWorld();
	
	ILocation getLocation();
	
	IAttributes getAttributes();

	void update();
	
	boolean isStatic();
	
	boolean isActive();
	
	void setActive(boolean isActive);
	
	Date getLastUpdateTime();
}
