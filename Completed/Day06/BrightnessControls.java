import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.ArrayList;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BrightnessControls {

	private static final String NUM = "\\d{1,3}",
						 COORD = NUM + "," + NUM + "( )?",
						 TOGG = "toggle ",
						 ON = "turn on ",
						 OFF = "turn off ",
						 ARG = COORD + "through " + COORD;

	private static int lights[][] = new int[1000][1000];

	private static void parse(String line, int cmd) {
		Pattern p = Pattern.compile(NUM);
		Matcher m = p.matcher(line);

		ArrayList<Integer> coords = new ArrayList<Integer>();

		while(m.find()) {
			if (m.group().matches(NUM)) {
				coords.add(Integer.parseInt(m.group()));
			}
		}

		int si = coords.get(0), sj = coords.get(1),
			ei = coords.get(2), ej = coords.get(3);

		if (cmd == 0)
			toggle(si, sj, ei, ej);
		else if (cmd == 1)
			turnOn(si, sj, ei, ej);
		else if (cmd == 2)
			turnOff(si, sj, ei, ej);
		return;
	}

	public static void main(String args[]) throws IOException, FileNotFoundException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));

		int count = 0;
		String line;
		while ((line = buf.readLine()) != null) {

			if (line.matches(TOGG + ARG))
				parse(line, 0);
			else if (line.matches(ON + ARG))
				parse(line, 1);
			else if (line.matches(OFF + ARG))
				parse(line, 2);
		}

		for (int i = 0; i < lights.length; i++) {
			for (int j = 0; j < lights.length; j++) {
				count += lights[i][j];
			}
		}
		System.out.println("\nTotal brightness: " + count + "\n");
	}

	private static void toggle(int starti, int startj, int endi, int endj) {
		int i = starti, j = startj;

		while (i <= endi) {
			while (j <= endj) {
				lights[i][j] += 2;
				j++;
			}
			j = startj;
			i++;
		}
		return;
	}

	private static void turnOn(int starti, int startj, int endi, int endj) {
		int i = starti, j = startj;

		while (i <= endi) {
			while (j <= endj) {
				lights[i][j]++;
				j++;
			}

			j = startj;
			i++;
		}

		return;
	}

	private static void turnOff(int starti, int startj, int endi, int endj) {
		int i = starti, j = startj;

		while (i <= endi) {
			while (j <= endj) {
				if (lights[i][j] > 0)
				lights[i][j]--;
				j++;
			}
			j = startj;
			i++;
		}
		return;
	}
}