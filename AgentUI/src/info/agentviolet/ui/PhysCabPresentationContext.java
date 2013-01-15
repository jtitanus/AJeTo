package info.agentviolet.ui;

import java.awt.Color;
import java.awt.Shape;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.view.IViewLayer;
import info.agentviolet.view.IViewLayerPresentationContext;

public class PhysCabPresentationContext extends PresentationContextBase implements IViewLayerPresentationContext {
	
	@Override
	public void draw(IViewLayer layer) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, g.getDeviceConfiguration().getBounds().width, g.getDeviceConfiguration().getBounds().height);
		for (IWorldObject wObject : layer.getWorldObjects()) {
			// if (wObject.isActive()) {

			g.setColor(Color.DARK_GRAY);

			Shape shape = (Shape) wObject.getShape().getGraphicShape();						
			g.fill(shape);			
		}
		
	}
}
