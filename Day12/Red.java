import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.LinkedList;

public class Red {

	private static final String NUM = "-?\\d+",
								LCURL = "\\{",
								RCURL = "\\}",
								LBRACK = "\\[",
								RBRACK = "\\]",
								RED = "\\{.*[^\\{\\}]red"; // "\\{(.[^\\}\\{])*?red";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));

		// Pattern p = Pattern.compile(RED + "|" + "red" + LCURL + "|" + RCURL + "|" + NUM); // {(.[^}])*.?}
		Pattern p = Pattern.compile("red|" + LCURL + "|" + RCURL + "|" +
									 LBRACK + "|" + RBRACK + "|" + NUM);
		Matcher m;
		String line;
		int count = 0;
		while ((line = buf.readLine()) != null) {
			m = p.matcher(line);
			while (m.find()) {
				if (m.group().matches(NUM)) {
					count += Integer.parseInt(m.group());
				}
				// else if (m.group().matches("\\d+")) {
				// 	count += Integer.parseInt(m.group());
				// }
				else if (m.group().matches(LCURL)) {
					count += searchRed(m);
				}
			}
		}
		System.out.println("\n" + count);
	}

	// Letar efter "red" i objekt
	private static int searchRed(Matcher m) {
		int count = 0;
		String tmp;

		while (m.find()) {
			tmp = m.group();
			if (tmp.matches("red")) {
				ffw(m);
				break;
			}
			else if (tmp.matches(LBRACK)) {
				count += ignoreRed(m);
			}
			else if (tmp.matches(LCURL)) {
				count += searchRed(m);
			}
			else if (tmp.matches(NUM)) {
				count += Integer.parseInt(tmp);
			}
			else if (tmp.matches(RCURL)) {
				return count;
			}
		}
		return 0;
	}

	// Räknar alla tal i arrays, även dem som innehåller "red"
	private static int ignoreRed(Matcher m) {
		int count = 0;
		int nested = 0;
		m.find();
		String tmp = m.group();
		
		while (!tmp.matches(RBRACK) || nested > 0) {
			if (tmp.matches(LCURL)) {
				count += searchRed(m);
			}
			else if (tmp.matches(NUM)) {
				count += Integer.parseInt(tmp);
			}
			else if (tmp.matches(LBRACK)) {
				nested++;
			}
			else if (tmp.matches(RBRACK)) {
				nested--;
			}
			m.find();
			tmp = m.group();
		}
		return count;
	}

	// Snabbspolar fram till objektet m barn innehållande "red" slutar
	private static void ffw(Matcher m) {
		int nested = 0;
		m.find();
		String tmp = m.group();

		while (!tmp.matches(RCURL) || nested > 0) {
			if (tmp.matches(LCURL)) {
				nested++;
			}
			else if (tmp.matches(RCURL)) {
				nested--;
			}
			m.find();
			tmp = m.group();
		}
		return;
	}
}