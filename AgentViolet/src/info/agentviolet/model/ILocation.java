package info.agentviolet.model;

public interface ILocation {

	ISpaceVector getPosition();
	
	void setPosition(ISpaceVector newPosition);
	
	IWorldObject getLookingTarget();
	
	void setLookingTarget(IWorldObject worldObject);
	
	ISpaceVector getLookingPosition();
	
	void setLookingPosition(ISpaceVector lookingPosition);	
	
	ISpaceVector getVelocity();
	
	void setVelocity(ISpaceVector velocityVector);
	
	float getHeading();
	
	void setHeading(float heading);

	void update();
}
