import java.io.BufferedReader;
import java.io.FileReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaughtyNiceAlt {

	final static private String VOWELS = "(.*?[aeiuo].*?[aeiuo].*?[aeiuo].*)", //([aeiou])
						 TWICE = "([a-z])\\1", //Fungerar inte
						 NAUGHTY = "(ab|cd|pq|xy)";
						 //REGEX_MATCH = NAUGHTY + "|" + TWICE + "|" + VOWELS;

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
		int count = 0;
		/*Pattern p = Pattern.compile(REGEX_MATCH);
		Matcher m = p.matcher(line);*/

		//Terminerar om vi får en Naughty
		if (line.matches(NAUGHTY))
			return false;
		//Räknar varje vokal
		if (!line.matches(VOWELS))
			return false;
		if (!line.matches(TWICE))
		 	return false;
		
		//Om 3 eller fler vokaler samt har två efterföljande chars
		return true;
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