import java.io.BufferedReader;
import java.io.FileReader;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ReverseMatch { 

	private static final String ASCII = "\\\\x[0-9a-f]{2}",
								ESC = "\\\\.",
								CHAR = "[a-z]+",
								TOT = ASCII + "|" + ESC + "|" + CHAR;
	
	public static void main(String args[]) throws java.io.IOException, java.io.FileNotFoundException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));
		Pattern p = Pattern.compile(TOT);

		int diff = 0;
		String line;
		Matcher m;

		while ((line = buf.readLine()) != null) {
			m = p.matcher(line);

			while (m.find()) 
				diff += newString(m.group()) - codeChars(m.group());
			diff += 4; // Kompensation för basfallet med citat-tecknen
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

	private static int newString(String line) {

		if (line.matches(ASCII))
			return 5;
		else if (line.matches(ESC))
			return 4;
		else if (line.matches(CHAR))
			return line.length();

		return 0;
	}
}