package longestSubString;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * This program gives the length of longest substring with unique characters
 */
public class Solution {

	public static void main(String[] args) {
		System.out.println("Enter String");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String res = lengthOfLongestSubString(s);
		System.out.println("String is:"+res+" length:"+res.length());
		sc.close();
	}
	/*
	 * Uses the sliding window pattern
	 * The window is defined by the range [i,j)
	 * Intuition is if we need to check for duplicate characters,
	 * if s substring sij(from index i to j-1) is already checked to have no duplicate characters
	 * then we only need to check if s[j] is already there in the substring
	 * HashSet "sliding window" is used for this. It contains our current window [i,j)
	 */
	public static String lengthOfLongestSubString(String s)
	{
		int n = s.length();
		Set<Character> set = new HashSet<Character>();
		int i=0,j=0;
		while(i<n && j<n)
		{
			//the case where the characters is not already present. We add the character to the window
			if(!set.contains(s.charAt(j)))
				set.add(s.charAt(j++));
			else
				i++;
		}
		String res="";
		for(char c:set)
		{
			res = res+c;
		}
		return res;
	}

}
