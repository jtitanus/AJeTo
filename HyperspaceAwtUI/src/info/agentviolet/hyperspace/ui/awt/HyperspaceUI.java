package info.agentviolet.hyperspace.ui.awt;

import info.agentviolet.world.WorldTime;
import info.agentviolet.hyperspace.model.HyperspaceWorld;
import info.agentviolet.ui.DrawingWindow;
//import info.agentviolet.utils.BitmapSource;

public class HyperspaceUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//BitmapSource.getInstance(); // read images into memory
		
		final HyperspacePresentationContext hyperspaceUiContext = new HyperspacePresentationContext();
		final HyperspaceWorld world = new HyperspaceWorld(hyperspaceUiContext);
				
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
