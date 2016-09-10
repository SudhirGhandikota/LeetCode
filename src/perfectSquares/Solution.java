package perfectSquares;

/*
 * Solution to 'least number of perfect squares problem'
 * https://leetcode.com/problems/perfect-squares/
 * It follows a bottom-up DP programming approach where dp[i] indicates the least number of perfect squares to get i
 * dp[0] = 0; Transit function => dp[i] = min(dp[i],dp[i-j*j]) where j*j<=i
 */
public class Solution {

	public int numSquares(int n)
	{
		if(n<=0)
			return 0;
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++){
			dp[i] = Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++){
				dp[i] = Math.min(dp[i],dp[i-j*j]+1);
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.numSquares(13));

	}

}
