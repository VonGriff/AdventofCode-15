import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CrimeMachine {

	private final String   name = "Sue \\d+:",
						   children = "children: \\d+",
						   cats = "cats: \\d+",
						   samoyeds = "samoyeds: \\d+",
						   pomeranians = "pomeranians: \\d",
						   akitas = "akitas: \\d+",
						   vizslas = "vizslas: \\d+",
						   goldfish = "goldfish: \\d+",
						   trees = "trees: \\d+",
						   cars = "cars: \\d+",
						   perfumes = "perfumes: \\d+";
    private static ArrayList<Sue> aunts = new ArrayList<Sue>();
	
	public void main(String[] args) throws java.io.FileNotFoundException, java.io.IOException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));

		Pattern p = new Pattern
	}
}