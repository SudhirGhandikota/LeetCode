package paranthesisMatcher;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/*
 * This class checks the parenthesis in a given expression
 */
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String");
		String str = sc.next();
		System.out.println(checkParam(str));
		sc.close();
	}

	private static boolean checkParam(String str) {
		//Map stores all open and closed braces as key-value pairs
		HashMap<Character,Character> map = new HashMap();
		map.put(']', '[');
		map.put(')', '(');
		map.put('}', '{');
		//Stack used to maintain the parenthesis in the given expression
		Stack<Character> stack = new Stack();
		for(int i=0;i<str.length();i++)
		{
			//Case where closing braces are encountered
			if(map.containsKey(str.charAt(i)))
			{
				//if stack is empty or the top element is not the corresponding open braces
				if(stack.size()==0 || stack.peek()!=map.get(str.charAt(i)))
					return false;
				else
					stack.pop();
			}
			//If open braces are encountered, we will push them onto the stack
			else if(map.containsValue(str.charAt(i)))
				stack.push(str.charAt(i));
		}
		//after expression is traversed, if stack is full then all parenthesis are matched
		if(stack.size()==0)
			return true;
		else
			return false;
	}

}
