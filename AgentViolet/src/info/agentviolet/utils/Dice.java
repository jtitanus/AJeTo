package info.agentviolet.utils;

import java.util.Random;

public class Dice {
	
	/**
	 * Usage: specify a sorted list of tuples in form <probability, occurrence>
	 * Specify the least probable occurence first. 
	 * Max probability is 100.  
	 * @param occurences
	 * @return The rolled result. 
	 */
	public static Object roll(Object[] occurrences, Random rnd) {
		Object retval = null;
		int rolledResult = Math.abs(rnd.nextInt()) % 100;
		for(int i= 0; i<occurrences.length; i++) {			
			if(rolledResult <= (int)occurrences[i]){				
				retval = occurrences[i+1];
				break;
			}
			i++;
		}
		return retval==null? occurrences[occurrences.length-1] : retval;
	}
	
	public static int rollInt(Random rnd, int max) {
		return Math.abs(rnd.nextInt()) % max;
	}
}
