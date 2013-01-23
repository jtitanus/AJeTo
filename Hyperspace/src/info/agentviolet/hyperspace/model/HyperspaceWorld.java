package info.agentviolet.hyperspace.model;

import info.agentviolet.hyperspace.view.StarfieldViewLayer;
import info.agentviolet.impl.WorldAttributesBase;
import info.agentviolet.impl.WorldBase;
import info.agentviolet.ui.presentationContexts.ParticleSystemViewLayerPresentationContextBase;
import info.agentviolet.view.IPresentationContext;

public class HyperspaceWorld extends WorldBase {

	public HyperspaceWorld(final IPresentationContext presCon) {
		attributes = new WorldAttributesBase();
		viewLayers.clear();
	//	viewLayers.add(new StaticBackgroundLayer(new StaticBitmapViewLayerPresentationContext(presCon)));
		viewLayers.add(new StarfieldViewLayer(new ParticleSystemViewLayerPresentationContextBase(presCon), 1500));
		viewLayers.add(new StarfieldViewLayer(new ParticleSystemViewLayerPresentationContextBase(presCon), 1500));
	}

}
