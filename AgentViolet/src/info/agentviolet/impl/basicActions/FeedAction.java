package info.agentviolet.impl.basicActions;

import info.agentviolet.impl.ActionResultBase;
import info.agentviolet.model.IAction;
import info.agentviolet.model.IActionResult;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.objectAttributes.IConsumable;
import info.agentviolet.utils.VectorUtils;

public class FeedAction implements IAction {

	@Override
	public IActionResult letDo(IAgent agent) {
		IActionResult res = ActionResultBase.UNFINISHED; 
		// look for food in vicinity
		IConsumable food = null;
		food =(IConsumable) VectorUtils.getNearestWorldObject(agent.getWorld().getWorldObjects(), IConsumable.class, agent.getLocation().getPosition());
		
		if (food != null
				// & is in vicinity
				&& VectorUtils.isAtPosition(agent.getLocation().getPosition(), food.getLocation().getPosition(), 25f)) { // TODO constant vicinity value
			food.consume(agent);
			res=ActionResultBase.FINISHED;
		}		
		return res;
	}
}
