package minStack;

import java.util.ArrayList;
import java.util.List;

/*
 * Solution to minstack problem leetcode
 * https://leetcode.com/problems/min-stack/
 * Since all push, pop and min operations have to be in constant time we use two lists
 * One list acts as the stack and the second list keeps the minimum elements.
 * We cannot just keep track of one min value(using a variable instead of list) 
 * because if that min value gets popped we need to track the entire stack for the next min value
 * The smallest element always is stored in the last index of this min list
 */
public class Solution {

	List<Integer> stack = new ArrayList();
	List<Integer> min = new ArrayList();
	public void push(int x){
		stack.add(x);
		//if the min list is empty of the new element is smaller than the current min element add it to the list
		if(min.size()==0||x<=min.get(min.size()-1))
			min.add(x);
	}
	public void pop(){
		int deleted = stack.remove(stack.size()-1);
		//if the smallest element is popped then it is also removed from the min list
		if(deleted==min.get(min.size()-1))
			min.remove(min.size()-1);
	}
	public int getMin(){
		return min.get(min.size()-1);
	}
	public int top(){
		return stack.get(stack.size()-1);
	}
	public static void main(String[] args) {
		Solution minstack = new Solution();
		minstack.push(-2);
		minstack.push(0);
		minstack.push(-3);
		System.out.println(minstack.getMin());
		minstack.pop();
		System.out.println(minstack.top());
		System.out.println(minstack.getMin());

	}

}
