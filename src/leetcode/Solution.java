package leetcode;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		ListNode l1 = new Solution().new ListNode(5);
		ListNode l2 = new Solution().new ListNode(5);
		
		/*ListNode l1 = new Solution().new ListNode(1);
		ListNode currentl1 = l1;
		for(int i=0;i<29;i++){
			ListNode old = currentl1;
			ListNode newNode = new Solution().new ListNode(0);
			currentl1= newNode;
			old.next = currentl1;
		}
		currentl1.next = new Solution().new ListNode(1);*/
		

		/*l1.next = new Solution().new ListNode(9);
		l1.next.next = new Solution().new ListNode(9);
		l1.next.next.next = new Solution().new ListNode(9);
		l1.next.next.next.next = new Solution().new ListNode(9);
		l1.next.next.next.next.next = new Solution().new ListNode(9);
		l1.next.next.next.next.next.next = new Solution().new ListNode(9);
		l1.next.next.next.next.next.next.next = new Solution().new ListNode(9);
		l1.next.next.next.next.next.next.next.next = new Solution().new ListNode(9);
		l1.next.next.next.next.next.next.next.next.next = new Solution().new ListNode(9);*/

		// l1.next.next = new Solution().new ListNode(3);

		/*ListNode l2 = new Solution().new ListNode(5);
		l2.next = new Solution().new ListNode(6);
		l2.next.next = new Solution().new ListNode(4);
		ListNode l3 = s.addTwoNumbers(l1, l2);
		System.out.println("final::" );*/
		ListNode l3 = s.addTwoNumbers(l1, l2);
		while(l3!=null){
			System.out.print(l3.val +"," );
			l3=l3.next;
		}
		
		
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l3 = new ListNode(0);
		ListNode l3Current = l3;

		ListNode l1Current = l1;
		ListNode l2Current = l2;


		boolean change = false;
		int i = 0;

		while (l1Current != null || l2Current != null || change == true) {

			int val1 = l1Current == null ? 0 : l1Current.val;
			int val2 = l2Current == null ? 0 : l2Current.val;
			int val3 = val1 + val2;
			if (change) {
				val3++;
			}
			if (val3 >= 10) {
				val3 = val3 % 10;
				change = true;
			} else {
				change = false;
			}

			ListNode newNode = new ListNode(0);
			newNode.val = val3;
			if (i == 0) {
				l3 = newNode;
				l3Current = newNode;
			} else {
				ListNode old = l3Current;
				l3Current = newNode;
				old.next = l3Current;
			}

			System.out.println("val1::" + val1);
			System.out.println("val2::" + val2);
			System.out.println("val3::" + val3);
			if (l1Current != null) {
				l1Current = l1Current.next;
			}
			;
			if (l2Current != null) {
				l2Current = l2Current.next;
			}
			i++;

		}

		return l3;
	}
}
