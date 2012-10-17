package info.agentviolet.ui;

import java.awt.Graphics2D;

import info.agentviolet.model.IPresentationContext;
import info.agentviolet.model.IWorld;

public class AgencyPresentationContext implements IPresentationContext {

	private Graphics2D g;
	private IWorld world;
	
	public AgencyPresentationContext(IWorld world) {
		this.world=world;
	}
	
	public void setGraphicContext(Graphics2D g) {
		this.g=g;
	}
	
	int i=0;
	
	@Override
	public void draw() {
		
//		world.
	
		g.drawLine(0, 0, i++, 100);
		if (i > 1000) {
			i = 0;
		}
		g.drawString("Hallo!", 250, 250);
		g.drawOval(300, 300, 50, 50);
	}

}
