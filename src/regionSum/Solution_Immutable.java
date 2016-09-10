package regionSum;

/*
 * Solution to Range Sum 2D- Immutable
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class Solution_Immutable {

	public int[][] matrix;
	public int[][] sums;
	//in the constructor we maintain a 'sums' matrix such that
	//sums[i+1][j+1] represents the sum of area from matrix[0][0] to matrix[i][j]
	//we use i+1 and j+1 to deal with edge cases(first and last row and cols)
	public Solution_Immutable(int[][] matrix)
	{
		this.matrix = matrix;
		if(matrix==null||matrix.length==0)
			return;
		int m=matrix.length;
		int n = matrix[0].length;
		
		sums = new int[m+1][n+1];
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				//formula for sum
				sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i-1][j-1];
			}
		}
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2)
	{
		return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1]+sums[row1][col1];
	}
	public static void main(String[] args) {
		int[][] matrix = new int[5][5];
		matrix[0] = new int[]{3,0,1,4,2};
		matrix[1] = new int[]{5,6,3,2,1};
		matrix[2] = new int[]{1,2,0,1,5};
		matrix[3] = new int[]{4,1,0,1,7};
		matrix[4] = new int[]{1,0,3,0,5};
		
		Solution_Immutable sol= new Solution_Immutable(matrix);
		System.out.println(sol.sumRegion(2, 1, 4, 3));
		System.out.println(sol.sumRegion(2, 1, 4, 3));
	}
}
