public class NewPwd {
	
	private static char[] pwd1 = new char[]{'h','x','b','x','w','x','b','a'};
	private static char[] pwd = new char[]{'h','x','b','x','x','y','z','z'};
	// private static String pwd = "hxbxwxba";

	private static final int LEN = pwd.length;
	private static boolean test = false;

	public static void main(String[] args) {
		increment(LEN - 1);

		while (!isValid()) {
			if (test) { System.out.println(pwd); }
			increment(LEN - 1);
		}

		String newPwd = "";
		for (Character c: pwd) {
			newPwd = newPwd + c;
		}
		System.out.println("\nNext password is: " + newPwd);
	}

	private static boolean isValid() {
		if (hasConfusing()) {
			if (test) { System.out.println("ILLEGAL"); }
			return false;
		}
		if (!hasConsecutive()) {
			if (test) { System.out.println("FÖLJANDE"); }
			return false;
		}
		if (!hasPair()) {
			if (test) { System.out.println("PAR"); }
			return false;
		}

		return true;
	}

	private static boolean hasConsecutive() {
		// char[] newPwd = pwd.toCharArray();

			// Character prev = newPwd[i--];
			// Character current = newPwd[i];
			// Character next = newPwd[i++];

		for (int i = 1; i < LEN - 1; i++) {
			Character current = pwd[i];
			Character prev = pwd[i - 1];
			Character next = pwd[i + 1];
			
			if ((prev + 1 == current) && (next - 1 == current)) {
				if (test) { System.out.println("Consecutive: " + prev + current + next); }
				return true;
			}
		}
		return false;
	}

	private static boolean hasPair() {
		Character prev = pwd[0];
		int pairs = 0;
		for (int i = 1; i < LEN; i++) {
			if (prev == pwd[i]) {
				pairs++;
				if (pairs == 2) {
					return true;
				}
				else if (++i < LEN) {
					prev = pwd[i];
				}
				// if (i == LEN - 1 || !overlaps(i)) {
				// 	return true;
				// }
			}
			if (i + 1 < LEN) {
				prev = pwd[i];
			}
		}
		return false;
	}

	// private static boolean overlaps(int i) {
	// 	int count = 2;
	// 	for (; i < LEN - 1; i++) {
	// 		if (pwd[i] == pwd[i + 1]) {
	// 			count++;
	// 		}
	// 		if (count > 3) {
	// 			return true;
	// 		}
	// 	}
	// 	return false;
	// }

	private static boolean hasConfusing() {
		// int i = 0;
		// char[] forw = pwd.toCharArray();

		for (int i = 0; i < LEN; i++) {
			int j = pwd[i];
			// Om någon char matchar en illegal char
			if (j == 'i' || j == 'o' || j == 'l') {
				ffw(i); // Skickar index för illegal char
				return true;
			}
		}
		return false;
	}

	// Snabbspolare till där den "most valuable" charen är illegal
	// Är egentligen bara effektiv då den charen är på övre halvan
	private static void ffw(int i) {
		pwd[i]++; // Inkrementerar illegal char
		i++;
		//Sätter alla index efter illegal char till 'a'
		for (; i < LEN; i++) {
			pwd[i] = 'a';
		}
		return;
	}

	private static void increment(int index) {
		if (test) { System.out.println("tock"); }
		if (index == 0) {
			pwd[index] = 'a';
		}
		else if (pwd[index] == 'z') {
			pwd[index] = 'a';
			increment(index - 1);
		}
		else {
			pwd[index]++;
		}
	}
}