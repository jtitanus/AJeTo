package info.agentviolet.ui;

import java.awt.Graphics2D;

import info.agentviolet.model.IPresentationContext;
import info.agentviolet.model.IWorld;

public class AgencyPresentationContext implements IPresentationContext {

	private Graphics2D g;	
	
	public void setGraphicContext(Graphics2D g) {
		this.g=g;
	}
	
	
	@Override
	public void draw(IWorld world) {
		
		
		g.drawString("Hallo!", 250, 250);
		g.drawOval(300, 300, 50, 50);
	}

}
