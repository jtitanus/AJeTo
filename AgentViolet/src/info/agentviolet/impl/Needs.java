package info.agentviolet.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import info.agentviolet.model.INeed;
import info.agentviolet.model.INeeds;

public class Needs implements INeeds {

	List<INeed> needs = new ArrayList<INeed>();

	@Override
	public Collection<INeed> getNeeds() {
		return needs;
	}

	@Override
	public INeed getMostDesperateNeed() {
		INeed mostDesperate = null;
		if (needs.size() > 0) {
			mostDesperate = needs.get(0);
			for (INeed need : needs) {
				if(need.getPriority()<= mostDesperate.getPriority()
						&& need.getSatisfactionLevel() <= mostDesperate.getPriority()) {
					mostDesperate = need;
				}					
			}
		}
		return mostDesperate;
	}

}
