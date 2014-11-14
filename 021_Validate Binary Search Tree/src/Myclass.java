/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

 */

class Myclass {
 
	public static void main(String[] args){
		Myclass m = new Myclass();
		
	}
	
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	 public boolean isValidBST(TreeNode root) {
		if(root==null)
			return true;
    	return isValid(root.left,(long)Integer.MIN_VALUE-1,root.val) && isValid(root.right,root.val,(long)Integer.MAX_VALUE+1);
     }

	 private boolean isValid(TreeNode node, long min, long max) {
		if(node == null)
			return true;
		if(node.val <= min || node.val >= max){
				return false;
		}
		if(min<=Integer.MIN_VALUE || max>=Integer.MAX_VALUE)
			return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
		else
			return isValid(node.left, (int)min, (int)node.val) && isValid(node.right, (int)node.val, (int)max);
	 }
	 
	 private boolean isValid(TreeNode node, int min, int max) {
		if(node == null)
			return true;
		if(node.val <= min || node.val >= max){
				return false;
		}
		return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
	}
	
}
