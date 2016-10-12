import java.io.BufferedReader;
import java.io.FileReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;

public class RaceTwoAlt {

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

		int dist = race();
		int points = 0;
		for (Reindeer r: deers) {
			if (r.getPoints() > points) {
				points = r.getPoints();
			}
		}

		System.out.println("\nWinning distance is: " + dist + 
						   "\nMost points: " + points);
	}

	private static int race() {
		int maxDist = 0;
		// Får alla renar att röra sig
		for (int i = 0; i < 2503; i++) {
			for (Reindeer r: deers) {
				r.move();

				if (r.getPos() > maxDist) {
					maxDist = r.getPos();
				}
			}
			setPoints(maxDist);
		}

		return maxDist;
	}

	private static void setPoints(int maxDist) {
		for (Reindeer r: deers) {
			if (r.getPos() == maxDist) {
				r.addPoint();
			}
		}
	}

	private static void addDeers(Matcher m) {
		int index = 0;
		int[] num = new int[3];
	
		while (m.find()) {
			num[index] = Integer.parseInt(m.group());
			index++;
		}
		deers.add(new Reindeer(num[0], num[1], num[2]));
	}
}

