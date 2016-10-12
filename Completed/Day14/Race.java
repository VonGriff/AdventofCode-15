import java.io.BufferedReader;
import java.io.FileReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;

public class Race {

	private static ArrayList<Reindeer> deers = new ArrayList<Reindeer>();
	
	public static void main(String args[]) throws java.io.IOException, java.io.FileNotFoundException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));

		Pattern p = Pattern.compile("\\d+");
		Matcher m;
		String line;
		while ((line = buf.readLine()) != null) {
			m = p.matcher(line);
			addDeers(m);
		}
		System.out.println("\nWinning distance is: " + race());
	}

	private static int race() {
		// Får alla renar att röra sig
		for (int i = 0; i < 2503; i++) {
			for (Reindeer r: deers)
				r.move();
		}
		int dist = 0;
		// Hittar längsta distansen
		for (Reindeer r: deers) {
			if (r.getPos() > dist)
				dist = r.getPos();
		}
		return dist;
	}

	private static void addDeers(Matcher m) {
		int index = 0;
		int[] num = new int[3];
	
		while (m.find()) {
			num[index] = Integer.parseInt(m.group());
			index ++;
		}
		deers.add(new Reindeer(num[0], num[1], num[2]));
	}
}