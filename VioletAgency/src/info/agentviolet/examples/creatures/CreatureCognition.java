package info.agentviolet.examples.creatures;

import info.agentviolet.basicTasks.FeedTask;
import info.agentviolet.impl.basicNeeds.Feed;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.ICognition;
import info.agentviolet.model.INeed;

public class CreatureCognition implements ICognition {

	@Override
	public void think(IAgent agent) {
		if (agent.getTask() == null) {
			INeed mostWanted = agent.getNeeds().getMostDesperateNeed();
			if (mostWanted instanceof Feed
					&& ((Feed) mostWanted).getSatisfactionLevel() < 0.5f) {
				agent.setTask(new FeedTask());
			}
		}
	}

}
