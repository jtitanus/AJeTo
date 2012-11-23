package info.agentviolet.utils;

import info.agentviolet.impl.SpaceVector;
import info.agentviolet.model.ISpaceVector;

import java.util.Comparator;

public class SpaceVectorLengthComparator implements Comparator<ISpaceVector> {

	
	@Override
	public int compare(ISpaceVector vec1, ISpaceVector vec2) {
		return compare(vec1, vec2, SpaceVector.ORIGIN);
	}

	public int compare(ISpaceVector vec1, ISpaceVector vec2, ISpaceVector origin) {
		float len1 = VectorUtils.getDistance(origin, vec1);
		float len2 = VectorUtils.getDistance(origin, vec2);				
		if(len1 < len2) {
			return -1;
		}
		else if(Math.abs(len1-len2) < 1E-5f) {
			return 0;
		}
		else {
			return 1;
		}		
	}
	
}
