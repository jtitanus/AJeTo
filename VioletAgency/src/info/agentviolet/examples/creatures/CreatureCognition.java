package info.agentviolet.examples.creatures;

import info.agentviolet.impl.basicActions.FeedAction;
import info.agentviolet.impl.basicActions.GoToLookingPositionAction;
import info.agentviolet.impl.basicNeeds.Feed;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.ICognition;
import info.agentviolet.model.INeed;

public class CreatureCognition implements ICognition {

	@Override
	public void think(IAgent agent) {
		INeed mostWanted = agent.getNeeds().getMostDesperateNeed();

		if (mostWanted instanceof Feed
				&& ((Feed) mostWanted).getSatisfactionLevel() < 0.5f
				&& (agent.getCurrentAction() == null 
				|| (!(agent.getCurrentAction() instanceof FeedAction
						|| (agent.getCurrentAction() instanceof GoToLookingPositionAction))))) {
			agent.setCurrentAction(new FeedAction());
		}

	}

}
