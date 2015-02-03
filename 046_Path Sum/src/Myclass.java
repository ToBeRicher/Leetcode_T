/*
 
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		
	}
	public boolean hasPathSum(TreeNode root, int sum) {
    	if(root==null)
    		return false;
    	return dfs(root,sum);
    }
	private boolean dfs(TreeNode root, int sum) {
        if(root==null)
        	return false;
        sum -= root.val;
        if(root.left==null && root.right==null)
        	return sum==0;
        return hasPathSum(root.left, sum) || hasPathSum(root.right,sum);
	}
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
