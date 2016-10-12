import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.MatchResult;

// import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

// import java.util.regex.Pattern;
// import java.util.regex.Matcher;

public class CrimeMachineRanges {

	private static final String name = "Sue \\d+:",
							    children = "children",
							    cats = "cats",
							    samoyeds = "samoyeds",
							    pomeranians = "pomeranians",
							    akitas = "akitas",
							    vizslas = "vizslas",
							    goldfish = "goldfish",
							   	trees = "trees",
							   	cars = "cars",
							   	perfumes = "perfumes";
    private static ArrayList<Sue> aunts = new ArrayList<Sue>();
    private static boolean test = false;
    private static Sue trueSue = new Sue("TrueSue", 3, 7, 2, 3, 0, 0, 5, 3, 2, 1);

    /*
     * Ska hitta tokens och placera värdena i rätt fält
     * Lägger till värden för kategorier till vardera Sue
     */
    private static void parse(MatchResult result) {
    	Sue sue = new Sue(result.group(1));
    	String cat;	//Vilken kategori
    	int catNum; //Antalet i kategorin
    	if (test) { System.out.println(result.group(1)); }
		for (int i = 2; i <= result.groupCount(); i+=2) {
			// if (test) { System.out.println(result.group(i)); System.out.println(result.group(i+1)); }
			catNum = Integer.parseInt(result.group(i+1));
			switch (cat = result.group(i)) {
				case children:
					sue.addChild(catNum);
					break;
				case cats:
					sue.addCat(catNum);
					break;
				case samoyeds:
					sue.addSamoyed(catNum);
					break;
				case pomeranians:
					sue.addPomeranian(catNum);
					break;
				case akitas:
					sue.addAkita(catNum);
					break;
				case vizslas:
					sue.addVizsla(catNum);
					break;
				case goldfish:
					sue.addFish(catNum);
					break;
				case trees:
					sue.addTree(catNum);
					break;
				case cars:
					sue.addCar(catNum);
					break;
				case perfumes:
					sue.addPerfume(catNum);
					break;
				default:
					break;
			}
		}
		aunts.add(sue);
    }
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(new File("input.txt"));

		while (sc.hasNextLine()) {
			sc.findInLine("(Sue \\d+): " + 
						  "(children|cats|samoyeds|pomeranians|akitas|vizslas" +
						  "|goldfish|trees|cars|perfumes): (\\d+), " + 
						  "(children|cats|samoyeds|pomeranians|akitas|vizslas" +
						  "|goldfish|trees|cars|perfumes): (\\d+), " + 
						  "(children|cats|samoyeds|pomeranians|akitas|vizslas" +
						  "|goldfish|trees|cars|perfumes): (\\d+)");
			parse(sc.match());
			sc.nextLine();
		}
		sc.close();
		compare();
	}

	// Jämför alla olika Sue med rätt Sue
	private static void compare() {
		// test = true;
		ArrayList<Sue> maybeTrueSue = new ArrayList<Sue>();
		int matches = 0;
		int[] a;
		for (Sue s: aunts) {
			a = new int[]{s.getChild(), s.getCat(), s.getSamoyed(), s.getPomeranian(), s.getAkita(), s.getVizsla(), s.getFish(), s.getTree(), s.getCar(), s.getPerfume() };
			if (test) { System.out.println(s.getName()); }
			if (a[0] >= 0 && a[0] == trueSue.getChild()) {
				matches++;
			}
			if (a[1] >= 0 && a[1] > trueSue.getCat()) {
				matches++;
			}
			if (a[2] >= 0 && a[2] == trueSue.getSamoyed()) {
				matches++;
			}
			if (a[3] >= 0 && a[3] < trueSue.getPomeranian()) {
				matches++;
			}
			if (a[4] >= 0 && a[4] == trueSue.getAkita()) {
				matches++;
			}
			if (a[5] >= 0 && a[5] == trueSue.getVizsla()) {
				matches++;
			}
			if (a[6] >= 0 && a[6] < trueSue.getFish()) {
				matches++;
			}
			if (a[7] >= 0 && a[7] > trueSue.getTree()) {
				matches++;
			}
			if (a[8] >= 0 && a[8] == trueSue.getCar()) {
				matches++;
			}
			if (a[9] >= 0 && a[9] == trueSue.getPerfume()) {
				matches++;
			}

			if (matches == 3) {
				System.out.println(s.getName());
				// break;
			}
			matches = 0;
		}
	}
}