package info.agentviolet.model;

import java.util.Collection;

public interface INeeds {

	Collection<INeed> getNeeds();
	
	INeed getMostDesperateNeed();
	
	float getOverallSatisfactionLevel();
}
