import java.io.BufferedReader;
import java.io.FileReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;

public class RaceTwo { // Denna är fel, RaceTwoAlt blev rätt

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
		// Reindeer deer = deers.get(0);
		// for (int i = 1; i < deers.size(); i++) {
		// 	Reindeer r = deers.get(i);
		// 	if (r.getPoints() > deer.getPoints())
		// 		deer = r;
		// }

		int dist = race();
		int points = 0;
		for (Reindeer r: deers) {
			if (r.getPoints() > points)
				points = r.getPoints();
		}

		System.out.println("\nWinning distance is: " + dist + 
						   "\nMost points: " + points);
	}

	private static int race() {
		Reindeer deer = deers.get(0);
		// Får alla renar att röra sig
		for (int i = 0; i < 2503; i++) {
			//deer.move();
			for (int j = 1; j < deers.size(); j++) {
				Reindeer r = deers.get(j);
				r.move();
				if (r.getPos() > deer.getPos())
					deer = r;
			}
			setPoint(deer);
		}
		int dist = 0;
		// Hittar längsta distansen
		for (Reindeer r: deers) {
			if (r.getPos() > dist)
				dist = r.getPos();
		}
		return dist;
	}

	private static void setPoint(Reindeer deer) {
		// Reindeer r;
		for (Reindeer r: deers) {
			if (r.getPos() == deer.getPos() && r != deer) {
				r.addPoint();
				System.out.println(r.getPoints());
			}
		}
		deer.addPoint();
		System.out.println(deer.getPoints());
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