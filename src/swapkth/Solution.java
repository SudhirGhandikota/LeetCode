package swapkth;

import java.util.Scanner;
import java.util.Stack;

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
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		ListNode new_head = reverseKGroup(head,k);
		while(new_head!=null)
		{
			System.out.print(new_head.val+"->");
			new_head = new_head.next;
		}
	}

	private static ListNode reverseKGroup(ListNode head, int k) {
		//if list is either null or has only one value
		if(head==null || head.next==null)
			return head;
		else
		{
			ListNode dummy = new ListNode(0);
			ListNode head2 = head;
			dummy.next = head;
			int cnt = 0 ;
			//loop to find the length of the list
			while(head2!=null)
			{
				cnt++;
				head2 = head2.next;
			}
			//if k greater than the length of list
			if(k>cnt)
				return dummy.next;
			else
			{
				//Stack is used to store k elements
				Stack<ListNode> stack = new Stack();
				ListNode temp = new ListNode(0);
				ListNode open = new ListNode(0);
				temp.next = open;
				open.next = head;
				int nums = k;
				//looping over all lists. Number of iterations would be n/k
				while(nums<=cnt)
				{
					//adding the k nodes to a stack
					for(int i=0;i<k;i++)
					{
						stack.push(head);
						head = head.next;
					}
					//linking the k nodes in popped order(LIFO). They get reversed because of the LIFO property of the stack
					while(stack.size()>0)
					{
						open.next = stack.pop();
						open=open.next;
					}
					nums+=k;
				}
				if(head!=null)
					open.next = head;
				return temp.next.next;
			}
		}
	}

	

}

