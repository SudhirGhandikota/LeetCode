package SameTree;

class TreeNode<T>
{
	T val;
	TreeNode<T> left;
	TreeNode<T> right;
	
	TreeNode(T val)
	{
		this.val = val;
	}
	public void Insert(T val)
	{
		if (left==null)
		{
			left = new TreeNode<T>(val);
			//System.out.println("Left child inserted");
		}
		else if(right==null)
		{
			right = new TreeNode<T>(val);
			//System.out.println("Right child inserted");
		}
		else if(left.left==null||left.right==null)
		{
			left.Insert(val);
			//System.out.println("Inserted at left sub-tree");
		}
		else
		{
			right.Insert(val);
			//System.out.println("Inserted at right sub-tree");
		}
	}
	
	public T getLeft()
	{
		return this.left.val;
	}
	
	public T getRight()
	{
		return this.right.val;
	}
}

class BinaryTree<T>
{
	TreeNode<T> root;
	
	public BinaryTree(T val)
	{
		System.out.println("******Root Inserted******");
		root = new TreeNode<T>(val);
	}
	
	public void insert(T val)
	{
		if(root==null)
			root = new TreeNode(val);
		else
			root.Insert(val);
	}
	
}
public class Solution {

	public static void main(String[] args) throws Exception {
		BinaryTree<Integer> t1 = new BinaryTree(10);
		t1.insert(10);
		t1.insert(20);
		t1.insert(30);
		t1.insert(40);
		//System.out.println("Root is "+t1.root.val);
		//System.out.println("Left child is "+t1.root.getLeft());
		//System.out.println("Right child is "+t1.root.getRight());
		BinaryTree<Integer> t2 = new BinaryTree(10);
		t2.insert(10);
		t2.insert(20);
		t2.insert(30);
		t2.insert(40);
		BinaryTree<Integer> t3 = new BinaryTree(10);
		t3.insert(9);
		t3.insert(8);
		t3.insert(7);
		t3.insert(6);
		
		System.out.println(isSameTree(t1.root,t2.root));
		System.out.println(isSameTree(t2.root,t3.root));
		System.out.println(isSameTree(t1.root,t3.root));
	}
	
	public static boolean isSameTree(TreeNode root1,TreeNode root2)
	{
		if(root1==null && root2==null)
			return true;
	    if(root1==null || root2==null)
	    {
	    	System.out.println("caught here");
	    	return false;
	    }
	    if((root1.left==null)&&(root2.left!=null)||(root1.left!=null)&&(root2.left==null))
	    {
	    	System.out.println("caught here.First root is "+root1.val+" Second root is "+root2.val);
	    	return false;
	    }
	    if((root1.left!=null)&&(root2.left!=null)&&!(root1.left.val.equals(root2.left.val)))
	    {
	    	System.out.println("caught here First root is "+root1.left);
	    	return false;
	    }
	    /*if(root1.right==null || root2.right==null)
	    {
	    	return false;
	    }*/
	    if((root1.right!=null)&&(root2.right!=null)&&!(root1.right.val.equals(root2.right.val)))
	    {
	    	return false;
	    }
	    if(!(isSameTree(root1.left,root2.left)))
	    {
	    	return false;
	    }
	    if(!(isSameTree(root1.right,root2.right)))
	    {
	    	return false;
	    }
		return true;
	}

}
