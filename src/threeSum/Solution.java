package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		List<List<Integer>> res = new ArrayList();
		int n[] = {-2,0,1,1,2};
		res = threeSum(n);
		for(List<Integer>triple:res)
		{
			System.out.print("{");
			for(int num:triple)
				System.out.print(num+",");
			System.out.println("} ");
		}

	}

	private static List<List<Integer>> threeSum(int[] n) {
		List<List<Integer>> res = new ArrayList();
		if(n.length<3)
			return res;
		Arrays.sort(n);
		//outer loop iterates till 3rd last element
		for(int i=0;i<n.length-2;i++)
		{
			//to avoid solutions.
			if(i==0||n[i]!=n[i-1])
			{
				int negsum = -n[i];
				int start = i+1;
				int end = n.length-1;
				//inner loop iterates over all the remaining elements to find the 
				while(start<end)
				{
					if(n[start]+n[end]==negsum)
					{
						List<Integer> temp = new ArrayList();
						temp.add(n[i]);
						temp.add(n[start]);
						temp.add(n[end]);
						
						res.add(temp);
						start++;
						end--;
						//to avoid duplicate solutions
						while(start<end && n[end]==n[end+1])
							end--;
						while(start<end && n[start]==n[start-1])
							start++;
					}
					else if(n[start]+n[end]<negsum)
						start++;
					else if(n[start]+n[end]>negsum)
						end --;
				}
			}
		}
		return res;
	}

}
