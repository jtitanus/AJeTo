package info.agentviolet.hyperspace.model.space;

import info.agentviolet.utils.Dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class NameGenerator {
	private final String MINUS_V = "-v";
	private final String MINUS_C = "-c";
	private final String PLUS_C = "+c";
	private final String PLUS_V = "+v";
	private final ArrayList<String> pre = new ArrayList<String>(50);
	private final ArrayList<String> mid = new ArrayList<String>(50);
	private final ArrayList<String> sur = new ArrayList<String>(50);

	private final char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'ä', 'ö', 'õ', 'ü', 'y' };
	private final char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z' };

	private final Random rnd;
	/**
	 * Create new random name generator object. refresh() is automatically
	 * called.
	 * 
	 * @param fileName
	 *            insert file name, where syllables are located
	 * @throws IOException
	 */
	public NameGenerator(Random rnd) {
		this.rnd = rnd;
		init();
	}

	/**
	 * Refresh names from file. No need to call that method, if you are not
	 * changing the file during the operation of program, as this method is
	 * called every time file name is changed or new NameGenerator object
	 * created.
	 * 
	 * @throws IOException
	 */
	private void init() {

		getStarNamesInGalaxyFarFarAway();
		
//		getElvenNames();

		if (containsVocFirst(mid) == false)
			throw new RuntimeException("Expecting \"middle\" part starting with vowel, " + "but there is none. You should add one, or remove requirement for one.. ");
		if (containsConsFirst(mid) == false)
			throw new RuntimeException("Expecting \"middle\" part starting with consonant, " + "but there is none. You should add one, or remove requirement for one.. ");
		if (containsConsFirst(sur) == false)
			throw new RuntimeException("Expecting \"suffix\" part starting with consonant, but there is none. You should add one, or remove requirement for one.. ");
		if (containsVocFirst(sur) == false)
			throw new RuntimeException("Expecting \"suffix\" part starting with Vowel, " + "but there is none. You should add one, or remove requirement for one.. ");
		if (allowVocs(mid) == false)
			throw new RuntimeException("Expecting \"middle\" part that allows last character of last syllable to be a Vowel, but there is none. You should add one, or remove requirements that cannot be fulfilled..");
		if (allowCons(mid) == false)
			throw new RuntimeException("Expecting \"middle\" part that allows last character of last syllable to be a consonant, but there is none. You should add one, or remove requirements that cannot be fulfilled..");
		if (allowVocs(sur) == false)
			throw new RuntimeException("Expecting \"suffix\" part that allows last character of last syllable to be a Vowel, but there is none. You should add one, or remove requirements that cannot be fulfilled..");
		if (allowCons(sur) == false)
			throw new RuntimeException("Expecting \"suffix\" part that allows last character of last syllable to be a consonant, but there is none. You should add one, or remove requirements that cannot be fulfilled..");
	}


	private void getStarNamesInGalaxyFarFarAway() {
		pre.add("a +c");
		pre.add("ae +c");
		pre.add("b +v");
		pre.add("d +v");
		pre.add("j +v");
		pre.add("k +v");
		pre.add("l +v");
		pre.add("m +v");
		pre.add("n +v");
		pre.add("r +v");
		pre.add("s +v");
		pre.add("t +v");
		pre.add("x +v");
		pre.add("y +v");
		pre.add("z +v");
		pre.add("pul +v");
		pre.add("new +v");
		pre.add("never +v");
		mid.add("s +v");
		mid.add("che +v");
		mid.add("sche +c");
		mid.add("a +c");
		mid.add("e +c");
		mid.add("e +c");
		mid.add("i +c");
		mid.add("a +c");
		mid.add("e +c");
		mid.add("e +c");
		mid.add("i +c");
		mid.add("mi -c");
		mid.add("ma +c");		
		mid.add("na +c");
		mid.add("ra +c");
		mid.add("le +c");
		sur.add("al +c");
		sur.add("us");
		sur.add("ter");
		sur.add("er");
		sur.add("tun");
		sur.add("sol");
		sur.add("sar");
		sur.add("thi");
		sur.add("tus");
		sur.add("bi");
		sur.add("a +c");
		sur.add("ar +c");
		sur.add("l +v");
		sur.add("gh +v");
		sur.add("town");
		sur.add("lis");		
		sur.add("el +c");
	}

	private static String upper(String s) {
		return s.substring(0, 1).toUpperCase().concat(s.substring(1));
	}

	private  boolean containsConsFirst(ArrayList<String> array) {
		for (String s : array) {
			if (consonantFirst(s))
				return true;
		}
		return false;
	}

	private boolean containsVocFirst(ArrayList<String> array) {
		for (String s : array) {
			if (vowelFirst(s))
				return true;
		}
		return false;
	}

	private boolean allowCons(ArrayList<String> array) {
		for (String s : array) {
			if (hatesPreviousVowels(s) || hatesPreviousConsonants(s) == false)
				return true;
		}
		return false;
	}

	private boolean allowVocs(ArrayList<String> array) {
		for (String s : array) {
			if (hatesPreviousConsonants(s) || hatesPreviousVowels(s) == false)
				return true;
		}
		return false;
	}

	private boolean expectsVowel(String s) {
		if (s.substring(1).contains(PLUS_V))
			return true;
		else
			return false;
	}

	private boolean expectsConsonant(String s) {
		if (s.substring(1).contains(PLUS_C))
			return true;
		else
			return false;
	}

	private boolean hatesPreviousVowels(String s) {
		if (s.substring(1).contains(MINUS_C))
			return true;
		else
			return false;
	}

	private boolean hatesPreviousConsonants(String s) {
		if (s.substring(1).contains(MINUS_V))
			return true;
		else
			return false;
	}

	private static String pureSyl(String s) {
		//s = s.trim();
		if (s.charAt(0) == '+' || s.charAt(0) == '-')
			s = s.substring(1);
		return s.split(" ")[0];
	}

	private boolean vowelFirst(String s) {
		return Arrays.binarySearch(vowels, s.charAt(0)) >=0;
	}

	private boolean consonantFirst(String s) {
		return Arrays.binarySearch(consonants, s.charAt(0)) >=0;				
	}

	private boolean vowelLast(String s) {
		return Arrays.binarySearch(vowels, s.charAt(s.length() - 1)) >=0;				
	}

	private boolean consonantLast(String s) {
		return Arrays.binarySearch(consonants, s.charAt(s.length() - 1)) >=0;	
	}

	/**
	 * Compose a new name.
	 * 
	 * @param syls
	 *            The number of syllables used in name.
	 * @return Returns composed name as a String
	 * @throws RuntimeException
	 *             when logical mistakes are detected inside chosen file, and
	 *             program is unable to complete the name.
	 */
	public String compose(int syls) {
		// if (syls > 2 && mid.size() == 0)
		// throw new
		// RuntimeException("You are trying to create a name with more than 3 parts, which requires middle parts, "
		// + "which you have none in the file " + fileName +
		// ". You should add some. Every word, which doesn't have + or - for a prefix is counted as a middle part.");
		// if (pre.size() == 0)
		// throw new
		// RuntimeException("You have no prefixes to start creating a name. add some and use \"-\" prefix, to identify it as a prefix for a name. (example: -asd)");
		// if (sur.size() == 0)
		// throw new
		// RuntimeException("You have no suffixes to end a name. add some and use \"+\" prefix, to identify it as a suffix for a name. (example: +asd)");
		if (syls < 1)
			syls = 1;

		int expecting = 0; // 1 for Vowel, 2 for consonant
		int last = 0; // 1 for Vowel, 2 for consonant
		String name;
		int a = Dice.rollInt(rnd, pre.size()); 
		
		if (vowelLast(pureSyl(pre.get(a))))
			last = 1;
		else
			last = 2;

		if (syls > 2) {
			if (expectsVowel(pre.get(a))) {
				expecting = 1;				
			}
			if (expectsConsonant(pre.get(a))) {
				expecting = 2;				
			}
		} else {
			if (expectsVowel(pre.get(a))) {
				expecting = 1;				
			}
			if (expectsConsonant(pre.get(a))) {
				expecting = 2;
				if (containsConsFirst(sur) == false)
					throw new RuntimeException("Expecting \"suffix\" part starting with consonant, " + "but there is none. You should add one, or remove requirement for one.. ");
			}
		}
		if (vowelLast(pureSyl(pre.get(a))) && allowVocs(mid) == false)
			throw new RuntimeException("Expecting \"middle\" part that allows last character of prefix to be a Vowel, " + "but there is none. You should add one, or remove requirements that cannot be fulfilled.. the prefix used, was : \"" + pre.get(a) + "\", which" + "means there should be a part available, that has \"-v\" requirement or no requirements for previous syllables at all.");

		if (consonantLast(pureSyl(pre.get(a))) && allowCons(mid) == false)
			throw new RuntimeException("Expecting \"middle\" part that allows last character of prefix to be a consonant, " + "but there is none. You should add one, or remove requirements that cannot be fulfilled.. the prefix used, was : \"" + pre.get(a) + "\", which" + "means there should be a part available, that has \"-c\" requirement or no requirements for previous syllables at all.");

		int b[] = new int[syls];
		for (int i = 0; i < b.length - 2; i++) {

			do {
				b[i] = Dice.rollInt(rnd, mid.size());				
			} while (expecting == 1 && vowelFirst(pureSyl(mid.get(b[i]))) == false || expecting == 2 && consonantFirst(pureSyl(mid.get(b[i]))) == false || last == 1 && hatesPreviousVowels(mid.get(b[i])) || last == 2 && hatesPreviousConsonants(mid.get(b[i])));

			expecting = 0;
			if (expectsVowel(mid.get(b[i]))) {
				expecting = 1;				
			}
			if (expectsConsonant(mid.get(b[i]))) {
				expecting = 2;				
			}
			if (vowelLast(pureSyl(mid.get(b[i]))))
				last = 1;
			else
				last = 2;
		}

		int c;
		do {
			c = Dice.rollInt(rnd, sur.size());
		} while (expecting == 1 && vowelFirst(pureSyl(sur.get(c))) == false || expecting == 2 && consonantFirst(pureSyl(sur.get(c))) == false || last == 1 && hatesPreviousVowels(sur.get(c)) || last == 2 && hatesPreviousConsonants(sur.get(c)));

		name = upper(pureSyl(pre.get(a).toLowerCase()));
		for (int i = 0; i < b.length - 2; i++) {
			name = name.concat(pureSyl(mid.get(b[i]).toLowerCase()));
		}
		if (syls > 1)
			name = name.concat(pureSyl(sur.get(c).toLowerCase()));
		return name;
	}
	

//	private void getElvenNames() {
//		pre.add("ae +c");
//		pre.add("ael");
//		pre.add("aer");
//		pre.add("af");
//		pre.add("ah");
//		pre.add("al +v");
//		pre.add("am");
//		pre.add("ama");
//		pre.add("an");
//		pre.add("ang +v");
//		pre.add("ansr +v");
//		pre.add("ca");
//		pre.add("cael");
//		pre.add("dae +c");
//		pre.add("dho");
//		pre.add("eir");
//		pre.add("en");
//		pre.add("fi");
//		pre.add("fir");
//		pre.add("la");
//		pre.add("seh");
//		pre.add("sel");
//		pre.add("ev");
//		pre.add("fis");
//		pre.add("hu");
//		pre.add("ha");
//		pre.add("gar");
//		pre.add("gil");
//		pre.add("ka");
//		pre.add("kan");
//		pre.add("ma");
//		pre.add("mil");
//		pre.add("me");
//		pre.add("mu");
//		pre.add("wo");
//		pre.add("ya");
//		pre.add("za");
//		pre.add("zy");
//		pre.add("mara");
//		pre.add("mai +c");
//		pre.add("lue +c");
//		pre.add("ny");
//		pre.add("she");
//		pre.add("sum");
//		pre.add("syl");
//		mid.add("ae +c -c");
//		mid.add("ael -c");
//		mid.add("dar");
//		mid.add("deth +v");
//		mid.add("dre -v");
//		mid.add("drim -v");
//		mid.add("dul");
//		mid.add("ean -c");
//		mid.add("el");
//		mid.add("emar");
//		mid.add("hal");
//		mid.add("ma -v");
//		mid.add("iat -c");
//		mid.add("mah");
//		mid.add("ten");
//		mid.add("que -v +c");
//		mid.add("ria");
//		mid.add("rail");
//		mid.add("ther");
//		mid.add("thus");
//		mid.add("thi");
//		mid.add("san");
//		sur.add("ael -c");
//		sur.add("dar");
//		sur.add("deth");
//		sur.add("dre");
//		sur.add("drim");
//		sur.add("dul");
//		sur.add("ean -c");
//		sur.add("el");
//		sur.add("lar");
//		sur.add("emar");
//		sur.add("nes");
//		sur.add("nin");
//		sur.add("oth");
//		sur.add("us");
//		sur.add("hal");
//		sur.add("iat");
//		sur.add("mah");
//		sur.add("go");
//		sur.add("ten");
//		sur.add("thar");
//		sur.add("ther");
//		sur.add("thus");
//		sur.add("thi");
//		sur.add("ran");
//		sur.add("ath");
//		sur.add("ess");
//		sur.add("san");
//		sur.add("yth");
//		sur.add("las");
//		sur.add("lian");
//		sur.add("evar");
//	}
}
