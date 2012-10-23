package info.agentviolet.impl;

import info.agentviolet.model.IAction;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.ICognition;
import info.agentviolet.model.INeeds;

public class AgentBase extends WorldObjectBase implements IAgent {

	protected INeeds needs = null;
	protected ICognition cognition = null;
	protected IAction currentAction = null;

	@Override
	public boolean isStatic() {
		return false;
	}

	public ICognition getCognition() {
		return cognition;
	}

	public void setCognition(ICognition cognition) {
		this.cognition = cognition;
	}

	@Override
	public INeeds getNeeds() {
		return needs;
	}

	@Override
	public void update() {
		if (cognition != null) {
			cognition.think(this);
		}
		if (currentAction != null) {
			currentAction.letDo(this);
		}
	}

	@Override
	public IAction getCurrentAction() {
		return currentAction;
	}

	@Override
	public void setCurrentAction(IAction action) {
		currentAction = action;
	}
}
