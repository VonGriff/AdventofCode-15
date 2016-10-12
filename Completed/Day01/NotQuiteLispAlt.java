import java.io.BufferedReader;
import java.io.FileReader;

public class NotQuiteLispAlt {
	
	public static void main(String args[]) throws java.io.FileNotFoundException, java.io.IOException {
		BufferedReader buf = new BufferedReader(new FileReader("input.txt"));

		int read = 0;
		int floor = 0;
		while ((read = buf.read()) != -1) {
			if (read == '(')
				floor++;
			if (read == ')')
				floor--;
		}
		System.out.println(floor);
	}
}