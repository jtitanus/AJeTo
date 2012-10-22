package info.agentviolet.impl.basicNeeds;

import info.agentviolet.model.INeed;

public abstract class NeedBase implements INeed {

	protected float satisfaction = 0f;

	@Override
	public float getSatisfactionLevel() {
		return satisfaction;
	}

	@Override
	public void setSatisfactionLevel(float satisfactionLevel) {
		satisfaction = satisfactionLevel;
	}

}
