package info.agentviolet.utils;

import info.agentviolet.impl.SpaceVector;
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
	
	public static ISpaceVector add(ISpaceVector vec1, ISpaceVector vec2) {
		return new SpaceVector(vec1.getX()+vec2.getX(), 
							   vec1.getY()+vec2.getY(),
							   vec1.getZ()+vec2.getZ());
	}
	
	public static ISpaceVector subtract(ISpaceVector vec1, ISpaceVector vec2) {
		return new SpaceVector(vec1.getX()-vec2.getX(), 
							   vec1.getY()-vec2.getY(),
							   vec1.getZ()-vec2.getZ());
	}
	
	public static ISpaceVector multiplyScalar(ISpaceVector vec, float scalar) {
		return new SpaceVector(vec.getX() * scalar,
							   vec.getY() * scalar,
							   vec.getZ() * scalar);
	}
}
