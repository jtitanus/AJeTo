package info.agentviolet.hyperspace.model.space;

import info.agentviolet.utils.Dice;
import info.agentviolet.view.ColorPalette;
import info.agentviolet.view.VioletColor;

import java.util.List;
import java.util.Random;

public class StarSystemGenerator {

	public static StarSystem generate(long seed) {
		Random rnd = new Random(seed);
		
		// generate star		
		SpaceObject star = new SpaceObject(SpaceObject.TYPE_SUPER_MASSIVE_GAS_GIANT, 
				(VioletColor) Dice.roll(new Object[] {25, ColorPalette.getInstance().getColor(ColorPalette.RED),
													  45, ColorPalette.getInstance().getColor(ColorPalette.YELLOW),
													  85, ColorPalette.getInstance().getColor(ColorPalette.WHITE)
													  }, rnd));		
		
		// generate planets
		Integer planetCount = (Integer) Dice.roll(new Object[] {
				20, 0,
				30, 1,
				36, 2,
				48, 3,
				59, 4,
				65, 5,
				77, 6,
				88, 7,
				93, 8,
				97, 9}, rnd);		
		
		for(int i=0; i<planetCount; i++) {
			SpaceObject planet = new SpaceObject( (int) Dice.roll(new Object[] {
					8 + planetCount-i, SpaceObject.TYPE_PLANETOID,
					25+ planetCount-i, SpaceObject.TYPE_EARTH_LIKE,
					40+ planetCount-i, SpaceObject.TYPE_SOLID,
					60, SpaceObject.TYPE_GAS_GIANT,
					80, SpaceObject.TYPE_MASSIVE_GAS_GIANT,
					92, SpaceObject.TYPE_PLANETOID,
					95, SpaceObject.TYPE_ASTEROID}
					, rnd), 
					(VioletColor) Dice.roll(new Object[] {
							25, ColorPalette.getInstance().getColor(ColorPalette.RED),
							45, ColorPalette.getInstance().getColor(ColorPalette.YELLOW),
							85, ColorPalette.getInstance().getColor(ColorPalette.WHITE)
							}, rnd));
			star.orbits.add(planet);
			Integer moonCount;
			switch(planet.getType()) {
				case SpaceObject.TYPE_ASTEROID:
				case SpaceObject.TYPE_PLANETOID:
					moonCount = 0;
				case SpaceObject.TYPE_EARTH_LIKE:
				case SpaceObject.TYPE_SOLID:
					moonCount = (Integer) Dice.roll(new Object[] {
							75, 0,
							90, 1,
							95, 2,
							97, 3}, rnd);
					for(int j=0; j<moonCount; j++) {
						SpaceObject moon = new SpaceObject( (int) Dice.roll(new Object[] { 								
								65, SpaceObject.TYPE_PLANETOID,
								99, SpaceObject.TYPE_ASTEROID}
								, rnd), 
								(VioletColor) Dice.roll(new Object[] {
										25, ColorPalette.getInstance().getColor(ColorPalette.RED),
										45, ColorPalette.getInstance().getColor(ColorPalette.YELLOW),
										85, ColorPalette.getInstance().getColor(ColorPalette.WHITE)
										}, rnd));
						planet.orbits.add(moon);
					}
					break;
				case SpaceObject.TYPE_GAS_GIANT:
				case SpaceObject.TYPE_MASSIVE_GAS_GIANT:							
					moonCount = (Integer) Dice.roll(new Object[] {
																	10, 0,
																	20, 1,
																	30, 2,
																	40, 3,
																	50, 4,
																	60, 5,
																	70, 6,
																	80, 7,
																	90, 8,
																	95, 9,
																	}, rnd);
					for(int j=0; j<moonCount; j++) {
						SpaceObject moon = new SpaceObject( (int) Dice.roll(new Object[] { 
								7, SpaceObject.TYPE_EARTH_LIKE,
								35, SpaceObject.TYPE_PLANETOID,
								75, SpaceObject.TYPE_SOLID,																
								90, SpaceObject.TYPE_ASTEROID}
								, rnd), 
								(VioletColor) Dice.roll(new Object[] {
										25, ColorPalette.getInstance().getColor(ColorPalette.RED),
										45, ColorPalette.getInstance().getColor(ColorPalette.YELLOW),
										85, ColorPalette.getInstance().getColor(ColorPalette.WHITE)
										}, rnd));
						planet.orbits.add(moon);
					}
					break;
					default: break;
			}
			
		}		
		// generate space stations
		List<SpaceObject> allObjects = StarSystem.getAllSpaceObjectsOf(star);
		Integer spaceStationsCount = (Integer) Dice.roll(new Object[] {
				15, 0,
				65, 1,
				85, 2,
				97, 3}, rnd);
		if (allObjects.size() == 0) {
			for (int i = 0; i < spaceStationsCount; i++) {
				star.orbits.add(new SpaceStation());
			}
		} else {
			for (int i = 0; i < spaceStationsCount; i++) {
				int index = Dice.rollInt(rnd, allObjects.size());
				allObjects.get(index).orbits.add(new SpaceStation());
			}
		}
		return new StarSystem(star);
	}
}
