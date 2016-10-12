import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;

// import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Graph {

	private static final String CITY = "Faerun|Tristram|Tambi|" +
									   "Norrath|Snowdin|Straylight|AlphaCentauri";
	private static final String[] CITIIES = new String[]{"Faerun","Tristram","Tambi",
														 "Norrath","Snowdin",
														 "Straylight","AlphaCentauri"};
	// private static HashMap<String,Boolean> explored;
	private static ArrayList<Node> nodes = new ArrayList<Node>();
	private static Stack<Node> explored;

	public Graph() {

	}

	public static void main(String args[]) throws IOException, FileNotFoundException {
		init();
		dfs("Faerun"); // Startar vid en särskild nod
	}

	private static void dfs(String city) {
		setExplored(city);
		for (String s: CITIIES) {
			if (!explored.get(s)) {
				dfs(s);
			}
		}
		return;
	}

	private static void setExplored(String city) {
		// explored.put(city,true);
		explored.push(city);
	}

	// Will find and create every node from our input
	private static void init() {
		Scanner sc = new Scanner(new File("input.txt"));

		while (sc.hasNextLine()) {
			sc.findInLine(CITY + "|" + "\\d+");
			// initNodes(sc.match());
			checkResult(sc.match());
			sc.nextLine();
		}
	}

	// Makes sure we don't create already existing nodes
	private static void checkResult(MatchResult result) {
		int dist = Integer.parseInt(result.group(3));
		String node1 = result.group(1);
		String node2 = result.group(2);

		for (Node n: nodes) {
			// if ()
		}
		return;	
	}

	/**
	  * A class Node which should hold it's city name and
	  * a HashMap which holds the distance to it's respective
	  * neightbouring cities
	 **/
	private class Node {
		private String name;
		private HashMap<Node,Integer> distance;
		public Node(String name) {
			this.name = name;
		}
		private void addNeighbour(Node n, int i) {
			distance.put(n,i);
		}
		private String getName() {
			return name;
		}
	}
}