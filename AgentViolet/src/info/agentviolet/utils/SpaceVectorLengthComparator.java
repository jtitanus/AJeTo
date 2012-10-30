package info.agentviolet.utils;

import info.agentviolet.model.ISpaceVector;

import java.util.Comparator;

public class SpaceVectorLengthComparator implements Comparator<ISpaceVector> {

	@Override
	public int compare(ISpaceVector vec1, ISpaceVector vec2) {
		float len1 = VectorUtils.getVectorLength(vec1);
		float len2 = VectorUtils.getVectorLength(vec2);				
		if(len1 < len2) {
			return -1;
		}
		else if(Math.abs(len1-len2) < 0.00001f) {
			return 0;
		}
		else {
			return 1;
		}		
	}

}
