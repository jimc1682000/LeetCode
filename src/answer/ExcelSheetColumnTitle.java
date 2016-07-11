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
			// ���F�n��n=26�����ƮɡA���|�����ܦ�BZ�A�ҥH�n��1
			n = (n % 26 == 0 ? n / 26 - 1 : n / 26);
			rtnStr = get(n % 26) + rtnStr;
		}
		return rtnStr;
	}

	public String get(int n) {
		// ���F�n���On=26�����ƮɡA�٥i�H���`��ܡA�ҥH�b�i�H�㰣�ɡA�אּ26+64("Z")
		return "" + (char) (n % 26 == 0 ? 26 + 64 : n % 26 + 64);
	}
}
