package info.agentviolet.ui.presentationContexts;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import info.agentviolet.model.IWorld;
import info.agentviolet.view.IPresentationContext;
import info.agentviolet.view.IViewLayer;

public class PresentationContextBase implements IPresentationContext {

	protected Graphics2D g;

	@Override
	public void setGraphicContext(Object graphicContext) {
		this.g = (Graphics2D) graphicContext;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	@Override
	public void draw(IWorld world) {

		for (IViewLayer layer : world.getViewLayers()) {
			layer.draw();
		}

	}

	@Override
	public Object getGraphicContext() {
		return g;
	}

}
