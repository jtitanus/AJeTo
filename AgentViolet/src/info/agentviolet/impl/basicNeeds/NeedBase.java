package info.agentviolet.impl.basicNeeds;

import info.agentviolet.model.INeed;

public abstract class NeedBase implements INeed {

	protected float satisfaction = 0f;

	@Override
	public float getSatisfactionLevel() {
		return satisfaction;
	}	

	@Override
	public void increaseSatisfactionLevel(float satisfactionLevelPlus) {		
		satisfaction += satisfactionLevelPlus;
		if(satisfaction > 1f) {
			satisfaction = 1f;
		}
	}

	@Override
	public void decreaseSatisfactionLevel(float satisfactionLevelMinus) {
		satisfaction -= satisfactionLevelMinus;
		if(satisfaction < 0f) {
			satisfaction = 0f;
		}
		
	}

	
}
