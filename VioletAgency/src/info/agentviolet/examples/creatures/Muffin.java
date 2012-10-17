package info.agentviolet.examples.creatures;

import info.agentviolet.impl.WorldObjectBase;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.model.objectAttributes.IConsumable;

public class Muffin extends WorldObjectBase implements IConsumable {

	@Override
	public void consume(IWorldObject subject) {
		

	}

	@Override
	public String getEatMessage() {
		return "Yum!";
	}

	@Override
	public boolean isStatic() {		
		return true;
	}

}
