package info.agentviolet.ui;

import info.agentviolet.model.IWorld;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

class DrawingWindow extends JFrame {
	private IWorld world;
	private AgencyPresentationContext context;

	DrawingWindow(String title, final IWorld world) {
		super(title);
		this.world = world;
		context = new AgencyPresentationContext();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 550);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width - getWidth()) / 2, (d.height - getHeight()) / 2);
		add(new DrawingCanvas());
	}

	class DrawingCanvas extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			context.setGraphicContext((Graphics2D)g);
			context.draw(world);
		}
	}
}
