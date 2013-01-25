package info.agentviolet.hyperspace.model.space;

import info.agentviolet.view.ColorPalette;

public class MilkyWay extends Galaxy {

	public MilkyWay() {
		StarSystem sol = new StarSystem(new SpaceObject(SpaceObject.TYPE_SUPER_MASSIVE_GAS_GIANT, ColorPalette.getInstance().getColor(ColorPalette.YELLOW)));
		// Mercury
		SpaceObject planet = new SpaceObject(SpaceObject.TYPE_PLANETOID, ColorPalette.getInstance().getColor(ColorPalette.GRAY));
		sol.getOrbits().add(planet);
		// Venus
		planet = new SpaceObject(SpaceObject.TYPE_EARTH_LIKE, ColorPalette.getInstance().getColor(ColorPalette.YELLOW));
		sol.getOrbits().add(planet);
		// Earth
		planet = new SpaceObject(SpaceObject.TYPE_EARTH_LIKE, ColorPalette.getInstance().getColor(ColorPalette.BLUE));
		// SpaceStation
		SpaceStation spaceStation = new SpaceStation();
		planet.getOrbits().add(spaceStation);
		
		sol.getOrbits().add(planet);
		// Moon
		SpaceObject moon = new SpaceObject(SpaceObject.TYPE_PLANETOID, ColorPalette.getInstance().getColor(ColorPalette.GRAY));
		planet.getOrbits().add(moon);
		// Mars
		planet = new SpaceObject(SpaceObject.TYPE_EARTH_LIKE, ColorPalette.getInstance().getColor(ColorPalette.RED));
		sol.getOrbits().add(planet);
		// Phobos
		moon = new SpaceObject(SpaceObject.TYPE_ASTEROID, ColorPalette.getInstance().getColor(ColorPalette.GRAY));
		planet.getOrbits().add(moon);
		// Deimos
		moon = new SpaceObject(SpaceObject.TYPE_ASTEROID, ColorPalette.getInstance().getColor(ColorPalette.GRAY));
		planet.getOrbits().add(moon);
		// Ceres
		planet = new SpaceObject(SpaceObject.TYPE_PLANETOID, ColorPalette.getInstance().getColor(ColorPalette.GRAY));
		sol.getOrbits().add(planet);
		// Asteroid belt
		planet = new SpaceObject(SpaceObject.TYPE_ASTEROID_BELT, ColorPalette.getInstance().getColor(ColorPalette.GRAY));
		sol.getOrbits().add(planet);
		// Jupiter
		planet = new SpaceObject(SpaceObject.TYPE_MASSIVE_GAS_GIANT, ColorPalette.getInstance().getColor(ColorPalette.BROWN));
		sol.getOrbits().add(planet);
		// Jupiter moons
		moon = new SpaceObject(SpaceObject.TYPE_PLANETOID, ColorPalette.getInstance().getColor(ColorPalette.BLUE));
		planet.getOrbits().add(moon);
		moon = new SpaceObject(SpaceObject.TYPE_PLANETOID, ColorPalette.getInstance().getColor(ColorPalette.GRAY));
		planet.getOrbits().add(moon);
		moon = new SpaceObject(SpaceObject.TYPE_PLANETOID, ColorPalette.getInstance().getColor(ColorPalette.YELLOW));
		planet.getOrbits().add(moon);
		moon = new SpaceObject(SpaceObject.TYPE_MOON_LIKE, ColorPalette.getInstance().getColor(ColorPalette.GRAY));
		planet.getOrbits().add(moon);
		// Saturn
		planet = new SpaceObject(SpaceObject.TYPE_MASSIVE_GAS_GIANT, ColorPalette.getInstance().getColor(ColorPalette.YELLOW));
		sol.getOrbits().add(planet);
		// Saturn moons
		moon = new SpaceObject(SpaceObject.TYPE_PLANETOID, ColorPalette.getInstance().getColor(ColorPalette.BLUE));
		planet.getOrbits().add(moon);
		moon = new SpaceObject(SpaceObject.TYPE_PLANETOID, ColorPalette.getInstance().getColor(ColorPalette.GRAY));
		planet.getOrbits().add(moon);
		moon = new SpaceObject(SpaceObject.TYPE_PLANETOID, ColorPalette.getInstance().getColor(ColorPalette.YELLOW));
		planet.getOrbits().add(moon);
		moon = new SpaceObject(SpaceObject.TYPE_MOON_LIKE, ColorPalette.getInstance().getColor(ColorPalette.GRAY));
		planet.getOrbits().add(moon);
		// Uranus
		planet = new SpaceObject(SpaceObject.TYPE_GAS_GIANT, ColorPalette.getInstance().getColor(ColorPalette.BLUE));
		sol.getOrbits().add(planet);
		// Neptun
		planet = new SpaceObject(SpaceObject.TYPE_GAS_GIANT, ColorPalette.getInstance().getColor(ColorPalette.BLUE));
		sol.getOrbits().add(planet);
		// Pluto
		planet = new SpaceObject(SpaceObject.TYPE_PLANETOID, ColorPalette.getInstance().getColor(ColorPalette.GRAY));
		sol.getOrbits().add(planet);
		// Charon
		moon = new SpaceObject(SpaceObject.TYPE_PLANETOID, ColorPalette.getInstance().getColor(ColorPalette.GRAY));
		planet.getOrbits().add(moon);
	}
}
