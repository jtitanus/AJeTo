package info.agentviolet.ui;

import info.agentviolet.model.IWorld;
import info.agentviolet.view.IPresentationContext;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingWindow extends JFrame {
		
	private static final long serialVersionUID = -4019454661296013001L;
	private IWorld world;
	private IPresentationContext context;

	public DrawingWindow(String title, final IWorld world, final IPresentationContext presentationContext) {
		super(title);
		this.world = world;
		context = presentationContext;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(800, 550);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width - getWidth()) / 2, (d.height - getHeight()) / 2);
		add(new DrawingCanvas());
	}

	class DrawingCanvas extends JPanel {
		
		private static final long serialVersionUID = 7568059355238737579L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			context.setGraphicContext((Graphics2D)g);
			context.draw(world);
		}
	}
}
