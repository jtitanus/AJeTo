package info.agentviolet.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import info.agentviolet.model.IPresentationContext;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.IWorldObject;

public class PhysCabPresentationContext implements IPresentationContext {

	private Graphics2D g;
	private BufferedImage buffi = null;

	@Override
	public void setGraphicContext(Object graphicContext) {
		this.g = (Graphics2D) graphicContext;
		// g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		// RenderingHints.VALUE_ANTIALIAS_ON);
		if (buffi == null) {
			buffi = new BufferedImage(g.getDeviceConfiguration().getBounds().width, g.getDeviceConfiguration().getBounds().height, BufferedImage.TYPE_INT_RGB);
		}
	}

	@Override
	public void draw(IWorld world) {

		Graphics2D bg = buffi.createGraphics();
		bg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		bg.setColor(new Color(220, 250, 210));
		bg.fillRect(0, 0, buffi.getWidth(), buffi.getHeight());
		for (IWorldObject wObject : world.getWorldObjects()) {
			// if (wObject.isActive()) {

			bg.setColor(Color.DARK_GRAY);

			bg.fillOval((int) wObject.getLocation().getPosition().getX(), (int) wObject.getLocation().getPosition().getY(), 25, 25);
			// }
		}

		bg.dispose();

		g.drawImage(buffi, 0, 0, buffi.getWidth(), buffi.getHeight(), null);

	}
}
