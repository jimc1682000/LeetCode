package answer;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		ExcelSheetColumnNumber myMain = new ExcelSheetColumnNumber();
		String[] testCase = { "A", "B", "C", "X", "Y", "Z", "AA", "AB", "ZZ",
				"AAA", "AAB" };
		for (String str : testCase) {
			System.out.println(str + " Answer: " + myMain.titleToNumber(str));
			System.out.println(str + " Answer: " + myMain.bestAlgorithm(str));
		}
	}

	public int titleToNumber(String s) {
		if (s.isEmpty())
			return 0;
		int rtn = 0;
		for (int i = s.length() - 1; i >= 0; --i) {
			char theWord = s.charAt(i);
			int theNumber = getNumberFrom(theWord);
			rtn += Math.pow(26d, Double.valueOf("" + reverse(s.length(), i)))
					* theNumber;
		}
		return rtn;
	}

	private int getNumberFrom(char theWord) {
		// 為了要讓Z能夠正確顯示，需要另外做判斷
		return ((int) theWord - 64) == 26 ? 26 : (int) theWord - 64;
	}

	private int reverse(int length, int i) {
		return length - 1 - i;
	}

	// Ref: https://discuss.leetcode.com/topic/36499/my-2ms-java-solution/2
	public int bestAlgorithm(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result *= 26;
			result += ((s.charAt(i) - 'A') + 1);
		}

		return result;
	}
}
