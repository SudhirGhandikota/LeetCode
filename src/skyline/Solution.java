package skyline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Solution to 'skyline' leetcode problem
 * https://leetcode.com/problems/the-skyline-problem/
 */
public class Solution {

	class Edge{
		private int x;
		private int height;
		private boolean isLeft;
		
		public Edge(int x, int height, boolean isLeft)
		{
			this.x = x;
			this.height = height;
			this.isLeft = isLeft;
		}
	}
	//sorting the edges
	class EdgeComparator implements Comparator<Edge>
	{
		@Override
		public int compare(Edge a, Edge b) {
			//sorting by the x-coordinate. Lowest the first
			if(a.x!=b.x)
				return a.x - b.x;
			//if both are left edges and have the same x-coordinates, greater height should be lower
			if(a.isLeft && b.isLeft)
				return b.height - a.height;
			//if both are right edge and having the same x-coordinates, lower the first
			if(!a.isLeft && !b.isLeft)
				return a.height - b.height;
			//first edge should be first
			return a.isLeft ? -1 : 1;
		}
	}
	public List<int[]> getSkyLine(int[][] buildings)
	{
		List<int[]> result = new ArrayList();
		if(buildings==null || buildings.length==0 || buildings[0].length==0)
			return result;
		List<Edge> list = new ArrayList();
		//max heap(with highest element first)
		PriorityQueue<Integer> pq = new PriorityQueue<>(1000,Collections.reverseOrder());
		//splitting the buildings into separate edges(left and right)
		for(int[] building: buildings)
		{
			Edge leftEdge = new Edge(building[0],building[2],true);
			list.add(leftEdge);
			Edge rightEdge = new Edge(building[1],building[2],false);
			list.add(rightEdge);
		}
		//sorting the edges according to left coordinate
		Collections.sort(list, new EdgeComparator());
		pq.offer(0);
		int prev=0;
		//iterated all sorted edges
		for(Edge edge: list)
		{
			//if we come across a left edge
			if(edge.isLeft)
				pq.offer(edge.height);
			else
				pq.remove(edge.height);
			int curr = pq.peek();
			if(curr!=prev)
			{
				result.add(new int[]{edge.x,curr});
				prev = curr;
			}		
		}
		return result;
	}
	public static void main(String[] args) {
		int[][] buildings = new int[5][3];
		buildings[0] = new int[]{2,9,10};
		buildings[1] = new int[]{3,7,15};
		buildings[2] = new int[]{5,12,12};
		buildings[3] = new int[]{15,20,10};
		buildings[4] = new int[]{19,24,8};
		Solution sol = new Solution();
		List<int[]> sorted = sol.getSkyLine(buildings);
		System.out.println("Sorted list:");
		for(int g[]: sorted)
		{
			System.out.print("x:"+g[0]+" height:"+g[1]);
			System.out.println();
		}

	}

}
