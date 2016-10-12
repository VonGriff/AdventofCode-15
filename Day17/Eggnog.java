import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Stack;

public class Eggnog {
	
	private static int[] cont = new int[20];

	/*
	 *Ska addera som matchar 100, varken över eller under 
	 *samt hur många olika kombinationer detta ger.
	 */
	public static void main(String[] args) throws java.io.FileNotFoundException, java.io.IOException {
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));

		boolean test = false;
		String num;
		int i = 0;

		while((num = in.readLine()) != null) {
			cont[i] = Integer.parseInt(num);
		}

		if (test) { System.out.println("Nummer inlästa"); }

		int sum = 0;
		int comb = 0;
		Stack<Integer> usedI = new Stack<Integer>(); // använt index
		int u = 0; // Index för used
		boolean loop = true;

		for (i = 0; i < cont.length; i++) { //Bastalet
			sum = cont[i];
			usedI.push(i);
			for (int j = i + 1; j < cont.length; j++) { // Alla tal upp till 100 med bastalet
				sum += cont[j];
				if (sum == 100) { // Öka antalet kombinationer, subtrahera och gå till nästa element
					comb++;
					sum -= cont[j];
					usedI.pop();
				}
				else if (sum > 100) { // Subtrahera och gå till nästa element
					sum -= cont[j];
					usedI.pop();
					// subtrahera senaste tal och gå vidare till nästa index
				}
				else {
					usedI.push(j);
				}
			}
		}

		System.out.println("Number of combinations: " + comb);
	}

	// private static boolean count() {
	// 	return false;
	// }
}