package answer;


public class TwoSum {
	// [3,2,4]
	// 6
	// [0,4,3,0]
	// 0
	public static void main(String[] args) {
		TwoSum myMain = new TwoSum();
		for (Integer i : myMain.twoSum(new int[] { 3, 2, 4 }, 6)) {
			System.out.print(i + " ");
		}
		System.out.println("");
		for (Integer i : myMain.twoSum(new int[] { 0, 4, 3, 0 }, 0)) {
			System.out.print(i + " ");
		}
	}

	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (getTargetIndex(nums, target - num, i) != -1) {
				return new int[] { i, getTargetIndex(nums, target - num, i) };
			}
		}
		return new int[] { 0, 0 };
	}

	public int getTargetIndex(int[] nums, Integer target, Integer exceptIndex) {
		for (int i = 0; i < nums.length; i++) {
			if (i == exceptIndex) {
				continue;
			}
			if (nums[i] == target) {
				return i;
			}
		}
		// 找不到，回傳-1
		return -1;
	}
}
