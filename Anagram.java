/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.

		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakishspeller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"));// true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are  anagrams.");

		// Performs a stress test of randomAnagram
		String str = "123456789";
		Boolean pass = true;
		// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String temp1 = preProcess(str1);
		String temp2 = preProcess(str2);
		// checks if the strings have a different number of letters and returns a false
		// if true
		if (temp1 == temp2) {
			return true;
		}
		if (temp1.length() != temp2.length()) {
			return false;
		}
		// removes from temp2 all the characters it shares with temp1
		for (int i = 0; i < temp1.length(); i++) {
			char c = temp1.charAt(i);
			temp2 = destroy((temp2), c);
		}

		return (temp2 == "");
	}

	// Returns a string of the given string without the first time the given
	// character appers in the string
	public static String destroy(String str, char c) {
		String temp1 = "";
		if (str.indexOf(c) == -1) {
			return str;
		}
		for (int i = 0; i < str.length(); i++) {
			if (i != str.indexOf(c)) {
				temp1 += str.charAt(i);
			}

		}
		return temp1;
	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String ans = "";
		String temp = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			char c = temp.charAt(i);
			if (c >= 97 && c <= 122) {
				ans += c;
			}
		}
		return ans;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		String ans = "";
		String temp = str;
		while (temp != "") {
			int rnd = (int) (Math.random() * temp.length());
			ans += temp.charAt(rnd);
			temp = destroy(temp, temp.charAt(rnd));
		}

		return ans;
	}
}
