import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class RoboSanta {
	
	public static void main(String args[]) throws java.io.FileNotFoundException, java.io.IOException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));

		//En ArrayList i en ArraList av booleans för att få en matris
		//ArrayList<Boolean> bool = new ArrayList<Boolean>();
		boolean[][] santa = new boolean[4000][4000];
		boolean[][] robo = new boolean[4000][4000];
		int index = 2000, jindex = 2000;
		int rindex = 2000, rjindex = 2000;

		santa[index][jindex] = true;

		int read = 0;
		int turn = 0;
		while ((read = buf.read()) != -1) {
			if (turn % 2 == 0) {
				//Sätt positionen till vänster till true
				if (read == '<')
					index--;
				//Sätt positionen under till true
				else if (read == 'v')
					jindex++;
				//Sätt positionen till höger till true
				else if (read == '>')
					index++;
				//Sätt positionen till ovan till true
				else if (read == '^')
					jindex--;
				santa[index][jindex] = true;
			}
			else {
				//Sätt positionen till vänster till true
				if (read == '<')
					rindex--;
				//Sätt positionen under till true
				else if (read == 'v')
					rjindex++;
				//Sätt positionen till höger till true
				else if (read == '>')
					rindex++;
				//Sätt positionen till ovan till true
				else if (read == '^')
					rjindex--;
				santa[rindex][rjindex] = true;
			}
			turn++;
		}

		int count = 0;
		for (int i = 0; i < 4000; i++) {
			for (int j = 0; j < 4000; j++) {
				if (santa[i][j] == true)
					count++;
			}
		}
		System.out.println(count);
	}//<^v>

}