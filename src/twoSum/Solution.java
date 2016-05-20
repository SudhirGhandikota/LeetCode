package twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 26;
		int[] res = TwoSum(nums,target);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}

	private static int[] TwoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int[] res = new int[2];
		for(int i=0;i<nums.length;i++)
		{
			if(map.containsKey(target-nums[i]))
			{
				res[0] = map.get(target-nums[i]);
				res[1] = i;
			}
			map.put(nums[i], i);
		}
		return res;
	}

}
