package info.agentviolet.ui;
import info.agentviolet.impl.World;



public class AgencyMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DrawingWindow w = new DrawingWindow( "Agency", new World());
		w.setVisible(true);
		
	}

}
