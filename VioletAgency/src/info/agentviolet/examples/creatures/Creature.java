package info.agentviolet.examples.creatures;

import info.agentviolet.impl.AgentBase;
import info.agentviolet.model.IWorld;

public class Creature extends AgentBase {
	
	private static CreatureCognition creatureCognition = new CreatureCognition();
	
	public Creature(IWorld wordld) {
		this.world = world;
		this.setCognition(creatureCognition);
	}
	
	@Override
	public void update() {
		super.update();
	}	

}
