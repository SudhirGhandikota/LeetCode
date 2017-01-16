package grayCode;

import java.util.ArrayList;
import java.util.List;

/*
 * Solution to "Gray Code" problem in LeetCode
 * https://leetcode.com/problems/gray-code/
 * Sample I/P: n=2
 * O/P: [0,1,3,2]
 */
public class Solution {
	
	public List<Integer> grayCode(int n){
		if(n==0){
			List<Integer> result = new ArrayList();
			result.add(0);
			return result;
		}
		List<Integer> result = grayCode(n-1);
		int numToAdd = 1<<(n-1);
		
		for(int i=result.size()-1;i>=0;i--){
			result.add(numToAdd+result.get(i));
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		List<Integer>result = sol.grayCode(2);
		for(int i : result){
			System.out.println(i);
		}
	}

}
