package longestPalinString;

/*
 * Modified Solution for 'longest palindromic substring' problem
 * https://leetcode.com/problems/longest-palindromic-substring/
 * O(n2) Dynamic Programming solution.
 * DP[i][j] = TRUE indicates substring between indexes i and j is a palindrome
 */
public class Solution_DP {

	public String longestPalindrome(String s){
		if(s.length()==0)
			return null;
		if(new StringBuffer(s).reverse().toString().equals(s))
			return s;
		boolean dp[][] = new boolean[s.length()][s.length()];
		int max_len = 1;
		int start = 0;
		for(int i=0;i<s.length();i++){
			for(int j=0;j<i;j++){
				//if the start and end indexes of a substring are same and the substring in between is also a palindrome
				if(s.charAt(i)==s.charAt(j) && (i-j<2)||dp[j+1][i-1]){
					dp[j][i] = true;//indicates substring with j as starting index and i as ending index is palindrome
					if(i-j+1>max_len){
						start = j;
						max_len = i-j+1;
					}
				}
			}
		}
		return s.substring(start,start+max_len);
	}
	public static void main(String[] args) {
		String s = "geeksformalayalam";
		Solution sol = new Solution();
		System.out.println(sol.longestPalindrome(s));

	}

}
