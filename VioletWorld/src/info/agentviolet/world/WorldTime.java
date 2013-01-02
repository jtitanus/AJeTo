package info.agentviolet.world;

import javax.swing.JFrame;

import info.agentviolet.impl.WorldAttributesBase;
import info.agentviolet.model.IWorld;

public class WorldTime extends Thread {

	private final IWorld world;
	private final JFrame window;
	private boolean isRunning = true;
	private PhysicsThread physicsThread;
	
	public WorldTime(final IWorld world, final JFrame window) {
		this.world = world;
		this.window = window;
		physicsThread = new PhysicsThread(world);		
	}

	@Override
	public synchronized void run() {
		super.run();
		try {
			while (isRunning) {				
				this.wait((int) world.getAttributes().getAttribute(WorldAttributesBase.UPDATE_TIME));
				window.repaint();
			}
		} catch (InterruptedException e) {
			isRunning = false;
		}
	}
	
	public void exit() {
		physicsThread.exit();
		isRunning = false;
	}
		
	
	private class PhysicsThread extends Thread {

		private final IWorld world;
		private boolean isRunning = true;	
		
		public PhysicsThread(final IWorld world) {
			super();
			this.world = world;
			start();
		}

		@Override
		public synchronized void run() {
			super.run();
			try {
				while (isRunning) {
					world.update();
					this.wait((int) world.getAttributes().getAttribute(WorldAttributesBase.UPDATE_TIME));
				}
			} catch (InterruptedException e) {
				isRunning = false;
			}
		}
		
		
		public void exit() {
			isRunning = false;
		}
	}
}
