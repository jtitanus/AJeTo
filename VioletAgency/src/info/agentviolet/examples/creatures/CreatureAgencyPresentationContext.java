package info.agentviolet.examples.creatures;

import info.agentviolet.model.IPresentationContext;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.IWorldObject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class CreatureAgencyPresentationContext implements IPresentationContext {

	private Graphics2D g;

	public void setGraphicContext(Object graphicContext) {
		this.g = (Graphics2D)graphicContext;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}

	@Override
	public void draw(IWorld world) {

		// 
		for (IWorldObject wObject : world.getWorldObjects()) {
			if (wObject.isActive()) {
				if (wObject instanceof Creature) {
					g.setColor(Color.DARK_GRAY);
				} else {
					g.setColor(Color.GREEN);
				}
				g.fillOval((int) wObject.getLocation().getPosition().getX(),
						(int) wObject.getLocation().getPosition().getY(), 24,
						24);
			}
		}

		// looking directions
		for (IWorldObject wObject : world.getWorldObjects()) {
			if (wObject.isActive()) {
				if (!wObject.isStatic()) {
					g.setColor(Color.LIGHT_GRAY);
					g.drawLine(
							(int) wObject.getLocation().getPosition().getX() + 12,
							(int) wObject.getLocation().getPosition().getY() + 12,
							(int) wObject.getLocation().getLookingPosition()
									.getX() + 12, (int) wObject.getLocation()
									.getLookingPosition().getY() + 12);
				}
			}
		}
	}

}
