package wordBreak2;

import java.util.HashSet;
import java.util.Scanner;

/*
 * This program check is a given string can be segmented based on the given dictionary of words
 */
public class Solution {

	public static void main(String[] args) {
		//The input set of words
		HashSet<String> set = new HashSet<String>();
		set.add("program");
		set.add("creek");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
		String s = sc.next();
		System.out.println(wordBreak(s,set));
		sc.close();
	}
	/*
	 * Method checks if the string can be segmented or not
	 * t[i] value indicates if substring(0,i-1) can be segmented or not
	 */
	public static boolean wordBreak(String s,HashSet<String> dict)
	{
		boolean t[] = new boolean[s.length()+1];
		//initial case
		t[0] = true;
		for(int i=0;i<s.length();i++)
		{
			//To start checking from already matched position. This is for subsequent iterations
			if(!t[i])
				continue;
			for(String a:dict)
			{
				int end = i + a.length();
				
				//If the word in the dictionary is longer than the input string/suffix string
				if(end>s.length())
					continue;
				
				//If solution already found for the given range of substring. No need to check
				if(t[end])
					continue;
				//checking if the substring of given range is equal to a word in the dictionary
				if(s.substring(i, end).equals(a))
					t[end] = true;
			}
		}
		return t[s.length()];
	}

}
