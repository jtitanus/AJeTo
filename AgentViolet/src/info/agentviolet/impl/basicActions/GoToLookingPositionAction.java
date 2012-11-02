package info.agentviolet.impl.basicActions;

import info.agentviolet.impl.ActionResultBase;
import info.agentviolet.impl.ObjectAttributesBase;
import info.agentviolet.impl.SpaceVector;
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
				// set velocity vector
				ISpaceVector diffVec = VectorUtils.subtract(agent.getLocation().getLookingPosition(), agent.getLocation().getPosition());
				// diffVec = VectorUtils.multiplyScalar(diffVec, (float) agent.getAttributes().getAttribute(ObjectAttributesBase.MAX_VELOCITY));
				float angle = VectorUtils.getAngleXY(diffVec);
				diffVec = VectorUtils.getVectorByAngle(angle, (float) agent.getAttributes().getAttribute(ObjectAttributesBase.MAX_VELOCITY));
				agent.getLocation().setVelocity(diffVec);
			}
			else {
				agent.getLocation().setVelocity(new SpaceVector(0f, 0f, 0f));
				res = ActionResultBase.FINISHED_SUCCESS;
			}
		}
		return res;
	}

}
