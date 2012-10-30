package info.agentviolet.basicTasks;

import info.agentviolet.impl.TaskBase;
import info.agentviolet.impl.basicActions.FeedAction;
import info.agentviolet.impl.basicActions.GoToLookingPositionAction;
import info.agentviolet.impl.basicActions.Seek;
import info.agentviolet.model.objectAttributes.IConsumable;

public class FeedTask extends TaskBase {

	public FeedTask() {
		actions.add(new Seek(IConsumable.class));
		actions.add(new GoToLookingPositionAction());
		actions.add(new FeedAction());
		currentAction = actions.get(0);
	}
		

}
