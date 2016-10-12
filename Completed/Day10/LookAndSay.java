import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LookAndSay {
	
	private static String lsa = "1321131112"; //  11131221133112, 3113112221232112, 1321132132111213122112
	private static final String ONE = "([123])",
								TWO = "(11|22|33)",
								THREE = "(111|222|333)",
								ALL = THREE + "|" + TWO + "|" + ONE;

	public static void main(String args[]) {
		Pattern p = Pattern.compile(ALL);
		Matcher m;

		for (int i = 0; i < 50; i++) {
			m = p.matcher(lsa);
			lsa = nextSeq(m);
		}
		System.out.println(lsa.length());
	}

	private static String nextSeq(Matcher m) {
		StringBuilder build = new StringBuilder();

		while (m.find()) {
			String s = m.group();

			if (s.equals("111"))
				build.append("31");
			else if(s.equals("222"))
				build.append("32");
			else if (s.equals("333"))
				build.append("33");

			else if (s.equals("11"))
				build.append("21");
			else if(s.equals("22"))
				build.append("22");
			else if (s.equals("33"))
				build.append("23");

			else if (s.equals("1"))
				build.append("11");
			else if(s.equals("2"))
				build.append("12");
			else if (s.equals("3"))
				build.append("13");
		}
		return build.toString();
	}
}