package plusOne;

public class Solution {

	/*
	 * Method to add one to a number where the digits are present in an array such that the most significant digit is at the head
	 * https://leetcode.com/problems/plus-one/
	 * sample I/P: {9,8,9} O/P: {9,9,0}
	 */
	public int[] plusOne(int[] digits)
	{
		if(digits==null||digits.length==0)
			return new int[0];
		for(int i=digits.length-1;i>=0;i--)
		{
			if(digits[i]==9)//if 9 is encountered we make that digit 0
				digits[i]=0;
			else
			{
				digits[i]++; //if 9 is not there then we increase the digit value by one and return
				return digits;
			}
				
		}
		//To add 1 at the top(for the scenario where 9 is found)
		int[] num = new int[digits.length+1];//creating a new array
		num[0]=1;//adding 1 at the most significant digit
		//loop to copy the rest of the digits
		for(int j=1;j<=digits.length;j++)
		{
			num[j]=digits[j-1];
		}
		return num;
	}
	public static void main(String[] args) {
		int[] num = {9,8,9};
		int[] new_nums = new Solution().plusOne(num);
		for(int i:new_nums)
		{
			System.out.print(i);
		}

	}

}
