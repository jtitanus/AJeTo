package info.agentviolet.model;

public interface ISpaceVector extends Comparable<ISpaceVector> {

	public float getX();
	public float getY();
	public float getZ();
	
	public void setX(float x);
	public void setY(float y);
	public void setZ(float z);
}
