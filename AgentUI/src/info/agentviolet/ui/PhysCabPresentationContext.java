package info.agentviolet.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import info.agentviolet.impl.ObjectAttributesBase;
import info.agentviolet.model.IPresentationContext;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.IWorldObject;

public class PhysCabPresentationContext implements IPresentationContext {

	private Graphics2D g;
//	private BufferedImage buffi = null;

	@Override
	public void setGraphicContext(Object graphicContext) {
		this.g = (Graphics2D) graphicContext;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		if (buffi == null) {
//			buffi = new BufferedImage(g.getDeviceConfiguration().getBounds().width, g.getDeviceConfiguration().getBounds().height, BufferedImage.TYPE_INT_RGB);
//		}
	}

	@Override
	public void draw(IWorld world) {
//		Graphics2D bg = buffi.createGraphics();
//		bg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, g.getDeviceConfiguration().getBounds().width, g.getDeviceConfiguration().getBounds().height);
		for (IWorldObject wObject : world.getWorldObjects()) {
			// if (wObject.isActive()) {

			g.setColor(Color.DARK_GRAY);

			Shape shape = (Shape) wObject.getAttributes().getAttribute(ObjectAttributesBase.SHAPE);						
			g.fill(shape);			
		}
//		bg.dispose();

//		g.drawImage(buffi, 0, 0, buffi.getWidth(), buffi.getHeight(), null);

	}
}
