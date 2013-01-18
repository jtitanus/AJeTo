package info.agentviolet.hyperspace.model.space;

import info.agentviolet.view.ColorPalette;


public class SpaceStation extends SpaceObject {

	public SpaceStation() {
		super(TYPE_SPACE_STATION, ColorPalette.getInstance().getColor(ColorPalette.GRAY));
	}

}
