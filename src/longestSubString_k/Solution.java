package longestSubString_k;

import java.util.HashMap;

/*
 * Solution to 'Longest SubString with k unique characters' problem
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * The approach used is to use a sliding window pattern.
 * A auxillary hash map in which the key is each character in the window, the value is its frequency.
 * Whenever we move the sliding window we need to update the hashmap to match the current substring
 * Eg: for [abccd]d, if we move forward to a[bccdd] then hash map should be {b:1. c:2, d:2}
 */
public class Solution {

	public int lengthOfLongestSubStringKDistinct(String s, int k)
	{
		if (k==0||s==null||s.length()==0)
			return 0;
		if(s.length()<k)
			return s.length();
		HashMap<Character,Integer> map = new HashMap();
		
		int maxLen = k;
		int left = 0;
		//looping through all the characters in a string
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			System.out.print(c+",");
			//if the map contains the key, we increase its increment
			if(map.containsKey(c))
				map.put(c, map.get(c)+1);
			else
				map.put(c,1);
			//if the distinct characters in current substring crosses the limit k
			if(map.size()>k)
			{
				//updating the maxLen flag
				maxLen = Math.max(maxLen, i-left);
				//we need to slide the window and rebuild the hash to match the current substring
				while(map.size()>k)
				{
					char fc = s.charAt(left);
					if(map.get(fc)==1)
						map.remove(fc);
					else
						map.put(fc, map.get(fc)-1);
					left++;
				}
			}	
		}
		//updating the maxLen if the last found substring is the largest substring
		maxLen = Math.max(maxLen, s.length()-left);
		return maxLen;
	}
	public static void main(String[] args) {
		String s = "aabbccdd";
		Solution sol = new Solution();
		System.out.println(sol.lengthOfLongestSubStringKDistinct(s, 1));
		System.out.println(sol.lengthOfLongestSubStringKDistinct(s, 2));
		System.out.println(sol.lengthOfLongestSubStringKDistinct(s, 3));
		System.out.println(sol.lengthOfLongestSubStringKDistinct("abcadcacacaca", 3));

	}

}
