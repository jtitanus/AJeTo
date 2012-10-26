package info.agentviolet.model;

public interface ILocation {

	ISpaceVector getPosition();
	
	void setPosition(ISpaceVector newPosition);
	
	ISpaceVector getLookingPosition();
	
	void setLookingPosition(ISpaceVector lookingPosition);	
	
	float getVelocity();
	
	void setVelocity(float velocity);
	
	float getHeading();
	
	void setHeading(float heading);
}
