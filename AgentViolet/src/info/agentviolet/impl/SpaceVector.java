package info.agentviolet.impl;

import info.agentviolet.model.ISpaceVector;

public class SpaceVector implements ISpaceVector {

	private float x = 0f;
	private float y = 0f;
	private float z = 0f;

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public float getZ() {
		return z;
	}

	@Override
	public void setX(float x) {
		this.x = x;
	}

	@Override
	public void setY(float y) {
		this.y = y;
	}

	@Override
	public void setZ(float z) {
		this.z = z;
	}

}
