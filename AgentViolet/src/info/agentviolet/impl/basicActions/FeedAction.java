package info.agentviolet.impl.basicActions;

import info.agentviolet.impl.ActionResultBase;
import info.agentviolet.impl.basicNeeds.Feed;
import info.agentviolet.model.IAction;
import info.agentviolet.model.IActionResult;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.INeed;
import info.agentviolet.model.objectAttributes.IConsumable;
import info.agentviolet.utils.VectorUtils;

public class FeedAction implements IAction {

	@Override
	public IActionResult perform(IAgent agent) {
		IActionResult res = ActionResultBase.UNFINISHED_FAILURE;
		
		// look for food in vicinity
		IConsumable food = null;
		food = (IConsumable) VectorUtils.getNearestWorldObject(agent.getWorld().getWorldObjects(), IConsumable.class, agent.getLocation().getPosition());		
		if (food != null
				// & is in vicinity
				&& VectorUtils.isAtPosition(agent.getLocation().getPosition(), food.getLocation().getPosition(), 25f)) { // TODO constant vicinity value
			food.consume(agent);
			res=ActionResultBase.FINISHED_SUCCESS;
			for(INeed need : agent.getNeeds().getNeeds()) {
				if(need instanceof Feed) {
					need.increaseSatisfactionLevel(food.getSatisfactionGain());
				}
			}
		}		
		return res;
	}
}
