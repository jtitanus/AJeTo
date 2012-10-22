package info.agentviolet.examples.creatures;

import info.agentviolet.impl.NeedsBase;
import info.agentviolet.impl.basicNeeds.Feed;

public class CreatureNeeds extends NeedsBase {

	public CreatureNeeds() {
		super();
		needs.add(new Feed());
	}
}
