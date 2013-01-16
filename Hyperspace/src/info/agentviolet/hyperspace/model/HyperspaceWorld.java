package info.agentviolet.hyperspace.model;

import info.agentviolet.hyperspace.view.StarfieldViewLayer;
import info.agentviolet.impl.WorldAttributesBase;
import info.agentviolet.impl.WorldBase;
import info.agentviolet.ui.presentationContexts.ParticleSystemViewLayerPresentationContextBase;
import info.agentviolet.ui.presentationContexts.StaticBitmapViewLayerPresentationContext;
import info.agentviolet.view.IPresentationContext;
import info.agentviolet.view.StaticBackgroundLayer;

public class HyperspaceWorld extends WorldBase {

	public HyperspaceWorld(IPresentationContext presCon) {
		attributes = new WorldAttributesBase();
		viewLayers.clear();
		viewLayers.add(new StaticBackgroundLayer(new StaticBitmapViewLayerPresentationContext(presCon)));
		viewLayers.add(new StarfieldViewLayer(new ParticleSystemViewLayerPresentationContextBase(presCon), 1000));
	}

}
