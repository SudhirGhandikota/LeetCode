package bstSerialization;

import java.util.StringTokenizer;

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x)
	{
		val =x;
	}
}
public class Solution {
	/*
	 * This class serializes and de-serializes a binary search tree
	 */
	private String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root,sb);
		return sb.toString();
		
	}
	/*
	 * Building the string by doing an in-order traversal of the tree
	 */
	private void buildString(TreeNode node,StringBuilder sb)
	{
		if(node==null)
			sb.append("null,");
		else
		{
			sb.append(node.val+",");
			buildString(node.left,sb);
			buildString(node.right,sb);
		}
	}
	private TreeNode deserialize(String tree)
	{
		if(tree==null)
			return null;
		StringTokenizer st = new StringTokenizer(tree,",");
		return deserialize(st);
	}
	
	/*
	 * This method created tree nodes by traversing through each string in the string tokenizer
	 */
	private TreeNode deserialize(StringTokenizer st)
	{
		if(!st.hasMoreTokens())
			return null;
		String val = st.nextToken();
		if(val.equals("null"))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(val));
		root.left = deserialize(st);
		root.right = deserialize(st);
		//the first recursive calls executes the last and it returns the corresponding root of the tree
		return root;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		Solution sol = new Solution();
		String ser = sol.serialize(root);
		System.out.println("Serialized Tree is:"+ser);
		TreeNode new_root = sol.deserialize(ser);
		System.out.println("De serialize tree:"+sol.serialize(new_root));
		System.out.println();
	}	

}
