package info.agentviolet.hyperspace.model.space;

import java.util.ArrayList;

public class NameGenerator {
	ArrayList<String> pre = new ArrayList<String>(50);
	ArrayList<String> mid = new ArrayList<String>(50);
	ArrayList<String> sur = new ArrayList<String>(50);

	final private static char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'ä', 'ö', 'õ', 'ü', 'y' };
	final private static char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y' };

	private String fileName;

	/**
	 * Create new random name generator object. refresh() is automatically
	 * called.
	 * 
	 * @param fileName
	 *            insert file name, where syllables are located
	 * @throws IOException
	 */
	public NameGenerator() {
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

		pre.add("ael");
		pre.add("aer");
		pre.add("af");
		pre.add("ah");
		pre.add("al +v");
		pre.add("am");
		pre.add("ama");
		pre.add("an");
		pre.add("ang +v");
		pre.add("ansr +v");
		pre.add("ca");
		pre.add("cael");
		pre.add("dae +c");
		pre.add("dho");
		pre.add("eir");
		pre.add("en");
		pre.add("fi");
		pre.add("fir");
		pre.add("la");
		pre.add("seh");
		pre.add("sel");
		pre.add("ev");
		pre.add("fis");
		pre.add("hu");
		pre.add("ha");
		pre.add("gar");
		pre.add("gil");
		pre.add("ka");
		pre.add("kan");
		pre.add("ma");
		pre.add("mil");
		pre.add("me");
		pre.add("mu");
		pre.add("wo");
		pre.add("ya");
		pre.add("za");
		pre.add("zy");
		pre.add("mara");
		pre.add("mai +c");
		pre.add("lue +c");
		pre.add("ny");
		pre.add("she");
		pre.add("sum");
		pre.add("syl");
		mid.add("ae +c -c");
		mid.add("ael -c");
		mid.add("dar");
		mid.add("deth +v");
		mid.add("dre -v");
		mid.add("drim -v");
		mid.add("dul");
		mid.add("ean -c");
		mid.add("el");
		mid.add("emar");
		mid.add("hal");
		mid.add("ma -v");
		mid.add("iat -c");
		mid.add("mah");
		mid.add("ten");
		mid.add("que -v +c");
		mid.add("ria");
		mid.add("rail");
		mid.add("ther");
		mid.add("thus");
		mid.add("thi");
		mid.add("san");
		sur.add("ael -c");
		sur.add("dar");
		sur.add("deth");
		sur.add("dre");
		sur.add("drim");
		sur.add("dul");
		sur.add("ean -c");
		sur.add("el");
		sur.add("lar");
		sur.add("emar");
		sur.add("nes");
		sur.add("nin");
		sur.add("oth");
		sur.add("us");
		sur.add("hal");
		sur.add("iat");
		sur.add("mah");
		sur.add("go");
		sur.add("ten");
		sur.add("thar");
		sur.add("ther");
		sur.add("thus");
		sur.add("thi");
		sur.add("ran");
		sur.add("ath");
		sur.add("ess");
		sur.add("san");
		sur.add("yth");
		sur.add("las");
		sur.add("lian");
		sur.add("evar");

		if (containsConsFirst(sur) == false)
			throw new RuntimeException("Expecting \"suffix\" part starting with consonant, but there is none. You should add one, or remove requirement for one.. ");
	}

	private String upper(String s) {
		return s.substring(0, 1).toUpperCase().concat(s.substring(1));
	}

	private boolean containsConsFirst(ArrayList<String> array) {
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
		if (s.substring(1).contains("+v"))
			return true;
		else
			return false;
	}

	private boolean expectsConsonant(String s) {
		if (s.substring(1).contains("+c"))
			return true;
		else
			return false;
	}

	private boolean hatesPreviousVowels(String s) {
		if (s.substring(1).contains("-c"))
			return true;
		else
			return false;
	}

	private boolean hatesPreviousConsonants(String s) {
		if (s.substring(1).contains("-v"))
			return true;
		else
			return false;
	}

	private String pureSyl(String s) {
		s = s.trim();
		if (s.charAt(0) == '+' || s.charAt(0) == '-')
			s = s.substring(1);
		return s.split(" ")[0];
	}

	private boolean vowelFirst(String s) {
		return (String.copyValueOf(vowels).contains(String.valueOf(s.charAt(0)).toLowerCase()));
	}

	private boolean consonantFirst(String s) {
		return (String.copyValueOf(consonants).contains(String.valueOf(s.charAt(0)).toLowerCase()));
	}

	private boolean vowelLast(String s) {
		return (String.copyValueOf(vowels).contains(String.valueOf(s.charAt(s.length() - 1)).toLowerCase()));
	}

	private boolean consonantLast(String s) {
		return (String.copyValueOf(consonants).contains(String.valueOf(s.charAt(s.length() - 1)).toLowerCase()));
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
		int a = (int) (Math.random() * pre.size()); // TODO: check performance

		if (vowelLast(pureSyl(pre.get(a))))
			last = 1;
		else
			last = 2;

		if (syls > 2) {
			if (expectsVowel(pre.get(a))) {
				expecting = 1;
				if (containsVocFirst(mid) == false)
					throw new RuntimeException("Expecting \"middle\" part starting with vowel, " + "but there is none. You should add one, or remove requirement for one.. ");
			}
			if (expectsConsonant(pre.get(a))) {
				expecting = 2;
				if (containsConsFirst(mid) == false)
					throw new RuntimeException("Expecting \"middle\" part starting with consonant, " + "but there is none. You should add one, or remove requirement for one.. ");
			}
		} else {
			if (expectsVowel(pre.get(a))) {
				expecting = 1;
				if (containsVocFirst(sur) == false)
					throw new RuntimeException("Expecting \"suffix\" part starting with Vowel, " + "but there is none. You should add one, or remove requirement for one.. ");
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
				b[i] = (int) (Math.random() * mid.size());
				// System.out.println("exp "
				// +expecting+" VowelF:"+VowelFirst(mid.get(b[i]))+" syl: "+mid.get(b[i]));
			} while (expecting == 1 && vowelFirst(pureSyl(mid.get(b[i]))) == false || expecting == 2 && consonantFirst(pureSyl(mid.get(b[i]))) == false || last == 1 && hatesPreviousVowels(mid.get(b[i])) || last == 2 && hatesPreviousConsonants(mid.get(b[i])));

			expecting = 0;
			if (expectsVowel(mid.get(b[i]))) {
				expecting = 1;
				if (i < b.length - 3 && containsVocFirst(mid) == false)
					throw new RuntimeException("Expecting \"middle\" part starting with Vowel, " + "but there is none. You should add one, or remove requirement for one.. ");
				if (i == b.length - 3 && containsVocFirst(sur) == false)
					throw new RuntimeException("Expecting \"suffix\" part starting with Vowel, " + "but there is none. You should add one, or remove requirement for one.. ");
			}
			if (expectsConsonant(mid.get(b[i]))) {
				expecting = 2;
				if (i < b.length - 3 && containsConsFirst(mid) == false)
					throw new RuntimeException("Expecting \"middle\" part starting with consonant, " + "but there is none. You should add one, or remove requirement for one.. ");
				if (i == b.length - 3 && containsConsFirst(sur) == false)
					throw new RuntimeException("Expecting \"suffix\" part starting with consonant, " + "but there is none. You should add one, or remove requirement for one.. ");
			}
			if (vowelLast(pureSyl(mid.get(b[i]))) && allowVocs(mid) == false && syls > 3)
				throw new RuntimeException("Expecting \"middle\" part that allows last character of last syllable to be a Vowel, " + "but there is none. You should add one, or remove requirements that cannot be fulfilled.. the part used, was : \"" + mid.get(b[i]) + "\", which " + "means there should be a part available, that has \"-v\" requirement or no requirements for previous syllables at all.");

			if (consonantLast(pureSyl(mid.get(b[i]))) && allowCons(mid) == false && syls > 3)
				throw new RuntimeException("Expecting \"middle\" part that allows last character of last syllable to be a consonant, " + "but there is none. You should add one, or remove requirements that cannot be fulfilled.. the part used, was : \"" + mid.get(b[i]) + "\", which " + "means there should be a part available, that has \"-c\" requirement or no requirements for previous syllables at all.");
			if (i == b.length - 3) {
				if (vowelLast(pureSyl(mid.get(b[i]))) && allowVocs(sur) == false)
					throw new RuntimeException("Expecting \"suffix\" part that allows last character of last syllable to be a Vowel, " + "but there is none. You should add one, or remove requirements that cannot be fulfilled.. the part used, was : \"" + mid.get(b[i]) + "\", which " + "means there should be a suffix available, that has \"-v\" requirement or no requirements for previous syllables at all.");

				if (consonantLast(pureSyl(mid.get(b[i]))) && allowCons(sur) == false)
					throw new RuntimeException("Expecting \"suffix\" part that allows last character of last syllable to be a consonant, " + "but there is none. You should add one, or remove requirements that cannot be fulfilled.. the part used, was : \"" + mid.get(b[i]) + "\", which " + "means there should be a suffix available, that has \"-c\" requirement or no requirements for previous syllables at all.");
			}
			if (vowelLast(pureSyl(mid.get(b[i]))))
				last = 1;
			else
				last = 2;
		}

		int c;
		do {
			c = (int) (Math.random() * sur.size());
		} while (expecting == 1 && vowelFirst(pureSyl(sur.get(c))) == false || expecting == 2 && consonantFirst(pureSyl(sur.get(c))) == false || last == 1 && hatesPreviousVowels(sur.get(c)) || last == 2 && hatesPreviousConsonants(sur.get(c)));

		name = upper(pureSyl(pre.get(a).toLowerCase()));
		for (int i = 0; i < b.length - 2; i++) {
			name = name.concat(pureSyl(mid.get(b[i]).toLowerCase()));
		}
		if (syls > 1)
			name = name.concat(pureSyl(sur.get(c).toLowerCase()));
		return name;
	}
}
