package info.agentviolet.model;

public interface ILocation {

	ISpaceVector getPosition();
	
	ISpaceVector getLookingPosition();
	
	void setLookingPosition(ISpaceVector lookingPosition);
}
