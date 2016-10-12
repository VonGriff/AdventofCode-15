import java.io.BufferedReader;
import java.io.FileReader;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Matchsticks { // Svaret ligger mellan 5400 - 6000

	private static final String ASCII = "\\\\x[0-9a-f]{2}",
								ESC = "\\\\.",
								CHAR = "[a-z]+",
								TOT = ASCII + "|" + ESC + "|" + CHAR;
	
	public static void main(String args[]) throws java.io.IOException, java.io.FileNotFoundException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));

		// int codeChars = 0, memoryChars = 0;
		int diff = 0;
		String line;
		while ((line = buf.readLine()) != null) {
			// System.out.println(line);

			Pattern p = Pattern.compile(TOT);
			Matcher m = p.matcher(line);
			Matcher t = p.matcher(line);

			// codeChars += codeChars(m);
			// memoryChars += memoryChars(t);
			diff += codeChars(m) - memoryChars(t);
			// diff += countDiff(m); 

		}
		// diff = codeChars - memoryChars;
		System.out.println("\nDifferensen är: " + diff);
		// Räknar ut differensen mellan chars i koden och i minnet
		// int diff = codeChars - memoryChars;
		// System.out.println("\nChars in code: " + codeChars +
		// 				   "\nChars in memory: " + memoryChars +
		// 				   "\nDifference is: " + diff + "\n");
	}

	// TODO
	private static int codeChars(Matcher line) {
		int count = 0;

		while(line.find()) {
			System.out.println(line.group());
			if (line.group().matches(ASCII))
				count += 4;
			else if (line.group().matches(ESC))
				count += 2;
			else if (line.group().matches(CHAR))
				count += line.group().length();
		}

		// Adderar två
		count += 2;
		return count;
	}

	private static int memoryChars(Matcher line) {
		int count = 0;

		while(line.find()) {
			if (line.group().matches(ASCII))
				count++;
			else if (line.group().matches(ESC))
				count++;
			else if (line.group().matches(CHAR))
				count += line.group().length();
		}

		return count;
	}
}