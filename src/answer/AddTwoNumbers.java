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
		// �إߤ@�Ӱ��Y�A�ѳo��}�l�@�~�A�]�]���O���Y�A�ϥ��D�ؤ����|�X�{��-1���
		ListNode fakeHead = new ListNode(-1);
		// ����ڪ���m���V���Y
		ListNode tail = fakeHead;
		for (Integer num : nums) {
			// �D�X���ݶi�쪺�����ëإߥX�s��ListNode
			ListNode cur = new ListNode(num);
			// ��sListNode��JNEXT����줤
			tail.next = cur;
			// �N���ګ��V�sListNode����m�A�H�K�᭱�i��B�z�A�[�J�s��ListNode
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
		// �إߤ@�Ӱ��Y�A�ѳo��}�l�@�~�A�]�]���O���Y�A�ϥ��D�ؤ����|�X�{��-1���
		ListNode fakeHead = new ListNode(-1);
		// ����ڪ���m���V���Y
		ListNode tail = fakeHead;

		while (carry > 0 || l1 != null || l2 != null) { // check if next node
														// exsits
			int n1 = l1 == null ? 0 : l1.val; // get value of number 1
			// �i��P�_�A�n���M�|�X�{NullPointerException
			if (l1 != null)
				l1 = l1.next;

			int n2 = l2 == null ? 0 : l2.val; // get value of number 2
			// �i��P�_�A�n���M�|�X�{NullPointerException
			if (l2 != null)
				l2 = l2.next;

			int sum = n1 + n2 + carry;
			// �p��X�ݶi��h��
			carry = sum / 10;

			// �D�X���ݶi�쪺�����ëإߥX�s��ListNode
			ListNode cur = new ListNode(sum % 10);
			// ��sListNode��JNEXT����줤
			tail.next = cur;
			// �N���ګ��V�sListNode����m�A�H�K�᭱�i��B�z�A�[�J�s��ListNode
			tail = cur;
		}
		return fakeHead.next;
	}
}
