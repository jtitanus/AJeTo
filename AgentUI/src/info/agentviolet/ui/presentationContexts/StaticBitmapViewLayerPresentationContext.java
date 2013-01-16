package info.agentviolet.ui.presentationContexts;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import info.agentviolet.utils.BitmapSource;
import info.agentviolet.view.IPresentationContext;
import info.agentviolet.view.IViewLayer;
import info.agentviolet.view.IViewLayerPresentationContext;

public class StaticBitmapViewLayerPresentationContext implements IViewLayerPresentationContext {

private final IPresentationContext presentationContext;
	
	public StaticBitmapViewLayerPresentationContext(final IPresentationContext presentationContext) {
		this.presentationContext = presentationContext;
	}
	
	@Override
	public void draw(IViewLayer layer) {
		Graphics2D g = (Graphics2D)presentationContext.getGraphicContext();
		BufferedImage img = BitmapSource.getInstance().getImage(0);
		g.drawImage(img, 0, 0, g.getDeviceConfiguration().getBounds().width-1, g.getDeviceConfiguration().getBounds().height-1, 0, 0, img.getWidth()-1, img.getHeight()-1, null);		
	}

}
