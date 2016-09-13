package zigzagIterator;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<Integer>v1 = new ArrayList();
	private List<Integer>v2 = new ArrayList();
	int i=0;
	int j=0;
	int listID=0;

	public Solution(List<Integer>list1, List<Integer>list2)
	{
		this.v1 = list1;
		this.v2 = list2;
	}
	public boolean hasNext()
	{
		return (i<v1.size()||j<v2.size());
	}
	public int next()
	{
		int result = 0;
		if(i>=v1.size())
		{
			result = v2.get(j);
			j++;
		}
		else if(j>=v2.size())
		{
			result = v1.get(i);
			i++;
		}
		else if(listID==0)
		{
			result = v1.get(i);
			i++;
			listID = 1;
		}
		else if(listID==1)
		{
			result = v2.get(j);
			j++;
			listID = 0;
		}
		return result;
	}
	public static void main(String[] args) {
		List<Integer> v1 = new ArrayList();
		v1.add(1);
		v1.add(2);
		List<Integer> v2 = new ArrayList();
		v2.add(3);
		v2.add(4);
		v2.add(5);
		v2.add(6);
		Solution iterator = new Solution(v1,v2);
		while(iterator.hasNext())
		{
			System.out.print(iterator.next()+"->");
		}

	}

}
