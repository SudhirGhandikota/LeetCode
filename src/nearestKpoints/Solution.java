package nearestKpoints;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * This Program finds k nearest points to origin from a given list of points
 */
class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class PointWithDis{
	Point p;
	double dis;
	
	public PointWithDis(Point p, double dis){
		this.p = p;
		this.dis = dis;
	}
}
public class Solution {

	//Method: returns the Euclidean distance of a point from origin
	public double getDistance(Point p){
		double dis = Math.sqrt(Math.pow((double)(p.x -0), 2) + Math.pow((double)(p.y - 0), 2));
		return dis;
	}
	public Point[] getCloseK(Point[] points, int k){
		System.out.println("Number of Points received:"+points.length);
		PriorityQueue<PointWithDis> kPoints = new PriorityQueue<PointWithDis>(k, new Comparator<PointWithDis>(){
			public int compare(PointWithDis p, PointWithDis q){
				return (int)(p.dis - q.dis);
			}
		});
		PointWithDis[] pointsWithDis = new PointWithDis[points.length];
		int index = 0;
		//calculating distance from origin for all points
		for(Point p: points){
			double dis = getDistance(p);
			pointsWithDis[index++] = new PointWithDis(p,dis);
		}
		for(PointWithDis p: pointsWithDis){
			if(kPoints.size()<k){
				kPoints.offer(p);
			}
			else{
				if(kPoints.peek().dis > p.dis){
					kPoints.poll();
					kPoints.offer(p);
				}
			}
		}
		Point[] res = new Point[k];
		index = 0;
		while(!kPoints.isEmpty()){
			res[index++] = kPoints.poll().p;
		}
		return res;
	}
	public static void main(String[] args) {
		Point[] p = new Point[4];
		p[0] = new Point(3,4);
		p[1] = new Point(6,8);
		p[2] = new Point(12,14);
		p[3] = new Point(24,28);
		Solution sol = new Solution();
		Point[] res = sol.getCloseK(p, 3);
		System.out.println("Length of result:"+res.length);
		for(int i=0;i<res.length;i++){
			System.out.print("x:"+res[i].x+" y:"+res[i].y);
			System.out.println();
		}
	}

}
