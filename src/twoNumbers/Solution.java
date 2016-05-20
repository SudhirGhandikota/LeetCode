package twoNumbers;

class ListNode
{
	int val;
	ListNode next;
	ListNode(int x)
	{
		val=x;
	}
}
public class Solution {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode res = addTwoNumbers(l1,l2);
		while(res!=null)
		{
			System.out.print(res.val+" --->");
			res = res.next;
		}
	}

	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = 0;
		ListNode dummyHead = new ListNode(0);
		ListNode temp = dummyHead;
		while(l1!=null || l2!=null)
		{
			if(l1!=null)
			{
				//Adding value from first linkedlist
				sum = sum+l1.val;
				l1 = l1.next;
			}
			if(l2!=null)
			{
				//Adding value from second linkedlist
				sum = sum+l2.val;
				l2 = l2.next;
			}
			//Adding the value without carry i.e if value < 10
			temp.next = new ListNode(sum%10);
			//taking the carry for next iteration
			sum =sum/10;
			temp = temp.next;
		}
		if (sum>0)
			temp.next = new ListNode(sum);
		return dummyHead.next;
	}

}
