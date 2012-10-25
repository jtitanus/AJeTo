package info.agentviolet.utils;

import info.agentviolet.model.ISpaceVector;

public class VectorUtils {

	public static boolean isAtPosition(ISpaceVector fromPos, ISpaceVector toPos, float tolerance) {		
		return Math.abs(fromPos.getX() - toPos.getX()) <= Math.abs(tolerance)
			&& 	Math.abs(fromPos.getY() - toPos.getY()) <= Math.abs(tolerance)
			&& Math.abs(fromPos.getZ() - toPos.getZ()) <= Math.abs(tolerance);		
	}
	
	public static float getAngle(ISpaceVector fromPos, ISpaceVector toPos) {
		// TODO compute angle from two vectors
		return 0f;		
	}
}
