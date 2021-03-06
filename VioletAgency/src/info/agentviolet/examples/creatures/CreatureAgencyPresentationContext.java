package info.agentviolet.examples.creatures;

import info.agentviolet.impl.ObjectAttributesBase;
import info.agentviolet.model.IAgent;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.view.IPresentationContext;
import info.agentviolet.view.IViewLayer;
import info.agentviolet.view.IViewLayerPresentationContext;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;

public class CreatureAgencyPresentationContext implements IPresentationContext, IViewLayerPresentationContext {

	private static final int INT_SMALL_STATUS_BAR_HEIGHT = 3;
	private static final int INT_SMALL_STATUS_BAR_WIDTH = 24;
	private Graphics2D g;

	public void setGraphicContext(Object graphicContext) {
		this.g = (Graphics2D) graphicContext;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	@Override
	public void draw(IWorld world) {
		for(IViewLayer layer: world.getViewLayers()) {
			draw(layer);
		}		
	}

	@Override
	public Object getGraphicContext() {
		return g;
	}

	@Override
	public void draw(IViewLayer layer) {
		g.setColor(new Color(220, 250, 210));
		g.fillRect(0, 0, g.getDeviceConfiguration().getBounds().width, g.getDeviceConfiguration().getBounds().height);
		for (IWorldObject wObject : layer.getWorldObjects()) {
			if (wObject.isActive()) {
				if (wObject instanceof Creature) {
					g.setColor(Color.GREEN);
				} else if (wObject instanceof Muffin) {
					g.setColor(new Color(140, 70, 10)); // brown
				}
				g.fill((Shape)wObject.getShape().getGraphicShape());
			}
		}
		
		// looking directions
		for (IWorldObject wObject : layer.getWorldObjects()) {
			if (wObject.isActive() && !wObject.isStatic()) {			
				g.setColor(Color.LIGHT_GRAY);
				if (wObject.getLocation().getLookingPosition() != null) {
					g.drawLine((int) wObject.getLocation().getPosition()
							.getX() + 12, (int) wObject.getLocation()
							.getPosition().getY() + 12,
							(int) wObject.getLocation()
									.getLookingPosition().getX() + 12,
							(int) wObject.getLocation()
									.getLookingPosition().getY() + 12);
				}				
			}
		}
		
		// visualize needs
		for (IWorldObject wObject : layer.getWorldObjects()) {
			if (wObject instanceof IAgent && wObject.isActive()
					&& !wObject.isStatic()) {
				float satisfaction = ((IAgent) wObject).getNeeds().getOverallSatisfactionLevel();
				g.setColor(Color.BLACK);
				g.fillRect((int) wObject.getLocation().getPosition().getX(),
						(int) wObject.getLocation().getPosition().getY() - 12,
						INT_SMALL_STATUS_BAR_WIDTH, INT_SMALL_STATUS_BAR_HEIGHT);
				g.setColor(Color.ORANGE);
				g.fillRect((int) wObject.getLocation().getPosition().getX(),
						(int) wObject.getLocation().getPosition().getY() - 12,
						(int) (satisfaction * (float)INT_SMALL_STATUS_BAR_WIDTH),
						INT_SMALL_STATUS_BAR_HEIGHT);
			}
		}
		
		// visualize hit points
		for (IWorldObject wObject : layer.getWorldObjects()) {
			if (wObject instanceof IAgent && wObject.isActive()
					&& !wObject.isStatic()) {
				float maxHitpoints = (float) wObject.getAttributes().getAttribute(ObjectAttributesBase.MAX_HITPOINTS);
				float hitpoints = (float) wObject.getAttributes().getAttribute(ObjectAttributesBase.HITPOINTS);
				g.setColor(Color.BLACK);
				g.fillRect((int) wObject.getLocation().getPosition().getX(),
						(int) wObject.getLocation().getPosition().getY() - 16,
						INT_SMALL_STATUS_BAR_WIDTH, INT_SMALL_STATUS_BAR_HEIGHT);
				g.setColor(Color.GREEN);
				g.fillRect((int) wObject.getLocation().getPosition().getX(),
						(int) wObject.getLocation().getPosition().getY() - 16,
						(int) (maxHitpoints / hitpoints)  *  INT_SMALL_STATUS_BAR_WIDTH,
						INT_SMALL_STATUS_BAR_HEIGHT);
			}
		}
		
	}

}
