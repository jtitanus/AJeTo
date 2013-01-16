package info.agentviolet.ui.presentationContexts;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import info.agentviolet.utils.BitmapSource;
import info.agentviolet.view.IPresentationContext;
import info.agentviolet.view.IViewLayer;
import info.agentviolet.view.IViewLayerPresentationContext;

public class StaticBitmapViewLayerPresentationContext implements
		IViewLayerPresentationContext {

	private final IPresentationContext presentationContext;

	public StaticBitmapViewLayerPresentationContext(
			final IPresentationContext presentationContext) {
		this.presentationContext = presentationContext;
	}

	@Override
	public void draw(IViewLayer layer) {
		Graphics2D g = (Graphics2D) presentationContext.getGraphicContext();
		BufferedImage img = BitmapSource.getInstance().getImage(0);
		// Image scaledImg = img.getScaledInstance(g.getDeviceConfiguration().getBounds().width,
		// g.getDeviceConfiguration().getBounds().height, Image.SCALE_FAST);
		// g.drawImage(scaledImg, 0, 0, scaledImg.getWidth(null),
		// scaledImg.getHeight(null), 0, 0, scaledImg.getWidth(null),
		// scaledImg.getHeight(null), null);

		g.drawImage(img, 0, 0, null);
		// g.drawImage(img, new AffineTransform(0.5f,0f,0f,0.5f,0f,0f), null);
		// g.drawImage(img, 0, 0, g.getDeviceConfiguration().getBounds().width - 1, g.getDeviceConfiguration().getBounds().height - 1, 0, 0, img.getWidth() - 1, img.getHeight() - 1, null);
	}

}
