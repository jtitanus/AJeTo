package info.agentviolet.impl;

import info.agentviolet.model.IAgent;
import info.agentviolet.model.ICognition;
import info.agentviolet.model.INeeds;

public class AgentBase extends WorldObjectBase implements IAgent {

	private INeeds needs = new Needs();
	private ICognition cognition = null;
	
	@Override
	public boolean isStatic() {
		return false;
	}
	
	public ICognition getCognition() {
		return cognition;
	}
	
	public void setCognition(ICognition cognition){
		this.cognition=cognition;
	}

	@Override
	public INeeds getNeeds() {
		return needs;
	}

	@Override
	public void update() {	
		cognition.think(this);
	}
}
