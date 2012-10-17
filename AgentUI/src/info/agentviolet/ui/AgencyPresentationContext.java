package info.agentviolet.ui;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import info.agentviolet.model.IPresentationContext;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.IWorldObject;

public class AgencyPresentationContext implements IPresentationContext {

	private Graphics2D g;	
	
	public void setGraphicContext(Graphics2D g) {
		this.g=g;
		g.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
                			RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	
	@Override
	public void draw(IWorld world) {
		
		for (IWorldObject wObject : world.getWorldObjects()) {
			if(wObject.isActive()) {				
				g.fillOval((int)wObject.getLocation().getPosition().getX(),
						(int)wObject.getLocation().getPosition().getY(),
						25, 25);
				
			}
		} 		
	}

}
