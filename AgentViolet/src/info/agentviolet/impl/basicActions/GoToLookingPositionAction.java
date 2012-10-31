package info.agentviolet.impl.basicActions;

import info.agentviolet.impl.ActionResultBase;
import info.agentviolet.model.IAction;
import info.agentviolet.model.IActionResult;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.ISpaceVector;
import info.agentviolet.utils.VectorUtils;

public class GoToLookingPositionAction implements IAction {

	@Override
	public IActionResult perform(IAgent agent) {
		IActionResult res = ActionResultBase.UNFINISHED_FAILURE; 
		if(agent.getLocation().getLookingPosition()!=null) {
			if(!VectorUtils.isAtPosition(agent.getLocation().getPosition(), agent.getLocation().getLookingPosition(), 25f)){ // TODO constant tolerance value
				ISpaceVector diffVec = VectorUtils.subtract(agent.getLocation().getLookingPosition(), agent.getLocation().getPosition());
				diffVec = VectorUtils.multiplyScalar(diffVec, 10f/1000f); //TODO static velocity 
				diffVec = VectorUtils.add(agent.getLocation().getPosition(), diffVec);
				agent.getLocation().setPosition(diffVec);
			}
			else {
				res = ActionResultBase.FINISHED_SUCCESS;
			}
		}
		return res;
	}

}
