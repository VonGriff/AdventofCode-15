import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DrunkElf {
	
	public static void main(String args[]) throws java.io.FileNotFoundException, java.io.IOException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));

		//En ArrayList i en ArraList av booleans för att få en matris
		//ArrayList<Boolean> bool = new ArrayList<Boolean>();
		boolean[][] bool = new boolean[4000][4000];
		int index = 2000, jindex = 2000;

		bool[index][jindex] = true;

		int read = 0;
		while ((read = buf.read()) != -1) {
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
			
			bool[index][jindex] = true;
		}

		int count = 0;
		for (int i = 0; i < 4000; i++) {
			for (int j = 0; j < 4000; j++) {
				if (bool[i][j] == true)
					count++;
			}
		}
		System.out.println(count);
	}//<^v>

}