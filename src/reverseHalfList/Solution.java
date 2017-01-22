package reverseHalfList;

import java.util.ArrayList;
import java.util.Stack;

class Node{
	Node next;
	int d;
	
	public Node(int d){
		this.next = null;
		this.d = d;
	}
}
public class Solution {

	public void display(Node root){
		Node head = root;
		while(head!=null){
			System.out.print(head.d+" -> ");
			head = head.next;
		}
	}
	public Node ReverseHalf(int length, Node head){
		Node first = head;
		Node halfhead;
		Stack<Node> stack = new Stack();
		if(length<4)
			return head;
		else{
			int halflen = (int)Math.ceil((double)length/2);
			for(int i=0;i<halflen-1;i++)
				head = head.next;
		}
		halfhead = head;
		Node temp = halfhead.next;
		while(temp!=null){
			Node next = temp.next;//unlinking the reversed
			temp.next = null;
			stack.push(temp);
			temp = next;
		}
		System.out.println("Stack Size is:"+stack.size());
		System.out.println("Half Head is:"+halfhead.d);
		while(stack.size()>0){
			halfhead.next = null;
			halfhead.next = stack.peek();
			stack.pop();
			halfhead = halfhead.next;
		}
		return first;
	}
	public static void main(String[] args) {
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		Node seventh = new Node(7);
		Node eighth = new Node(8);
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = seventh;
		seventh.next = eighth;
		Solution sol = new Solution();
		sol.display(first);
		Node new_head = sol.ReverseHalf(8, first);
		System.out.println("Head is:"+new_head.d);
		sol.display(new_head);
		//Node halfhead = sol.ReverseHalf(8, first);
		//System.out.print("Half Head:"+halfhead.d);

	}

}
