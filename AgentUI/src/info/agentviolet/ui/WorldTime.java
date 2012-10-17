package info.agentviolet.ui;

import javax.swing.JFrame;

import info.agentviolet.model.IWorld;

public class WorldTime extends Thread {

	private final IWorld world;
	private final JFrame window;
	
	public WorldTime(final IWorld world, final JFrame window) {
		this.world=world;
		this.window=window;
	}
	
	@Override
	public synchronized void run() {	
		super.run();
		boolean isRunning = true;
		try {
			while(isRunning) {
				world.update();
				window.repaint();
				this.wait(30);
			}
		} catch (InterruptedException e) {
			
		}		
	}
}
