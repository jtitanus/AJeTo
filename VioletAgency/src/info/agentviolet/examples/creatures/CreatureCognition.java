package info.agentviolet.examples.creatures;

import info.agentviolet.impl.basicNeeds.Feed;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.ICognition;
import info.agentviolet.model.INeed;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.model.objectAttributes.IConsumable;

public class CreatureCognition implements ICognition {

	@Override
	public void think(IAgent agent) {
		INeed mostWanted = agent.getNeeds().getMostDesperateNeed();
		
		if(mostWanted instanceof Feed) {
			// look for food
			IConsumable food = null;
			for (IWorldObject wo : agent.getWorld().getWorldObjects()) {
				if(wo instanceof IConsumable) {
					food = (IConsumable)wo;
					break;
				}
			} 
			if(food!=null) {
				agent.getLocation().setLookingPosition(food.getLocation().getPosition());
			}
		}
		
	}



}
