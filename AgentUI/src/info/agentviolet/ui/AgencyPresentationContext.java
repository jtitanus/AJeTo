package info.agentviolet.ui;

import java.awt.Graphics;

import info.agentviolet.model.IPresentationContext;
import info.agentviolet.model.IWorld;

public class AgencyPresentationContext implements IPresentationContext {

	private Graphics g;
	private IWorld world;
	
	public AgencyPresentationContext(IWorld world) {
		this.world=world;
	}
	
	public void setGraphicContext(Graphics g) {
		this.g=g;
	}
	
	@Override
	public void draw() {
//		world.
		g.drawOval(300, 300, 50, 50);
	}

}
