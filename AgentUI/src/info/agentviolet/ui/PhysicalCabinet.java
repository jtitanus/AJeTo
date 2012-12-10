package info.agentviolet.ui;

import info.agentviolet.examples.creatures.CreatureAgencyPresentationContext;
import info.agentviolet.impl.SpaceVector;
import info.agentviolet.model.IPresentationContext;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.world.PhysicalWorld;
import info.agentviolet.world.WorldTime;
import info.agentviolet.world.basicObjects.Rock;

public class PhysicalCabinet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final IWorld world = new PhysicalWorld();
		final IPresentationContext presentationContext = new PhysCabPresentationContext();
		final DrawingWindow window = new DrawingWindow( "Rocky", world, presentationContext);
		final WorldTime worldTime = new WorldTime(world, window);
		
		IWorldObject rock = new Rock(world);
		rock.getLocation().setPosition(new SpaceVector(100f,100f,0f));		
		world.addObject(rock);
		
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