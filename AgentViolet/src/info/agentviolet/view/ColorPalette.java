package info.agentviolet.view;

import java.util.ArrayList;
import java.util.List;

public class ColorPalette {

	private static ColorPalette instance = null;

	private final List<VioletColor> palette = new ArrayList<VioletColor>();

	public static final int RED = 0;
	public static final int GREEN = 1;
	public static final int BLUE = 2;
	public static final int GRAY = 3;
	public static final int PASTEL_RED = 4;
	public static final int PASTEL_GREEN = 5;
	public static final int PASTEL_BLUE = 6;
	public static final int YELLOW = 7;
	public static final int WHITE = 8;
	public static final int BROWN = 9;

	private ColorPalette() {
		palette.add(new VioletColor(0xFF, 0x00, 0x00));
		palette.add(new VioletColor(0x00, 0xFF, 0x00));
		palette.add(new VioletColor(0x00, 0x00, 0xFF));
		palette.add(new VioletColor(0x90, 0x90, 0x90));
		palette.add(new VioletColor(0xE8, 0xA9, 0xB1));
		palette.add(new VioletColor(0x85, 0xC9, 0x8D));
		palette.add(new VioletColor(0xA5, 0xAB, 0xD6));
		palette.add(new VioletColor(0xFA, 0xF1, 0x78));
		palette.add(new VioletColor(0xFF, 0xFF, 0xFF));
		palette.add(new VioletColor(0xA3, 0x52, 0x00));
	}

	public static ColorPalette getInstance() {
		if (instance == null) {
			instance = new ColorPalette();
		}
		return instance;
	}

	public VioletColor getColor(int index) {
		return palette.get(index);
	}
}
