package info.agentviolet.model;

import java.util.Date;

public interface ILocation {

	ISpaceVector getPosition();
	
	ISpaceVector getLookingPosition();
	
	void setLookingPosition(ISpaceVector lookingPosition);
	
	Date getLastUpdateTime();
	
	float getVelocity();
	
	void setVelocity(float velocity);
}
