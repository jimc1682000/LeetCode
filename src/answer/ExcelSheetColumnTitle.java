package answer;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		ExcelSheetColumnTitle myMain = new ExcelSheetColumnTitle();
		for (int i = 1; i < 80; i++) {
			System.out.println(i + " Answer: " + myMain.convertToTitle(i));
		}
		System.out.println(704 + " Answer: " + myMain.convertToTitle(704));
	}

	public String convertToTitle(int n) {
		if (n == 0)
			return "";
		String rtnStr = "";
		rtnStr = get(n % 26) + rtnStr;
		while (n > 26) {
			// 為了要讓n=26的倍數時，不會直接變成BZ，所以要減1
			n = (n % 26 == 0 ? n / 26 - 1 : n / 26);
			rtnStr = get(n % 26) + rtnStr;
		}
		return rtnStr;
	}

	public String get(int n) {
		// 為了要讓是n=26的倍數時，還可以正常顯示，所以在可以整除時，改為26+64("Z")
		return "" + (char) (n % 26 == 0 ? 26 + 64 : n % 26 + 64);
	}
}
