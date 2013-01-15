package info.agentviolet.hyperspace.ui.awt;

import info.agentviolet.view.StarfieldViewLayer;
import info.agentviolet.world.WorldTime;
import info.agentviolet.hyperspace.model.HyperspaceWorld;
import info.agentviolet.ui.DrawingWindow;
import info.agentviolet.ui.ParticleSystemViewLayerPresentationContextBase;

public class HyperspaceUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final HyperspacePresentationContext hyperspaceUiContext = new HyperspacePresentationContext();
		final HyperspaceWorld world = new HyperspaceWorld();
		
		// world init
		world.getViewLayers().add(new StarfieldViewLayer(new ParticleSystemViewLayerPresentationContextBase(hyperspaceUiContext), 1000));
		
		DrawingWindow window = new DrawingWindow("Hyperspace", world, hyperspaceUiContext);
		WorldTime worldTime = new WorldTime(world, window);
		
		
		worldTime.start();
		
		// java.awt.EventQueue.invokeLater(new Runnable() {
		//
		// @Override
		// public void run() {
		window.setVisible(true);
		// }
		// });
	}

	
}
