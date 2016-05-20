package swapnodes;

class ListNode
{
	int val;
	ListNode next;
	
	ListNode(int x)
	{
		val = x;
	}
}
public class Solution {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode new_head = swapPairs(head);
		while(new_head!=null)
		{
			System.out.print(new_head.val+"->");
			new_head = new_head.next;
		}
	}

	private static ListNode swapPairs(ListNode head) {
		if(head.next==null)
			return head;
		ListNode new_head=null;
		ListNode temp_head = new ListNode(0);
		temp_head.next = head;
		ListNode temp = temp_head;
		ListNode prev = null;
		while(temp!=null)
		{
			System.out.println("Temp is:"+temp.val);
			//Assigning first node
			if(temp.next==null)
				break;
			ListNode first = temp.next;
			System.out.println("First is:"+first.val);
			//Checking if 2nd node is available
			if(first.next==null)
				break;
			//Assigning second node
			ListNode second = first.next;
			System.out.println("Second is:"+second.val);
			//Assigning new head node. One time assignment
			if(new_head==null)
				new_head = second;
			//if head is already assigned we link the current(before swapping) node to prev(the swapped node after previous iteration) node
			else
				prev.next = second;
			ListNode node = second.next;
			//Swapping the nodes
			second.next = first;
			first.next = node;
			temp = first;
			prev=first;
		}
		return new_head;
	}

}
