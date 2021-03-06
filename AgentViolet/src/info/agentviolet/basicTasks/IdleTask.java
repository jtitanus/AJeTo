package info.agentviolet.basicTasks;

import info.agentviolet.impl.ObjectAttributesBase;
import info.agentviolet.impl.TaskBase;
import info.agentviolet.model.IAgent;

public class IdleTask extends TaskBase {
		
	@Override
	protected boolean checkConsistency(IAgent agent) {		
		return false;
	}
	
	@Override
	public void perform(IAgent agent) {
		if (agent.getLocation().getVelocity() != null) {
			agent.getLocation().setVelocity(null);
		}
		if((System.nanoTime()- agent.getLastUpdateTime())
				> (long)agent.getAttributes().getAttribute(ObjectAttributesBase.THINKING_TIME)){
			agent.setTask(null);
		}
	}

}
