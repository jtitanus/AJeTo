package info.agentviolet.utils;

import java.lang.reflect.Field;

public abstract class AttributesUtils {
	
	public static Object[] initAttributes(Object attributesDefiningInstance) {
		Field[] fields = attributesDefiningInstance.getClass().getFields();
		int len = 0;
		for (int i = 0; i < fields.length; i++) {
			try {
				int j = fields[i].getInt(fields[i]);
				len = Math.max(len, j);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		Object[] attributes = new Object[++len];

		// check collisions, can be removed in production release
		for (int i = 0; i < fields.length; i++) {
			try {
				int j = fields[i].getInt(fields[i]);
				if (attributes[j] == null) {
					attributes[j] = Integer.MIN_VALUE;
				} else {
					// collision
					System.out
							.println("World object attributes contain a coliding definition");
					System.err
							.println("World object attributes contain a coliding definition");
					System.exit(-1);
				}
				attributes[j] = null; // reset to null
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return attributes;
	}
}
