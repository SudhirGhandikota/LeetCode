package numOfIslands;

/*
 * Solution to find number of islands problem in leetcode
 * https://leetcode.com/problems/number-of-islands/
 * It is a classic connected graph problem where is we need to find number of distinct connected components(where value is '1')
 * Number of different connected components indicate number of islands.
 * For instance if we are able to visit all the nodes of '1' at one go then there is just one island.
 * If not the number of loops to visit all the nodes will be the number of islands
 * We are going to perform a Depth First traversal of the graph
 */
public class Solution {
	public int numIslands(char[][] grid)
	{
		//case where input is empty
		if(grid==null || grid.length==0 || grid[0].length ==0)
			return 0;
		int rows = grid.length;
		int cols = grid[0].length;
		//Auxiliary array to maintain the visit status
		boolean visited[][] = new boolean[rows][cols];
		int count = 0;
		//iterating through all vertices and edges. The number of times islandHelper is called indicates the number of islands i.e the number of connected components
		for(int i=0; i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				if(grid[i][j]=='1' && !visited[i][j])//if '1' is encountered and the node is not visited
				{
					count++;
					islandHelper(grid,visited,i,j,rows,cols);
				}
			}
		}
		return count;
	}
	
	private void islandHelper(char[][] grid, boolean[][] visited, int i, int j, int rows, int cols) {
		//boundary condition for rows
		if(i<0 || i>=rows)
			return;
		//boundary condition cols
		if(j<0|| j>=cols)
			return;
		//if the node already visited
		if(visited[i][j])
			return;
		//if '1' not encountered
		if(grid[i][j]!='1')
			return;
		visited[i][j] = true;
		//iteratively visiting all the adjacent nodes in all the 4 directions
		islandHelper(grid,visited,i-1,j,rows,cols);
		islandHelper(grid,visited,i+1,j,rows,cols);
		islandHelper(grid,visited,i,j-1,rows,cols);
		islandHelper(grid,visited,i,j+1,rows,cols);
		
	}

	public static void main(String[] args) {
		char grid[][] = new char[4][5];
		grid[0] = new char[]{'1','1','1','1','0'};
		grid[1] = new char[]{'1','1','0','1','0'};
		grid[2] = new char[]{'1','1','0','0','0'};
		grid[3] = new char[]{'0','0','0','0','0'};
		Solution sol = new Solution();
		System.out.println(sol.numIslands(grid));

	}

}
