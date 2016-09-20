package longestPalinString;

/*
 * Modified Solution for 'longest palindromic substring' problem
 * https://leetcode.com/problems/longest-palindromic-substring/
 * O(n2) solution as we are not going to check for palindrome condition(s==s.reverse)
 * Our approach is to iteratively find even and odd length substrings which are palindromes
 */
public class Solution_mod {

	public String longestPalindrome(String s){
		if(s.length()==0||s==null)
			return null;
		if(new StringBuffer(s).reverse().toString().equals(s))
			return s;
		int maxLen = 0; //stores maximum length. Updates after for each palindrome substring
		int start = 0; //maintains the start of the longest palindromic substring
		int low, high = 0;
		for(int i=1;i<s.length();i++)
		{
			low = i-1;
			high = i;
			//loop to find longest even length palindromic string with center i
			while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high))
			{
				if(high - low +1>maxLen)
				{
					start = low;
					maxLen = high - low +1;
				}
				low--;
				high++;
			}
			low = i-1;
			high = i+1;
			//loop to find longest odd length palindromic substring with center i
			while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high))
			{
				if(high - low + 1>maxLen)
				{
					start = low;
					maxLen = high - low +1;
				}
				low--;
				high++;
			}
		}
		return s.substring(start, start+maxLen);
	}
	public static void main(String[] args) {
		String s = "geeeksformalayalam";
		Solution sol = new Solution();
		System.out.println("Longest Palindromic substring:"+sol.longestPalindrome(s));

	}

}
