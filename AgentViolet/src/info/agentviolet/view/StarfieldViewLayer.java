package info.agentviolet.view;

import info.agentviolet.model.objects.StarfieldParticleSystem;

public class StarfieldViewLayer extends ViewLayerBase {

	private StarfieldParticleSystem starfield;

	public StarfieldViewLayer(IViewLayerPresentationContext presentationContext, int starsCount) {
		super(presentationContext);
		starfield = new StarfieldParticleSystem(starsCount);		
		this.addObject(starfield);
	}

}
