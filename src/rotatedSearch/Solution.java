package rotatedSearch;

import java.util.Scanner;

/*
 * Iterative binary search intended to search in a rotated array
 * Assuming rotated is partially sorted either in ascending or descending order
 */
public class Solution {

	public static void main(String[] args) {
		int nums[] = {4,5,6,7,0,1,2};
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int target = sc.nextInt();
		System.out.println(search(nums,target));
		sc.close();
	}
	public static int search(int[]nums,int target)
	{
		int left = 0;
		int right = nums.length-1;
		while(left<=right)
		{
			int mid = left+(right-left)/2;
			//exit criteria
			if(target==nums[mid])
				return mid;
			//case where numbers rotated in increasing order
			if(nums[left]<=nums[mid])
			{
				//to check if target is between left and mid
				if(target>=nums[left] && target<nums[mid])
					right = mid - 1;
				else
					left = mid+1;
			}
			//case where numbers rotated in decreasing order
			else
			{
				if(target>nums[mid]&& target<=nums[right])
					left = mid+1;
				else
					right = mid-1;
			}
		}
		return -1;
	}

}
