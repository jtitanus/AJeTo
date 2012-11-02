package info.agentviolet.impl;

import java.util.Date;

import info.agentviolet.model.IAgent;
import info.agentviolet.model.ICognition;
import info.agentviolet.model.INeeds;
import info.agentviolet.model.ITask;

public class AgentBase extends WorldObjectBase implements IAgent {

	protected INeeds needs = null;
	protected ICognition cognition = null;
	protected Date lastUpdateTime = new Date();
	protected ITask task = null;

	@Override
	public boolean isStatic() {
		return false;
	}

	@Override
	public Date getLastUpdateTime() {
		return lastUpdateTime;
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
		if (task != null) {
			task.perform(this);
		}
		location.update();
		lastUpdateTime = new Date(System.nanoTime());
	}

	@Override
	public ITask getTask() {
		return task;
	}

	@Override
	public void setTask(ITask task) {
		this.task = task;
	}

}
