/**
 * Created by VonGriff on 2015-12-03.
 */

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class NotQuiteLisp {

    public NotQuiteLisp(){}

    public static void main(String[] args) throws java.io.IOException {
        System.out.println("Hello World!");
        //System.out.println(readInput(System.in));
    }

    /*private static String readInput(InputStream f) throws java.io.IOException {
        Reader stdin = new InputStreamReader(f);
        StringBuilder buf = new StringBuilder();
        //Queue<Character> input = new PriorityQueue<Character>();
        char input[] = new char[1024];
        int read = 0;
        while ((read = stdin.read(input)) != -1) {
            //Character.toLowerCase(input[read]);
            buf.append(input, 0, read);
        }
        return buf.toString();
    }*/
}
