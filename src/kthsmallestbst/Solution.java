package kthsmallestbst;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val)
	{
		this.val = val;
	}
}
public class Solution {

	int counter = 0;
	boolean found = false;
	int res = 0;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(40);
		TreeNode leftroot = root.left = new TreeNode(20);
		TreeNode rightroot = root.right = new TreeNode(60);
		leftroot.left = new TreeNode(10);
		leftroot.right = new TreeNode(30);
		rightroot.left = new TreeNode(50);
		rightroot.right = new TreeNode(70);
		Solution sol = new Solution();
		sol.display(root);
		System.out.println(sol.KthSmallest(root, 5));
	}
	public int KthSmallest(TreeNode root,int k)
	{
		if(root==null)
			return 0;
		KthSmallestHelper(root,k);
		return res;
	}
	public void KthSmallestHelper(TreeNode root,int k)
	{
		if(root == null)
			return;
		if(!found)
			KthSmallestHelper(root.left,k);
		counter++;
		if(counter==k)
		{
			found = true;
			res = root.val;
		}
		if(!found)
			KthSmallestHelper(root.right,k);
	}
	public void display(TreeNode root)
	{
		TreeNode node = root;
		System.out.println("********LEFT TREE******");
		while(node!=null)
		{
			System.out.print(node.val+"->");
			node = node.left;
		}
		node = root;
		System.out.println();
		System.out.println("********RIGHT TREE******");
		while(node!=null)
		{
			System.out.print(node.val+"->");
			node = node.right;
		}
	}
}
