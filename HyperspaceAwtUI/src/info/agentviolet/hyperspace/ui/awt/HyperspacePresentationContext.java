package info.agentviolet.hyperspace.ui.awt;

import info.agentviolet.model.IWorld;
import info.agentviolet.ui.PresentationContextBase;
import java.awt.Color;

public class HyperspacePresentationContext extends PresentationContextBase {


	@Override
	public void draw(IWorld world) {
		g.setColor(Color.black);
		g.fillRect(0, 0, g.getDeviceConfiguration().getBounds().width, g.getDeviceConfiguration().getBounds().height);
		super.draw(world);

		g.setColor(Color.WHITE);
		g.drawString("Hallo", 100, 100);		
	}

}
