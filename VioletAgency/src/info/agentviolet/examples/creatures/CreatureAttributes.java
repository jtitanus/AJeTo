package info.agentviolet.examples.creatures;

import info.agentviolet.impl.ObjectAttributesBase;

public class CreatureAttributes extends ObjectAttributesBase {
	
	public CreatureAttributes() {
		super();
		// set default values
		setAttribute(MAX_HITPOINTS, 100f);
		setAttribute(HITPOINTS, 100f);
		setAttribute(MAX_VELOCITY, 1f);
		setAttribute(THINKING_TIME, 2000L);
	}
}
