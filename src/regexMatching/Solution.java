package regexMatching;

import java.util.Scanner;

/*
 * This program matches a string and a given regular expression.
 * 
 */
public class Solution {

	public static boolean isMatch(String s, String p)
	{
		//base condition
		if(s.length()==0 && p.length() ==0)
			return true;
		//condition where regular expression input is null
		if(p.length()==0)
			return s.length()==0;
		if(p.length()==1)
		{
			//if first character does not match and the regex is not "." i.e it cannot have any character
			if((p.charAt(0)!=s.charAt(0))&&(p.charAt(0)!='.'))
				return false;
			else
			{
				//goes to base case if both are of same length. Else goes to false condition having one input null
				return isMatch(s.substring(1),p.substring(1));
			}
		}
		//case where 2nd character is not a *
		if(p.charAt(1)!='*')
		{
			//if first character does not match and the regex is not "." i.e it cannot have any character
			if((p.charAt(0)!=s.charAt(0))&&(p.charAt(0)!='.'))
				return false;
			else
				return isMatch(s.substring(1),p.substring(1));
		}
		//case where second character is a *
		else
		{
			//sub-case: to check if * stands for 0 character of preceding element
			if(isMatch(s,p.substring(2)))
				return true;
			int i=0;
			//Case where * stands for multiple characters of preceding element. loop over all substrings
			while(i<s.length()&&(s.charAt(i)==p.charAt(0)||p.charAt(0)=='.'))
			{
				if(isMatch(s.substring(i+1), p.substring(2)))
					return true;
				i++;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String");
		String s = sc.nextLine();
		//System.out.println("Entered String is:"+s);
		System.out.println("Enter regex");
		String p = sc.nextLine();
		//System.out.println("Entered regex is:"+p);
		System.out.println(isMatch(s,p));

	}

}
