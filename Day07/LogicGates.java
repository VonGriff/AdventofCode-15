import java.io.BufferedReader;
import java.io.FileReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.HashMap;
import java.util.ArrayList;

public class LogicGates {

	private static HashMap<String, Integer> wire;
	private static HashMap<String, ArrayList<String>> isConnectedTo;
	private static final String NUM = "\\d+",
								OP = "(AND|OR|RSHIFT|LSHIFT)",
								WIRE = "[a-z]{1,2}";

	public static void main(String[] args) throws java.io.FileNotFoundException, java.io.IOException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));

		wire = new HashMap<String, Integer>();
		isConnectedTo = new HashMap<String, ArrayList<String>>();

	// 	Pattern p = Pattern.compile(NUM + "|" + WIRE + "|" + OP);
	// 	Matcher m;
	// 	String line;
	// 	while ((line = buf.readLine()) != null) {
	// 		m = p.matcher(line);
	// 		if (line.matches(NUM + " -> " + WIRE)) {
	// 			provide(line, m);
	// 		}
	// 		else if (line.matches(WIRE + OP + WIRE + " -> " + WIRE)) {
	// 			operate(line, m);
	// 		}
	// 		else if (line.matches("NOT " + WIRE + " -> " + WIRE)) {
	// 			not(line);
	// 		}
	// 	}
	// }

	// private static void provide(String line, Matcher m) {
	// 	int signal = Integer.parseInt(m.find().group());
	// 	String wire = m.find().group();
	// }

	// private static void operate(String line, Matcher m) {

	// }

	// private static void not(String line) {

	}
}