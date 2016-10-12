import java.io.BufferedReader;
import java.io.FileReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BetterModel {

	private static boolean test = true;

	public static void main(String args[]) throws java.io.IOException, java.io.FileNotFoundException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));

		char[] line;
		String l;
		int count = 0;
		while ((l = buf.readLine()) != null) {
			int i = 0;
			line = l.toCharArray();
			if (test) { System.out.println("Sträng"); }
			//Do stuff
			if (isNiceString(line))
				count++;
		}
		System.out.println(count);
	}

	/**
	 * Ska utvärdera kraven för strängen
	 */
	private static boolean isNiceString(char[] line) {
		if (!seperate(line))
			return false;
		if (!hasTwice(line))
			return false;

		return true;
	}

	private static boolean hasTwice(char[] line) {
		// char twice[] = line.toCharArray();
		if (test) { System.out.println("TWICE"); }
		char no1; // Första charen som ska jämföras
		char no2; // Andra charen som ska jämföras
		int count;

		for (int i = 0; i+3 < line.length; i++) {
			no1 = line[i];
			no2 = line[i+1];

			int l = i+3;
			char j; //index 1 över no2
			char k; // index 2 över no2

			count = 0;
			while (l < line.length) {
				j = line[l-1];
				k = line[l];
				if (j == no1 && k == no2) {
					return true;
				}
				l++;
			}
		}
		return false;
	}

	//Checkar ifall det finns två identiska chars separerade av en char
	private static boolean seperate(char[] line) {
		if (test) { System.out.println("SEP"); }
		char prev = line[0];
		for (int i = 2; i < line.length; i++) {
			if (line[i] == prev) {
				return true;
			}
			prev = line[i - 1];
		}
		return false;
	}
}