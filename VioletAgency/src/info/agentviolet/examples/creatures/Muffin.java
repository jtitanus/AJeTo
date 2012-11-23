package info.agentviolet.examples.creatures;

import info.agentviolet.impl.WorldObjectBase;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.objectAttributes.IConsumable;

public class Muffin extends WorldObjectBase implements IConsumable {

	public Muffin(IWorld world){
		this.world = world;
	}
	
	@Override
	public String getEatMessage() {
		return "Yum!";
	}

	@Override
	public boolean isStatic() {		
		return true;
	}

	@Override
	public void consume(IAgent subject) {
		this.setActive(false);
	}

	@Override
	public float getSatisfactionGain() {		
		return 0.25f;
	}

}
