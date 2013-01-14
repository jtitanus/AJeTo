package info.agentviolet.view;

import info.agentviolet.model.objects.StarfieldParticleSystem;

public class StarfieldViewLayer extends ViewLayerBase {

	private StarfieldParticleSystem starfield;
	
	public StarfieldViewLayer(IViewLayerPresentationContext presentationContext, int starsCount) {
		starfield=new StarfieldParticleSystem(starsCount);
		this.presentationContext = presentationContext;
		this.addObject(starfield);
	}

	
	
}
