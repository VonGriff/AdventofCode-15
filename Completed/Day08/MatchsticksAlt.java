import java.io.BufferedReader;
import java.io.FileReader;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MatchsticksAlt { 

	private static final String ASCII = "\\\\x[0-9a-f]{2}",
								ESC = "\\\\.",
								CHAR = "[a-z]+",
								TOT = ASCII + "|" + ESC + "|" + CHAR;
	
	public static void main(String args[]) throws java.io.IOException, java.io.FileNotFoundException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));

		int diff = 0;
		String line;
		while ((line = buf.readLine()) != null) {

			Pattern p = Pattern.compile(TOT);
			Matcher m = p.matcher(line);

			while (m.find()) {
				String s = m.group();
				diff += codeChars(s) - memoryChars(s);
			}
			diff += 2;
		}

		System.out.println("\nDifferensen är: " + diff);
	}

	private static int codeChars(String line) {

		if (line.matches(ASCII))
			return 4;
		else if (line.matches(ESC))
			return 2;
		else if (line.matches(CHAR))
			return line.length();

		return 0;
	}

	private static int memoryChars(String line) {

		if (line.matches(ASCII))
			return 1;
		else if (line.matches(ESC))
			return 1;
		else if (line.matches(CHAR))
			return line.length();

		return 0;
	}
}