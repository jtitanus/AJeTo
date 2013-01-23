package info.agentviolet.hyperspace.model.space;

import java.util.ArrayList;
import java.util.List;

public class Galaxy {

	private final List<StarSystem> starsystems = new ArrayList<StarSystem>();
	
	public List<StarSystem> getStarSystems() {
		return starsystems;
	}
}
