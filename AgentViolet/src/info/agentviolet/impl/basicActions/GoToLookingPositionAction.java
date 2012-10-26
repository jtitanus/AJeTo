package info.agentviolet.impl.basicActions;

import info.agentviolet.model.IAction;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.ISpaceVector;
import info.agentviolet.utils.VectorUtils;

public class GoToLookingPositionAction implements IAction {

	@Override
	public void letDo(IAgent agent) {
		if(agent.getLocation().getLookingPosition()!=null) {
			if(!VectorUtils.isAtPosition(agent.getLocation().getPosition(), agent.getLocation().getLookingPosition(), 25f)){ // TODO constant tolerance value
				ISpaceVector diffVec = VectorUtils.subtract(agent.getLocation().getLookingPosition(), agent.getLocation().getPosition());
				diffVec = VectorUtils.multiplyScalar(diffVec, 30f/1000f);
				diffVec = VectorUtils.add(agent.getLocation().getPosition(), diffVec);
				agent.getLocation().setPosition(diffVec);
			}
			else {
				agent.setCurrentAction(null);
			}
		}
	}

}
