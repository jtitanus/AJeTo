package info.agentviolet.impl;

import java.util.ArrayList;
import java.util.Collection;
import info.agentviolet.model.IAction;
import info.agentviolet.model.IActionResult;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.ITask;

public abstract class TaskBase implements ITask {

	protected IAction currentAction = null;
	protected ArrayList<IAction> actions = new ArrayList<IAction>();
	protected int actionIndex = 0;

	@Override
	public IAction getCurrentAction() {
		return currentAction;
	}

	// public void setCurrentAction(IAction action) {
	// currentAction = action;
	// }

	@Override
	public Collection<IAction> getActions() {
		return actions;
	}

	@Override
	public void start() {
		currentAction = actions.get(0);
	}

	@Override
	public void perform(IAgent agent) {
		if (currentAction != null) {
			IActionResult result = currentAction.letDo(agent);
			if (result.isFinished()) {
				if (actionIndex < actions.size() - 1) {
					actionIndex++;
					currentAction = actions.get(actionIndex);
				}
				else {
					// finished
					agent.setTask(null);
				}
			}
		}
	}

}
