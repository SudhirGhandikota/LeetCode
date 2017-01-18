package isSubTree;

class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
public class Solution {
	public String inOrder(Node root){
		if(root==null)
			return "";
		return inOrder(root.left) + " " + inOrder(root.right);
	}
	public String postOrder(Node root){
		if(root==null)
			return "";
		return postOrder(root.left) + " " + postOrder(root.right);
	}
	public boolean checkSubTree(Node root1, Node root2){
		String inorder_1 = inOrder(root1);
		String inorder_2 = inOrder(root2);
		String postorder_1 = postOrder(root1);
		String postorder_2 = postOrder(root2);
		return (inorder_1.toLowerCase().contains(inorder_2.toLowerCase()) && postorder_1.toLowerCase().contains(postorder_2.toLowerCase()));
	}
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" "+root.data);
			display(root.right);
		}
	}
	public static void main(String[] args) {
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(4);
		root1.left.left = new Node(3);
		root1.left.right = new Node(6);
		root1.right.left = new Node(5);
		
		Node root2 = new Node(4);
		root2.left = new Node(5);
		root2.right = new Node(6);
		Solution sol = new Solution();
		System.out.print(" Tree 1: ");
		sol.display(root1);
		System.out.print(" Tree 2: ");
		sol.display(root2);
		System.out.println();
		System.out.println(sol.checkSubTree(root1, root2));

	}

}
