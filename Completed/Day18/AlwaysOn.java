import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.Stack;

public class AlwaysOn {

	private static char[][] lights = new char[100][100];
	private static Stack<Character> animate = new Stack<Character>();
	private static boolean test = true;
	private static final String UPPER = "Upper",
								LOWER = "Lower",
								LEFT = "Left",
								RIGHT = "Right",
								LUPPER = "LeftUpper",
								LLOWER = "LeftLower",
								RUPPER = "RightUpper",
								RLOWER = "RightLower";

	private static void parse(String line, int i) {
		Pattern p = Pattern.compile("[.#]");
		Matcher m = p.matcher(line);
		int j = 0;
		while (m.find()) {
			// if (test) { System.out.println(m.group()); }
			lights[i][j] = m.group().charAt(0);
			// animate[i][j] = m.group().charAt(0);
			j++;
		}
	} 

	public static void main(String[] args) throws java.io.FileNotFoundException, java.io.IOException {
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		String line;
		int i = 0;
		// int j;
		// Parsar hela matrisen
		while ((line = in.readLine()) != null) {
			// j = 0; // Återställer kolumnerna i matrisen varje loop
			parse(line, i);
			i++;
		}


		// Animera antal steps innan vi räknar tända lampor
		for (int k = 0; k < 100; k++) {
			//TODO
			if (test) { System.out.println("hej"); }
			checkGrid();
			animate();
		}
		System.out.println("Antal tända lampor: " + count());
	}

	private static void checkGrid() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				int isOn = checkNeighbours(i,j);
				if (lights[i][j] == '.') {
					if (isOn == 3) {
						animate.push('#');
					}
					else {
						animate.push('.');
					}
				}
				else if (lights[i][j] == '#') {
					if (isOn == 2 || isOn == 3) {
						animate.push('#');
					}
					else {
						animate.push('.');
					}
				}
			}
		}
		return;
	}

	// Kollar en lampas omkringliggande lampor
	// Den här metoden blir hemsk...
	private static int checkNeighbours(int i, int j) {
		//TODO
		char h = '#';
		int isOn = 0;
		String locate = checkLocation(i,j);
		char nw,
			 n,
			 ne,
			 w,
			 e,
			 sw,
			 s,
			 se;

		switch (locate) {
			case LUPPER:
				isOn = 3;
				break;
			case LLOWER:
				isOn = 3;
				break;
			case LEFT:
				n = lights[i-1][j];
			 ne = lights[i-1][j+1];
			 e = lights[i][j+1];
			 s = lights[i+1][j];
			 se = lights[i+1][j+1];
				if (n == h) {
					isOn++;
				}
				if (ne == h) {
					isOn++;
				}
				if (e == h) {
					isOn++;
				}
				if (s == h) {
					isOn++;
				}
				if (se == h) {
					isOn++;
				}
				break;
			case RUPPER:
				isOn = 3;
				break;
			case RLOWER:
				isOn = 3;
				break;
			case RIGHT:
				nw = lights[i-1][j-1];
			 n = lights[i-1][j];
			 w = lights[i][j-1];
			 sw = lights[i+1][j-1];
			 s = lights[i+1][j];
				if (nw == h) {
					isOn++;
				}
				if (n == h) {
					isOn++;
				}
				if (w == h) {
					isOn++;
				}
				if (sw == h) {
					isOn++;
				}
				if (s == h) {
					isOn++;
				}
				break;
			case UPPER:
				w = lights[i][j-1];
			 e = lights[i][j+1];
			 sw = lights[i+1][j-1];
			 s = lights[i+1][j];
			 se = lights[i+1][j+1];
				if (w == h) {
					isOn++;
				}
				if (e == h) {
					isOn++;
				}
				if (sw == h) {
					isOn++;
				}
				if (s == h) {
					isOn++;
				}
				if (se == h) {
					isOn++;
				}
				break;
			case LOWER:
				nw = lights[i-1][j-1];
			 n = lights[i-1][j];
			 ne = lights[i-1][j+1];
			 w = lights[i][j-1];
			 e = lights[i][j+1];
				if (nw == h) {
					isOn++;
				}
				if (n == h) {
					isOn++;
				}
				if (ne == h) {
					isOn++;
				}
				if (w == h) {
					isOn++;
				}
				if (e == h) {
					isOn++;
				}
				break;
			default:
				nw = lights[i-1][j-1];
			 n = lights[i-1][j];
			 ne = lights[i-1][j+1];
			 w = lights[i][j-1];
			 e = lights[i][j+1];
			 sw = lights[i+1][j-1];
			 s = lights[i+1][j];
			 se = lights[i+1][j+1];
				if (nw == h) {
					isOn++;
				}
				if (n == h) {
					isOn++;
				}
				if (ne == h) {
					isOn++;
				}
				if (w == h) {
					isOn++;
				}
				if (e == h) {
					isOn++;
				}
				if (sw == h) {
					isOn++;
				}
				if (s == h) {
					isOn++;
				}
				if (se == h) {
					isOn++;
				}
				break;
		}

		return isOn;
	}

	private static String checkLocation(int i, int j) {
		//TODO
		// String pos = "";
		if (j-1 < 0) {
			if (i-1 < 0) {
				if (test) { System.out.println("LUpper" + i + j); }
				return LUPPER;
			}
			if (i+1 == 100) {
				return LLOWER;
			}
			else {
				if (test) { System.out.println("Vänster" + i + j);}
				return LEFT;
			}
		}
		if (j+1 == 100) {
			if (i-1 < 0) {
				return RUPPER;
			}
			if (i+1 == 100) {
				return RLOWER;
			}
			return RIGHT;
		}
		if (i-1 < 0) {
			return UPPER;
		}
		if (i+1 == 100) {
			return LOWER;
		}
		if (test) { System.out.println("Tomt"); }
		return "";
	}

	// Ska animera alla lampor så de tänds och släcks
	private static void animate() {
		//TODO
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				lights[i][j] = animate.pop();
			}
		}
	}

	// private static char turnOn() {
	// 	return '#';
	// }

	// private static char turnOff() {
	// 	return '.';
	// }

	private static int count() {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (lights[i][j] == '#') {
					count++;
				}
			}
		}
		return count;
	}
}