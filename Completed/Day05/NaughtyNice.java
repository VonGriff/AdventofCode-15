import java.io.BufferedReader;
import java.io.FileReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaughtyNice {

	final static private String VOWELS = "([aeiou])", //(.*[aeiuo].*[aeiuo].*[aeiuo].*)
						 // TWICE = "(([a-z])$1)",
						 NAUGHTY = "(ab|cd|pq|xy)",
						 REGEX_MATCH = NAUGHTY /*+ "|" + TWICE*/ + "|" + VOWELS;

	public static void main(String args[]) throws java.io.IOException, java.io.FileNotFoundException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));

		String line;
		int count = 0;
		while ((line = buf.readLine()) != null) {
			//Do stuff
			if (isNiceString(line))
				count++;
		}
		System.out.println(count);
	}

	/**
	 * Ska utvärdera de 3 kraven för strängen
	 */
	private static boolean isNiceString(String line) {
		//boolean validVowel = false;
		//boolean validTwice = false;
		int count = 0;
		Pattern p = Pattern.compile(REGEX_MATCH);
		Matcher m = p.matcher(line);

		while (m.find()) {
			//Terminerar om vi får en Naughty
			if (m.group().matches(NAUGHTY))
				return false;
			//Räknar varje vokal
			if (m.group().matches(VOWELS))
				count++; //validVowel = true;
			/*if (hasTwice(line))
				validTwice = true;*/
		}
		//Om 3 eller fler vokaler samt har två efterföljande chars
		if (count > 2 && hasTwice(line))
			return true;
		return false;
	}

	// Funktion för att ta reda på om två efterföljande chars är samma
	private static boolean hasTwice(String line) {
		char twice[] = line.toCharArray();
		Character prev = twice[0];

		for (int i = 1; i < twice.length; i++) {
			if (prev == twice[i])
				return true;
			else
				prev = twice[i];
		}

		return false;
	}
}