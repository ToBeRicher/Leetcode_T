import java.util.Stack;

/*
	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
	
	An example is the root-to-leaf path 1->2->3 which represents the number 123.
	
	Find the total sum of all root-to-leaf numbers.
	
	For example,
	
	    1
	   / \
	  2   3
	The root-to-leaf path 1->2 represents the number 12.
	The root-to-leaf path 1->3 represents the number 13.
	
	Return the sum = 12 + 13 = 25.
 */
class Myclass {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args){
		Myclass m = new Myclass();
	}
    public int sumNumbers(TreeNode root) {
    	if(root == null)
    		return 0;
    	if(root.left==null && root.right==null)
    		return root.val;

    	int sum = 0;
    	if(root.left != null)
    		sum += sum(root.left, root.val);
    	if(root.right != null)
    		sum += sum(root.right, root.val);
    	return sum;
    }
	private int sum(TreeNode root, int val) {
		if(root.left == null && root.right == null)
			return root.val+val*10;
		else if(root.left != null && root.right == null)
			return sum(root.left, root.val+val*10);
		else if(root.left == null && root.right != null)
			return sum(root.right, root.val+val*10);
		else //if(root.left == null && root.right == null)
			return sum(root.left, root.val+val*10) + sum(root.right, root.val+val*10);
	}
}
