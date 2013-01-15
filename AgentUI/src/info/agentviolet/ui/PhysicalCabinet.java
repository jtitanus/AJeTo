package info.agentviolet.ui;

import info.agentviolet.impl.SpaceVector;
import info.agentviolet.impl.WorldBase;
import info.agentviolet.model.IWorld;
import info.agentviolet.model.IWorldObject;
import info.agentviolet.view.IPresentationContext;
import info.agentviolet.view.IViewLayerPresentationContext;
import info.agentviolet.world.PhysicalWorld;
import info.agentviolet.world.WorldTime;
import info.agentviolet.world.basicObjects.FixedBox;
import info.agentviolet.world.basicObjects.Rock;

public class PhysicalCabinet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final IWorld world = new PhysicalWorld();
		final IPresentationContext presentationContext = new PhysCabPresentationContext();
		final DrawingWindow window = new DrawingWindow("Rocky", world, presentationContext);
		final WorldTime worldTime = new WorldTime(world, window);
		world.getViewLayers().get(0).setViewLayerPresentationContext((IViewLayerPresentationContext) presentationContext);

		IWorldObject rock = new Rock(world, 25f, 25f);
		rock.getLocation().setPosition(new SpaceVector(100f, 100f, 0f));
		world.addObject(rock);

		IWorldObject box = new FixedBox(world, 250f, 30f);
		box.getLocation().setPosition(new SpaceVector(50f, 300f, 0f));
		world.addObject(box);

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
