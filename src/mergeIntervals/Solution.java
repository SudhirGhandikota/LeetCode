package mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval{
	int start;
	int end;
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
	Interval()
	{
		start = 0;
		end = 0;
	}
	public String toString()
	{
		return "start:"+start+" end:"+end;
	}
}
/*
 * Solution to Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 */
public class Solution {
	
	public List<Interval> merge(List<Interval> list)
	{
		List<Interval> res = new ArrayList();
		if(list==null || list.size()==0)
			return res;
		Collections.sort(list, new IntervalComparator());
		Interval pre = list.get(0);
		for(int i=1;i<list.size();i++)
		{
			Interval curr = list.get(i);
			//if 'start' of second interval is greater than the 'end' of first interval(disjoint intervals) they cannot be merged
			if(curr.start>pre.end)
			{
				res.add(pre);
				pre = curr;
			}
			//case where intervals overlap
			else
			{
				//since the intervals are already sorted, we can use the 'start' of the first interval
				Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
				pre = merged; // we will not add the merged interval here as there might be chance it can be merged with the next one
			}
		}
		res.add(pre);
		return res;
	}
	public static void main(String[] args) {
		List<Interval> list = new ArrayList();
		List<Interval> res;
		Interval int1 = new Interval(1,3);
		list.add(int1);
		Interval int2 = new Interval(2,6);
		list.add(int2);
		Interval int3 = new Interval(8,10);
		list.add(int3);
		Interval int4 = new Interval(15,18);
		list.add(int4);
		res = new Solution().merge(list);
		for(Interval i:res)
		{
			System.out.println(i);
		}

	}

}
//comparator to compare and sort to intervals
class IntervalComparator implements Comparator<Interval>
{

	@Override
	public int compare(Interval int1, Interval int2) {
		if(int1.start!=int2.start)
			return int1.start - int2.start; //interval with the smallest 'start' is considered smallest
		return int1.end - int2.end; //if both 'start' values same then sort based on the 'end' values
	}
	
}
