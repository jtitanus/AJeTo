package info.agentviolet.hyperspace.model.space;

import java.util.ArrayList;
import java.util.List;

public class StarSystem {

	private final List<SpaceObject> orbits = new ArrayList<SpaceObject>();
	private final List<SpaceObject> allObjects = new ArrayList<SpaceObject>();
	//private final List<SpaceObject> spaceStations = new ArrayList<SpaceObject>();
	private final SpaceObject star;
	private final SpaceStation spaceStation;

	public StarSystem(SpaceObject star) {
		this.star = star;
		SpaceStation spaceStation=null;
		for(SpaceObject planet : star.getOrbits()) {
			orbits.add(planet);
			allObjects.add(planet);
			if(planet instanceof SpaceStation){
				spaceStation = (SpaceStation)planet;
			}
			for(SpaceObject moon : planet.getOrbits()) {
				allObjects.add(moon);
				if(moon instanceof SpaceStation){
					spaceStation = (SpaceStation)moon;
				}
				for(SpaceObject spacestation : moon.getOrbits()) {
					allObjects.add(spacestation);
					spaceStation = (SpaceStation)spacestation;
				}
			}
		}
		this.spaceStation=spaceStation;
	}

	public List<SpaceObject> getOrbits() {
		return orbits;
	}

	public SpaceObject getStar() {
		return star;
	}
	
	public SpaceStation getSpaceStation() {
		return spaceStation;
	}
	
	/**
	 * Returns all sub space objects.
	 * @return
	 */
	public static List<SpaceObject> getAllSpaceObjectsOf(SpaceObject spaceObjects) {
		List<SpaceObject> objects = new ArrayList<SpaceObject>();
		for(SpaceObject planet : spaceObjects.getOrbits()) {
			objects.add(planet);
			for(SpaceObject moon : planet.getOrbits()) {
				objects.add(moon);
				for(SpaceObject spacestation : moon.getOrbits()) {
					objects.add(spacestation);
				}
			}
		}
		return objects;
	}
}
