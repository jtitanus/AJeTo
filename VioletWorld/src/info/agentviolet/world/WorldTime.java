package info.agentviolet.world;

import javax.swing.JFrame;

import info.agentviolet.impl.WorldAttributesBase;
import info.agentviolet.model.IWorld;

public class WorldTime extends Thread {

	private final IWorld world;
	private final JFrame window;
	private boolean isRunning = true;

	public WorldTime(final IWorld world, final JFrame window) {
		this.world = world;
		this.window = window;
	}

	@Override
	public synchronized void run() {
		super.run();
		try {
			while (isRunning) {
				world.update();
				window.repaint();
				this.wait((int) world.getAttributes().getAttribute(WorldAttributesBase.DELTA_TIME));
			}
		} catch (InterruptedException e) {
			isRunning = false;
		}
	}
	
	public void exit() {
		isRunning = false;
	}
}
