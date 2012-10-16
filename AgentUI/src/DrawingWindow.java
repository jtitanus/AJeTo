import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;


class DrawingWindow extends JFrame {
		

	DrawingWindow(String title) {
		super(title);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    setSize( 800, 550 );
	    Dimension d = Toolkit.getDefaultToolkit().getScreenSize()  ;
	    setLocation  ( (d.width - getWidth() ) / 2,
	                   (d.height- getHeight()) / 2 );
		
	}
		
	@Override
	public void paint(Graphics g) {	
		super.paint(g);
		g.drawLine(0, 0, 100, 100);
		g.drawString("Hallo!", 250, 250);
	}
}
