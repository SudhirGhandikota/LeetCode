package sudokusolver;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		char board[][] = new char[9][9];
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				System.out.println("Enter character for:"+(i+1)+"th row"+(j+1)+"th column");
				board[i][j] = sc.next().charAt(0);
			}
		}
		display(board);
		char res[][] = solveSudoku(board);
		display(res);

	}
	private static void display(char[][] board)
	{
		System.out.println("***************Solution is***************");
		for(int i = 0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

	//method to solve a sudoku boar
	private static char[][] solveSudoku(char[][] board) {
		//if the board is empty
		if(board==null||board.length==0)
			return null;
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				//case where cell is empty
				if(board[i][j]=='.')
				{
					System.out.println("Cell "+(i+1)+" "+(j+1)+" is Empty");
					for(char num='1';num<='9';num++)
					{
						if(isValid(board,i,j,num))
						{
							System.out.println("Solved for "+(i+1)+" "+(j+1)+" "+num);
							board[i][j] = num;
							break;
						}
						else
							board[i][j] = '.';
					}
				}
			}
		}
		return board;
		
	}

	/*
	 * Checks if a number(num) can be placed in a particular position on the board
	 */
	private static boolean isValid(char[][] board, int i, int j, char num) {
		System.out.println("Row:"+i+" Column:"+j+" character:"+num);
		//checking if the number already exists in the column
		for(int row=0;row<9;row++)
		{
			if(board[row][j]==num)
				return false;
		}
		//checking if the number already exists in the row
		for(int col=0;col<9;col++)
		{
			if(board[i][col]==num)
				return false;
		}
		//checking if the number exists in the the block of 3 rows
		for(int row=i/3*3;row<i/3*3+3;row++)
		{
			for(int col=j/3*3;col<i/3*3+3;col++)
			{
				if(board[row][col]==num)
					return false;
			}
		}
		return true;
	}

}
