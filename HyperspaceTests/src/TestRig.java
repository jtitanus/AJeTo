import info.agentviolet.utils.Dice;

import java.text.DecimalFormat;
import java.util.Random;

@SuppressWarnings("unused")
public class TestRig {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int iterations = 1000*1000*1000;
		// priming...
		long t1 = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			payloadA();
			payloadB();
		}
		long t2 = System.nanoTime();

		// measuring...

		// A
		t1 = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			payloadA();
		}
		t2 = System.nanoTime();

		System.out.println("A : " + new DecimalFormat("###,###").format(t2 - t1));

		// B
		t1 = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			payloadB();
		}
		t2 = System.nanoTime();

		System.out.println("B : " + new DecimalFormat("###,###").format(t2 - t1));
		
	}

	// private static void payloadA() {
	// int a = (int) (Math.random() * 10);
	// }
	//
	// private static Random rnd = new Random();
	//
	// private static void payloadB() {
	// int a = Dice.rollInt(rnd, 10);
	// }
	/*
	 * A : 330.420.940 
	 * B : 183.916.054
	 */
	
	private static void payloadA() {
		float a = 1234f * 4324f / 2123f - 232345f * 0.4545f * (1234f * 4324f / 2123f - 232345f * 0.4545f) / (1234f * 4324f / 2123f - 232345f * 0.4545f * (1234f * 4324f / 2123f - 232345f * 0.4545f));
	}

	private static void payloadB() {
		double a = 1234d * 4324d / 2123d - 232345d * 0.4545d * (1234d * 4324d / 2123d - 232345d * 0.4545d) / (1234d * 4324d / 2123d - 232345d * 0.4545d * (1234d * 4324d / 2123d - 232345d * 0.4545d));
	}
	/*
	 * A : 282.463.942
	 * B : 282.805.931
	 */
}
