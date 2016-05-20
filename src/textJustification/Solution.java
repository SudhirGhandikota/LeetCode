package textJustification;

public class Solution {

	public static void main(String[] args) {
		int l[] = {3,2,2,5};
		int n = l.length;
		int m = 6;
		solveWordWrap(l,n,m);

	}

	/*
	 * l[] represents list of lengths of words
	 * n indicates number of words
	 * m indicates the line width
	 */
	private static void solveWordWrap(int[] l, int n, int m) {
		
		//extras[i][j] will have number of extra spaces if words from
		//i to j are put in a single line
		int extras[][] = new int[n+1][n+1];
		
		//lc[i][j] will have cost of line which has words from i to j
		int lc[][] = new int[n+1][n+1];
		
		//c[i] will have cost of optimal arrangement of words from 1 to i
		int c[] = new int[n+1];
		
		//p[] is used to print the solution.
		//Value of p indicates the ending word of lines corresponding to the cost in c[]
		int p[] = new int[n+1];
		
		//calculate extra spaces in single line. Value of extra[i][j]
		//indicates extra spaces if words from number i to j are
		//places in a single line
		for(int i=1;i<=n;i++)
		{
			//indicates the case where only one word 'i' exists in a line
			extras[i][i] = m-l[i-1];
			for(int j=i+1;j<=n;j++)
				extras[i][j] = extras[i][j-1] - l[j-1] -1;
		}
		
		//Calculate line cost corresponding to the above calculated extra spaces.
		//The value lc[i][j] indicates cost of putting words from word i to j n a single like
		//Cost function is square of number of extra spaces in a line.
		//Square is taken because just the sum of spaces will not balance out number of spaces across all line
		//We might get multiple cases of lines with same space count. So we can get an unbalanced line seperation
		for(int i=1;i<=n;i++)
		{
			for(int j=i;j<=n;j++)
			{
				//the case where words from i to j cannot be placed in the same line.
				//it indicates the length from words i to j is greater than the line width
				if(extras[i][j]<0)
					lc[i][j] = Integer.MAX_VALUE;
				else if(j==n && extras[i][j]>=0)
					lc[i][j]=0;
				else
					lc[i][j] = extras[i][j] * extras[i][j];
			}
		}
		
		//Calculate minimum cost and find cost arrangement
		//Value of c[j] indicates optimized cost to arrange words
		//from 1 to j
		for(int j=1;j<=n;j++)
		{
			c[j] = Integer.MAX_VALUE;
			for(int i=1;i<=j;i++)
			{
				if(c[i-1]!=Integer.MAX_VALUE && lc[i][j]!=Integer.MAX_VALUE && (c[i-1]+lc[i][j]<c[j]))
				{
					c[j] = c[i-1]+lc[i][j];
					p[j] = i;
				}
			}
		}
		printSolution(p,n);
	}

	private static int printSolution(int[] p, int n) {
		int k;
		if(p[n]==1)
			k=1;
		else
			k = printSolution(p,p[n]-1)+1;
		System.out.println("Line Number:"+k+" From word number:"+p[n]+" to:"+n);
		return k;
		
	}

}
