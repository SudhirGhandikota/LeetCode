package missingRanges;

import java.util.ArrayList;
import java.util.List;

/*
 * Solution to missing ranges problem in leetcode
 * https://leetcode.com/problems/missing-ranges/
 * I/P: [0,1,3,50,75], lower=0 & upper=99 O/P: ["2","4->49","51->74","76->99"]
 */
public class Solution {
	List<String> result = new ArrayList<String>();

	public List<String> findMissingRanges(int[] nums, int lower, int upper)
	{
		//if sorted array not provided
		if(nums==null||nums.length==0)
		{
			addToResult(lower,upper);
			return result;
		}
		//if the array missed the lower bound. Adding the string till lower bound
		if(nums[0]-lower>0)
			addToResult(lower,nums[0]-1);
		//looping through the entire array to find the missing ranges
		for(int i=1;i<nums.length;i++)
		{
			//if there is a difference between corresponding elements of the array
			if(nums[i]-nums[i-1]>1)
				addToResult(nums[i-1]+1, nums[i]-1);//the missing range is added
		}
		//if the array missed the upper bound. Adding the string till upper bound
		if(upper-nums[nums.length-1]>0)
			addToResult(nums[nums.length-1]+1,upper);
		return result;
	}
	private void addToResult(int start, int end) {
		StringBuffer sb = new StringBuffer();
		//the case where only one value is missing instead of range
		if(start==end)
			sb.append(start);
		else
			sb.append(start+"->"+end);
		result.add(sb.toString());
		
	}
	public static void main(String[] args) {
		int nums[] = {0,1,3,50,75};
		List<String> res = new Solution().findMissingRanges(nums, 0, 99);
		for(String s: res)
		{
			System.out.println(s);
		}

	}

}
