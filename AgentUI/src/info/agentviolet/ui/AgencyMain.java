package info.agentviolet.ui;

import info.agentviolet.impl.World;
import info.agentviolet.model.IWorld;

public class AgencyMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final IWorld world = new World();
		final DrawingWindow window = new DrawingWindow( "Agency", world);
		final WorldTime worldTime = new WorldTime(world, window);
		
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
