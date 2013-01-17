package info.agentviolet.view;

public class VioletColor {
	
	public int r, g, b;
	private Object specificColorObject;

	public VioletColor(Object specificColorObject) {
		this.specificColorObject = specificColorObject;
	}

	public VioletColor(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public Object getColorObject() {
		return specificColorObject;
	}
}
