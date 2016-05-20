package searchrange;

import java.util.Scanner;

public class Solution {
	
	/*
	 * O(log n) solution to search for a range(starting and ending indexes) of a given value
	 * Binary search is used to achieve the log n performance
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter target:");
		int target = sc.nextInt();
		int nums[] = {5,7,7,8,8,10};
		int res[] = new int[2];
		res = searchRange(nums,target);
		sc.close();
		System.out.println("["+res[0]+","+res[1]+"]");
	}

	private static int[] searchRange(int[] nums,int target) {
		if(nums==null||nums.length==0)
			return null;
		int arr[] = new int[2];
		arr[0] = -1;
		arr[1] = -1;
		
		binarySearch(nums,0,nums.length-1,target,arr);
		return arr;
	}

	private static void binarySearch(int[] nums, int left, int right, int target, int[] arr) {
		//exit condition
		if(right<left)
			return;
		//if the sub-array/range is the target range
		if(nums[left]==nums[right] && nums[left]==target)
		{
			arr[0] = left;
			arr[1] = right;
			return;
		}
		
		int mid = left+(right-left)/2;
		
		//case where target is in the right sub-array
		if(nums[mid]<target)
			binarySearch(nums,mid+1,right,target,arr);
		//case where target is in left sub-array
		else if(nums[mid]>target)
			binarySearch(nums,left,mid-1,target,arr);
		//case where mid value is the target value
		else if(nums[mid]==target)
		{
			arr[0] = mid;
			arr[1] = mid;
			
			//finding duplicates left of mid
			int temp = mid;
			while(temp > left && nums[temp] == nums[temp-1])
			{
				temp--;
				arr[0] = temp;
			}
			//find duplicates right of mid
			temp = mid;
			while(temp < right && nums[temp] == nums[temp+1])
			{
				temp++;
				arr[1] = temp;
			}
			return;
		}
	}

}
