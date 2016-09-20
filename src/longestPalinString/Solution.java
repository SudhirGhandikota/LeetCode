package longestPalinString;

/*
 * Solution to 'Longest Palindromic Substring' question in leetcode
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Brute force solution of going through all substrings and finding the longest
 * O(n3)--we use two loops i.e O(n2) and for each loop we check for palindromic condition which in worst case would be O(n)
 */
public class Solution {

	public String longestPalindrome(String s){
		if(s==null||s.length()==0)
			return null;
		if(isPalin(s))
			return s;

		String result = "";
		for(int i=0;i<s.length()-1;i++)
			for(int j=i+1;j<=s.length();j++)
			{
				String sub = s.substring(i,j);
				if(isPalin(sub) && sub.length()>result.length())
					result = sub;
			}
		return result;
	}
	private boolean isPalin(String s){
		String rev = new StringBuffer(s).reverse().toString();
		return (rev.equals(s));
	}
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		Solution sol = new Solution();
		System.out.println(sol.longestPalindrome(s));

	}

}
