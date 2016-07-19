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
		// �x�s�ۨC�Ӥ����Цr�����̷s��m
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		// rightPointer�|���_�����k
		for (int rightPointer = 0, leftPointer = 0; rightPointer < s.length(); ++rightPointer) {
			// �T�{�O�_�t���Ӧr��
			if (map.containsKey(s.charAt(rightPointer))) {
				// ���t�Ӧr���N�NleftPointer���V�̷s�ȡA�]�N���k���F
				leftPointer = Math.max(leftPointer,
						map.get(s.charAt(rightPointer)) + 1);
			}
			// �N�ثe�o��Ӧr���̷s����m��JMAP��
			map.put(s.charAt(rightPointer), rightPointer);
			// �D�X�ثe�Ӧr���o�쪺�̪��ƭȡA�P�ثe��MAX�ۤ�A�j����JMAX��
			max = Math.max(max, rightPointer - leftPointer + 1);
		}
		return max;
	}
}
