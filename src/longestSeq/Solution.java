package longestSeq;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val)
	{
		this.val = val;
	}
}
/*
 * Solution to the Binary Tree Longest Consecutive Sequence Problem
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 * The approach used is to use 2 global variables, one maintaining the current sequence length
 * The other maintaining the current maximum length. it gets updates whenever a longest length sequence is encountered
 */
public class Solution {
	private int maxLen = 0;
	public int longestConsecutive(TreeNode root)
	{
		if(root==null)
			return 0;
		longestConsecutiveHelper(root,1,root.val);
		return maxLen;
	}

	private void longestConsecutiveHelper(TreeNode root, int length, int target) {
		if(root==null)
			return;
		int currLen=0;
		if(root.val==target)
			currLen = length + 1;
		else
			currLen = 1;
		maxLen = Math.max(currLen, maxLen);
		longestConsecutiveHelper(root.left,currLen,root.val+1);
		longestConsecutiveHelper(root.right,currLen,root.val+1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);
		Solution sol = new Solution();
		System.out.println(sol.longestConsecutive(root));

	}

}
