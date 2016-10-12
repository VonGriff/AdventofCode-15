import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class NotQuiteLisp {

	public static void main(String[] args) throws java.io.IOException {
		System.out.println("Hello World!");
		System.out.println(readInput(System.in));
	}

	private static String readInput(InputStream f) throws java.io.IOException {
		//Reader stdin = new InputStreamReader(f);
		Scanner input = new Scanner(f);
		StringBuilder buf = new StringBuilder();
		//Queue<Character> input = new PriorityQueue<Character>(); 
		//char input[] = new char[2024];
		int read = 0;
		int loopnr = 0;
		while (input.hasNext()) {
			//Character.toLowerCase(input[read]);
			loopnr++;
			System.out.println(loopnr);
			buf.append(input.nextLine());
		}
		System.out.println(buf.toString());
		return buf.toString();
	}
}