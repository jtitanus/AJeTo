package info.agentviolet.utils;

import java.util.ArrayList;
import java.util.Collection;

import info.agentviolet.impl.SpaceVector;
import info.agentviolet.model.ISpaceVector;
import info.agentviolet.model.IWorldObject;

public class VectorUtils {

	private static final SpaceVectorLengthComparator vectorLengthComparator = new SpaceVectorLengthComparator();
	
	public static boolean isAtPosition(ISpaceVector fromPos,
			ISpaceVector toPos, float tolerance) {
		return Math.abs(fromPos.getX() - toPos.getX()) <= Math.abs(tolerance)
				&& Math.abs(fromPos.getY() - toPos.getY()) <= Math
						.abs(tolerance)
				&& Math.abs(fromPos.getZ() - toPos.getZ()) <= Math
						.abs(tolerance);
	}

	/*** In degrees. Zero degrees is x=1, y=0 or the x axis */
	public static float getAngleXY(ISpaceVector relPos) {
		float retval = ((float) Math.atan(relPos.getY() / relPos.getX())) * (180f / (float) Math.PI);
		if (relPos.getX() >= 0f) {
			if (relPos.getY() >= 0f) {
				// nothing
			} else {
				// x pos, y neg
				retval = 360f + retval;
			}
		} else {
			// x neg, y pos
			if (relPos.getY() > 0f) {
				retval = 180f + retval;
			} else {
				// x neg, y neg
				retval += 180;
			}
		}
		return retval; // TODO: double / float?
	}

	public static ISpaceVector getVectorByAngle(float angle, float length) {
		return new SpaceVector((float)Math.cos(angle*(Math.PI/180f)) * length, (float)Math.sin(angle*(Math.PI/180f)) * length, 0f);
	}	
	
	public static ISpaceVector add(ISpaceVector vec1, ISpaceVector vec2) {
		return new SpaceVector(vec1.getX() + vec2.getX(),
							   vec1.getY() + vec2.getY(),
							   vec1.getZ() + vec2.getZ());
	}

	public static ISpaceVector subtract(ISpaceVector vec1, ISpaceVector vec2) {
		return new SpaceVector(vec1.getX() - vec2.getX(), vec1.getY()
				- vec2.getY(), vec1.getZ() - vec2.getZ());
	}

	public static ISpaceVector multiplyScalar(ISpaceVector vec, float scalar) {
		return new SpaceVector(vec.getX() * scalar, vec.getY() * scalar,
				vec.getZ() * scalar);
	}

	public static float getVectorLength(ISpaceVector vec) {
		// TODO float/double optimization
		return (float)Math.sqrt(Math.pow((double)vec.getX(), 2d) + Math.pow((double)vec.getY(), 2d) + Math.pow((double)vec.getZ(), 2d));
	}
	
	public static float getDistance(ISpaceVector vec1, ISpaceVector vec2) {
		ISpaceVector vecDiff = subtract(vec2, vec1);
		return getVectorLength(vecDiff);
	}
	
	/**
	 * Returns a world object of the specified type.
	 * 
	 * @param worldobjects
	 *            all world objects to be considered
	 * @param typeToSeek
	 * @param relPos
	 *            Relative position to seek from
	 * @return the nearest object of the specified type or null if there is no
	 *         such object in the input set
	 */
	public static IWorldObject getNearestWorldObject(
			Collection<IWorldObject> worldobjects,
			Class<?> typeToSeek,
			ISpaceVector relPos) {
		IWorldObject retVal = null;
		for (IWorldObject wo : getWorldObjectsOfType(worldobjects, typeToSeek)) {
			if (retVal == null) {
				retVal = wo;
			} else {
				if(vectorLengthComparator.compare(retVal.getLocation().getPosition(), wo.getLocation().getPosition(), relPos) >0) {
					retVal = wo;
				}				
			}
		}
		return retVal;
	}

	/***
	 * Returns a filtered list of active world objects of the specified type. 
	 * @param worldobjects
	 * @param typeToSeek
	 * @return
	 */
	public static Collection<IWorldObject> getWorldObjectsOfType(
			Collection<IWorldObject> worldobjects, Class<?> typeToSeek) {
		ArrayList<IWorldObject> seekList = new ArrayList<IWorldObject>();
		for (IWorldObject wo : worldobjects) {
			if (typeToSeek.isInstance(wo) && wo.isActive()) {
				seekList.add(wo);
			}
		}
		return seekList;
	}
	
}
