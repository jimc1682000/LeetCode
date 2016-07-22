package answer;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static void main(String[] args) {
		HappyNumber myMain = new HappyNumber();
		for (int i = 1; i < 10; i++) {
			System.out.println("Happy: " + i + ": " + myMain.isHappy(i) + " ");
			System.out
					.println("Happy2: " + i + ": " + myMain.isHappy2(i) + " ");
		}
	}

	public boolean isHappy(int n) {
		// 小於0就直接回FALSE
		if (n < 0) {
			return false;
		}
		// 大於10才去算，要不然就直接查是否是HAPPY NUMBER
		while (n > 9) {
			// 抓出SUM放到N中
			n = getSum(n);
		}
		return isHappyNumber(n);
	}

	private Integer getSum(Integer num) {
		Integer sum = 0;
		// 把數字轉成CHAR陣列後一個一個讀取並算出SUM
		for (Character eachChar : num.toString().toCharArray()) {
			Double eachNum = Double.valueOf(eachChar.toString());
			if (eachNum.intValue() != 0) {
				sum += (int) Math.pow(eachNum, 2d);
			}
		}
		return sum;
	}

	private boolean isHappyNumber(Integer num) {
		switch (num) {
		case 0:
			return false;
		case 1:
			return true;
		case 2:
			return false;
		case 3:
			return false;
		case 4:
			return false;
		case 5:
			return false;
		case 6:
			return false;
		case 7:
			return true;
		case 8:
			return false;
		case 9:
			return false;
		default:
			return false;
		}
	}

	// Ref:
	// https://discuss.leetcode.com/topic/25026/beat-90-fast-easy-understand-java-solution-with-brief-explanation/6
	public boolean isHappy2(int n) {
		// 用HASHSET來確認是否進入LOOP裡面
		Set<Integer> inLoop = new HashSet<Integer>();
		int squareSum, remain;
		while (inLoop.add(n)) {
			squareSum = 0;
			// 求得最新的REMAIN和SQUARESUM
			while (n > 0) {
				remain = n % 10;
				squareSum += remain * remain;
				n /= 10;
			}
			if (squareSum == 1)
				return true;
			else
				n = squareSum;
		}
		// 跳出WHILE迴圈代表進入了LOOP中，回傳FALSE
		return false;
	}
}
