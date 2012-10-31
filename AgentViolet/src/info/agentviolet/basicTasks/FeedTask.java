package info.agentviolet.basicTasks;

import info.agentviolet.impl.TaskBase;
import info.agentviolet.impl.basicActions.FeedAction;
import info.agentviolet.impl.basicActions.GoToLookingPositionAction;
import info.agentviolet.impl.basicActions.Seek;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.objectAttributes.IConsumable;

public class FeedTask extends TaskBase {

	private Seek seekAction;
	private GoToLookingPositionAction gotoAction;
	private FeedAction feedAction;

	public FeedTask() {
		seekAction = new Seek(IConsumable.class);
		gotoAction = new GoToLookingPositionAction();
		feedAction = new FeedAction();
		actions.add(seekAction);
		actions.add(gotoAction);
		actions.add(feedAction);
		currentAction = seekAction;
	}

	@Override
	protected boolean checkConsistency(IAgent agent) {
		boolean retVal = false;
		if (agent.getLocation().getLookingTarget() != null
				&& agent.getLocation().getLookingTarget().isActive()) {
			retVal = true;
		}
		return retVal;
	}

//	@Override
//	public void perform(IAgent agent) {
//		IActionResult result = seekAction.perform(agent);
//		if(result.isFinished() && result.isSuccess()) {
//			VectorUtils.isAtPosition(fromPos, toPos, tolerance)
//		}
//	}
}
