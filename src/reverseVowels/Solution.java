package reverseVowels;

import java.util.ArrayList;
import java.util.List;

/*
 * Solution to the reverse vowels in a string problem in leetcode
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * Here we use two pointer one at start and the other at the end.
 * We iterate first from the start, when we find a vowel, we start iterating the string from the end to find a vowel with which we can swap with
 */
public class Solution {

	static List<Character> vowelList = new ArrayList();
	public String reverseVowels(String s)
	{
		if(s.length()==0||s==null)
			return null;
		int i=0;
		int j= s.length()-1;
		char arr[] = s.toCharArray();
		while(i<j)
		{
			//encountered a vowel at the start
			if(!Solution.vowelList.contains(arr[i]))
			{
				i++;
				continue;
			}
			//found the matching(in the reverse direction) vowel from the end
			if(!Solution.vowelList.contains(arr[j]))
			{
				j--;
				continue;
			}
			//swap the vowels(reverse)
			char t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			
			i++;
			j--;
		}
		return new String(arr);
	}
	public static void main(String[] args) {
		vowelList.add('a');
		vowelList.add('e');
		vowelList.add('i');
		vowelList.add('o');
		vowelList.add('u');
		vowelList.add('a');
		vowelList.add('A');
		vowelList.add('E');
		vowelList.add('I');
		vowelList.add('O');
		vowelList.add('U');
		Solution sol = new Solution();
		System.out.println(sol.reverseVowels("hello"));
		System.out.println(sol.reverseVowels("leetcode"));
	}

}
