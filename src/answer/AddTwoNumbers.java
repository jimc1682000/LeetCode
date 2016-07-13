package answer;

public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		AddTwoNumbers myMain = new AddTwoNumbers();
		System.out.println(myMain.getVals(myMain.addTwoNumbers(
				myMain.build(2, 4, 3), myMain.build(5, 6, 4))));
		System.out.println(myMain.getVals(myMain.addTwoNumbers(myMain.build(5),
				myMain.build(5))));
	}

	public String getVals(ListNode node) {
		String rtnStr = "";
		ListNode tmpNode = node;
		while (tmpNode != null) {
			rtnStr = rtnStr + String.valueOf(tmpNode.val) + " ";
			tmpNode = tmpNode.next;
		}
		return rtnStr;
	}

	public ListNode build(Integer... nums) {
		// ミ安繷パ硂娩秨﹍穨琌安繷ㄏノ肈ヘいぃ穦瞷-1ボ
		ListNode fakeHead = new ListNode(-1);
		// рЮぺ竚安繷
		ListNode tail = fakeHead;
		for (Integer num : nums) {
			// ―ぃ惠秈场ミ穝ListNode
			ListNode cur = new ListNode(num);
			// р穝ListNodeNEXT逆い
			tail.next = cur;
			// 盢Юぺ穝ListNode竚獽秈︽矪瞶穝ListNode
			tail = cur;
		}
		return fakeHead.next;
	}

	// Ref:
	// https://discuss.leetcode.com/topic/42252/concise-java-solution-beats-98-with-comment/2
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		int carry = 0;
		// ミ安繷パ硂娩秨﹍穨琌安繷ㄏノ肈ヘいぃ穦瞷-1ボ
		ListNode fakeHead = new ListNode(-1);
		// рЮぺ竚安繷
		ListNode tail = fakeHead;

		while (carry > 0 || l1 != null || l2 != null) { // check if next node
														// exsits
			int n1 = l1 == null ? 0 : l1.val; // get value of number 1
			// 秈︽耞璶ぃ礛穦瞷NullPointerException
			if (l1 != null)
				l1 = l1.next;

			int n2 = l2 == null ? 0 : l2.val; // get value of number 2
			// 秈︽耞璶ぃ礛穦瞷NullPointerException
			if (l2 != null)
				l2 = l2.next;

			int sum = n1 + n2 + carry;
			// 璸衡惠秈ぶ
			carry = sum / 10;

			// ―ぃ惠秈场ミ穝ListNode
			ListNode cur = new ListNode(sum % 10);
			// р穝ListNodeNEXT逆い
			tail.next = cur;
			// 盢Юぺ穝ListNode竚獽秈︽矪瞶穝ListNode
			tail = cur;
		}
		return fakeHead.next;
	}
}
