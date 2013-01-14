package info.agentviolet.ui;

import java.awt.Color;
import java.awt.Graphics2D;

import info.agentviolet.model.IWorldObject;
import info.agentviolet.model.objects.IParticle;
import info.agentviolet.model.objects.IParticleSystem;
import info.agentviolet.view.IPresentationContext;
import info.agentviolet.view.IViewLayer;
import info.agentviolet.view.IViewLayerPresentationContext;

public class ParticleSystemViewLayerPresentationContextBase implements IViewLayerPresentationContext {

	private final IPresentationContext presentationContext;
	
	public ParticleSystemViewLayerPresentationContextBase(final IPresentationContext presentationContext) {
		this.presentationContext = presentationContext;
	}
	
	@Override
	public void draw(IViewLayer layer) {
		Graphics2D g = (Graphics2D)presentationContext.getGraphicContext();
		g.setColor(Color.WHITE);
		for(IWorldObject wo: layer.getWorldObjects()) {
			if(wo instanceof IParticleSystem) {
				IParticleSystem particleSystem = (IParticleSystem)wo;
				for(IParticle particle:particleSystem.getParticles()) {
					g.fillOval((int)particle.getX(), (int)particle.getY(), 1, 1);
				}
			}
		}
	}

}
