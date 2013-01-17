package info.agentviolet.hyperspace.model.space;

import info.agentviolet.hyperspace.model.space.SpaceObject.Type;
import info.agentviolet.utils.Dice;
import info.agentviolet.view.ColorPalette;
import info.agentviolet.view.VioletColor;

import java.util.Random;

public class StarSystemGenerator {

	public StarSystem generate(long seed) {
		StarSystem system = new StarSystem();
		Random rnd = new Random(seed);
		
		// generate star		
		SpaceObject star = new SpaceObject(Type.SUPER_MASSIVE_GAS_GIANT, 
				(VioletColor) Dice.roll(new Object[] {25, ColorPalette.getInstance().getColor(ColorPalette.RED),
													  45, ColorPalette.getInstance().getColor(ColorPalette.YELLOW),
													  85, ColorPalette.getInstance().getColor(ColorPalette.WHITE)
													  }, rnd));
		
		// generate planets
		
		
		// generate space stations
		
		return system;
	}
}
