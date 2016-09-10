package summaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<String> result = new ArrayList();
	public List<String> summaryRanges(int[] nums)
	{
		if(nums==null || nums.length==0)
			return result;
		int i=1; 
		int pre=nums[0];
		int end = nums[0];
		while(i<nums.length)
		{
			//the case we have consecutive numbers in corresponding indices
			if(nums[i]-nums[i-1]==1)
			{
				end = nums[i];//we keep on increasing the end to get the 'end' of the range
			}
			//case where corresponding elements form a range
			else
			{
				addToResult(pre,end);
				pre = end = nums[i];
			}
			i++;
		}
		//to add left over ranges after looping the entire array
		addToResult(pre,end);
			
		return result;
	}
	private void addToResult(int start, int end)
	{
		if(start==end)
			result.add(String.valueOf(start));
		else
			result.add(start+"->"+end);
	}

	public static void main(String[] args) {
		int nums[] = {0,1,2,4,5,7};
		List<String> res = new Solution().summaryRanges(nums);
		for(String s: res)
		{
			System.out.println(s);
		}
		int nums1[] = {0,1,2,4,7};
		res = new Solution().summaryRanges(nums1);
		for(String s: res)
		{
			System.out.println(s);
		}

	}

}
