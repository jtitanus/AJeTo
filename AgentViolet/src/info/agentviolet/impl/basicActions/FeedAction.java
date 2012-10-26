package info.agentviolet.impl.basicActions;

import info.agentviolet.model.IAction;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.model.objectAttributes.IConsumable;

public class FeedAction implements IAction {

	@Override
	public void letDo(IAgent agent) {
		// look for food
		IConsumable food = null;
		for (IWorldObject wo : agent.getWorld().getWorldObjects()) {
			if (wo instanceof IConsumable) {
				food = (IConsumable) wo;
				break;
			}
		}
		if (food != null) {
			agent.getLocation().setLookingPosition(
					food.getLocation().getPosition());
			agent.setCurrentAction(new GoToLookingPositionAction());
		}
		else {
			agent.setCurrentAction(null);
		}
		

	}

}
