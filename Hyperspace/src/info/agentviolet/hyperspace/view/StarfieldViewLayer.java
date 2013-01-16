package info.agentviolet.hyperspace.view;

import info.agentviolet.hyperspace.objects.StarfieldParticleSystem;
import info.agentviolet.view.IViewLayerPresentationContext;
import info.agentviolet.view.ViewLayerBase;

public class StarfieldViewLayer extends ViewLayerBase {

	private StarfieldParticleSystem starfield;

	public StarfieldViewLayer(IViewLayerPresentationContext presentationContext, int starsCount) {
		super(presentationContext);
		starfield = new StarfieldParticleSystem(starsCount);		
		this.addObject(starfield);
	}

}
