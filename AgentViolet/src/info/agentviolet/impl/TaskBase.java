package info.agentviolet.impl;

import java.util.ArrayList;
import java.util.Collection;

import info.agentviolet.basicTasks.IdleTask;
import info.agentviolet.model.IAction;
import info.agentviolet.model.IActionResult;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.ITask;

public abstract class TaskBase implements ITask {

	protected IAction currentAction = null;
	protected ArrayList<IAction> actions = new ArrayList<IAction>();
	protected int actionIndex = 0;
	protected long startTime = System.currentTimeMillis();
	
	
	@Override
	public IAction getCurrentAction() {
		return currentAction;
	}

	@Override
	public Collection<IAction> getActions() {
		return actions;
	}

	@Override
	public void start() {
		currentAction = actions.get(0);
		startTime = System.currentTimeMillis();;
	}

	@Override
	public void perform(IAgent agent) {
		if (currentAction != null) {
			if (currentAction.equals(actions.get(0)) // first action doesn't need consistency check
					|| checkConsistency(agent)) {
				IActionResult result = currentAction.perform(agent);
				if (result.isFinished()) {
					if (result.isSuccess()) {
						if (actionIndex < actions.size() - 1) {
							actionIndex++;
							currentAction = actions.get(actionIndex);
						} else {
							// finished
							agent.setTask(null);
						}
					} else {
						// finished, but not successful -> break task
						agent.setTask(new IdleTask());
						currentAction = null;
					}
				}
			}
			else {
				// cannot accomplish task -> break
				agent.setTask(new IdleTask());
			}
		}
	}

	/*** Can be called between actions to check if the purpose of the task still can be achieved; the sequence of actions is still consistent.  */ 
	protected abstract boolean checkConsistency(IAgent agent);

	@Override
	public long getRunningTime() {
		return System.currentTimeMillis() - startTime;
	} 
}
