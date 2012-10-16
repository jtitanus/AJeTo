package info.agentviolet.ui;
import info.agentviolet.model.IWorld;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;

class DrawingWindow extends JFrame {
	private IWorld world;
	private AgencyPresentationContext context;
	private int i = 0;
	
	DrawingWindow(String title, final IWorld world) {
		super(title);
		this.world = world;
		context = new AgencyPresentationContext(world);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 550);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width - getWidth()) / 2, (d.height - getHeight()) / 2);
		
		new Runnable() {
			
			@Override
			public void run() {
				boolean isRunning = true;
				try {
					while(isRunning) {
						world.update();
						repaint();
						this.wait(30);
					}
				} catch (InterruptedException e) {
					
				}			
			}
		}.run();		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(0, 0, i++, 100);
		if (i > 1000) {
			i = 0;
		}
		g.drawString("Hallo!", 250, 250);
		context.draw();
	}
}
