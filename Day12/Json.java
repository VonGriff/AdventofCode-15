import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Json {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));

		Pattern p = Pattern.compile("-?\\d+"); // {(.[^}])*.?}
		Matcher m;
		String line;
		int count = 0;
		while ((line = buf.readLine()) != null) {
			m = p.matcher(line);
			while (m.find()) {
				if (m.group().matches("-\\d+")) {
					count += Integer.parseInt(m.group());
				}
				else if (m.group().matches("\\d+")) {
					count += Integer.parseInt(m.group());
				}
			}
		}
		System.out.println("\nSum: " + count);
	}
}