package answer;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters myMain = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println("" + myMain.lengthOfLongestSubstring("abcabcbb"));
		System.out.println("" + myMain.lengthOfLongestSubstring("bbbbb"));
		System.out.println("" + myMain.lengthOfLongestSubstring("pwwkew"));
		System.out.println("" + myMain.lengthOfLongestSubstring("bcbbb"));
		System.out.println("" + myMain.lengthOfLongestSubstring("dvdf"));
	}

	// Ref:
	// https://discuss.leetcode.com/topic/8232/11-line-simple-java-solution-o-n-with-explanation/2
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		// 儲存著每個不重覆字母的最新位置
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		// rightPointer會不斷的往右
		for (int rightPointer = 0, leftPointer = 0; rightPointer < s.length(); ++rightPointer) {
			// 確認是否含有該字母
			if (map.containsKey(s.charAt(rightPointer))) {
				// 有含該字母就將leftPointer指向最新值，也就往右走了
				leftPointer = Math.max(leftPointer,
						map.get(s.charAt(rightPointer)) + 1);
			}
			// 將目前得到該字母最新的位置放入MAP當中
			map.put(s.charAt(rightPointer), rightPointer);
			// 求出目前該字母得到的最長數值，與目前的MAX相比，大的放入MAX中
			max = Math.max(max, rightPointer - leftPointer + 1);
		}
		return max;
	}
}
