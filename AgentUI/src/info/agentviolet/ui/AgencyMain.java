package info.agentviolet.ui;

import info.agentviolet.examples.creatures.CreatureAgencyPresentationContext;
import info.agentviolet.examples.creatures.CreaturePen;
import info.agentviolet.model.IWorld;
import info.agentviolet.view.IPresentationContext;
import info.agentviolet.view.IViewLayerPresentationContext;
import info.agentviolet.world.WorldTime;

public class AgencyMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final IWorld world = new CreaturePen();
		final IViewLayerPresentationContext presentationContext = new CreatureAgencyPresentationContext();
		final DrawingWindow window = new DrawingWindow( "Agency", world, (IPresentationContext)presentationContext);
		final WorldTime worldTime = new WorldTime(world, window);
		world.getViewLayers().get(0).setViewLayerPresentationContext(presentationContext);
		
		worldTime.start();
		
//		java.awt.EventQueue.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {            	
            	window.setVisible(true);            	
//            }
//		});
	}
}
