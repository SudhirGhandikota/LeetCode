package mergeSortedList;

import java.util.Comparator;
import java.util.PriorityQueue;

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
		ListNode root1 = new ListNode(2);
		root1.next = new ListNode(5);
		root1.next.next = new ListNode(7);
		
		ListNode root2 = new ListNode(3);
		root2.next = new ListNode(6);
		root2.next.next = new ListNode(9);
		
		ListNode[] lists = new ListNode[2];
		lists[0] = root1;
		lists[1] = root2;
		ListNode merged = merge(lists);
		ListNode temp = merged;
		while(temp!=null)
		{
			System.out.print(temp.val+"->");
			temp = temp.next;
		}

	}

	private static ListNode merge(ListNode[] lists) {
		if(lists.length==0)
			return null;
		
		PriorityQueue<ListNode>queue = new PriorityQueue<ListNode>(lists.length,
				new Comparator<ListNode>()
				{
					public int compare(ListNode a,ListNode b)
					{
						if(a.val>b.val)
							return 1;
						else if(a.val<b.val)
							return -1;
						else
							return 0;
					}
				});
		//adding head(root) nodes of each linked list
		for(ListNode node:lists)
		{
			if (node!=null)
				queue.add(node);
		}
		ListNode head = new ListNode(0);
		ListNode p = head;
		
		//recursively adding each node into the priority queue
		while(queue.size()>0)
		{
			//getting the head of the queue. 
			ListNode temp = queue.poll();
			//linking the new nodes to the merged list
			p.next = temp;
			
			//adding the linked nodes into the queue so that they can be linked to the merge list later in the iteration
			if(temp.next!=null)
				queue.add(temp.next);
			p = p.next;
		}
		return head.next;
	}

}
