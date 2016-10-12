import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WrappingPaper {

	private static ArrayList<Present> presents = new ArrayList<Present>();

	public static void main(String[] args) throws java.io.FileNotFoundException, java.io.IOException {
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));		
		Pattern p = Pattern.compile("[0-9]+");
		String line;
		
		while ((line = in.readLine()) != null) {
			Matcher m = p.matcher(line);
			addPresent(m);
		}

		int paper = 0;
		int ribbon = 0;

		for (Present pr: presents) {
			paper += pr.getArea();
			ribbon += pr.getLength();
		}
		System.out.println("\nWrapping area needed: " + paper +
						   "\nRibbon length needed: " + ribbon);
	}

	private static void addPresent(Matcher m) {
		int[] dim = new int[3];
		int index = 0;

		while (m.find()) {
			if (m.group().matches("[0-9]+")) {
				dim[index] = Integer.parseInt(m.group());
				index++;
			}
		}
		presents.add(new Present(dim[0], dim[1], dim[2]));
	}
}