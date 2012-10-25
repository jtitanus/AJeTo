package info.agentviolet.model;

public interface ILocation {

	ISpaceVector getPosition();
	
	ISpaceVector getLookingPosition();
	
	void setLookingPosition(ISpaceVector lookingPosition);	
	
	float getVelocity();
	
	void setVelocity(float velocity);
	
	float getHeading();
	
	void setHeading(float heading);
}
