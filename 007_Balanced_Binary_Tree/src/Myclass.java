//Given a binary tree, determine if it is height-balanced.
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; 
      }
     }
/*Submission Result: Wrong Answer

Input:	{2,1,3}
Output:	false
Expected:	true
*/

public class Myclass {

	static boolean res=true;
	public int depth_find(TreeNode root){
		
		if(root==null){
			return 0;
		}
		else{
			int L=depth_find(root.left);
			int R=depth_find(root.right);
			int temp=Math.abs(L-R);
			if(temp>1){
				res=false;
			}
				return 1+(L>R?L:R);
		}
	}
	 public boolean isBalanced(TreeNode root) {
	    int temp=depth_find(root);
	    System.out.print(""+res+"  "+temp);
	    return res;

    }
	
	public static void main(String[] args){
		TreeNode[] T= new TreeNode[3];
		T[0]=new TreeNode(0);
		T[1]=new TreeNode(1);
		T[2]=new TreeNode(2);
		//T[3]=new TreeNode(3);
		T[0].left=T[1];
		T[0].right=T[2];
		//T[2].left=T[3];
		
		Myclass Me=new Myclass();
		System.out.print(res=Me.isBalanced(T[0]));
	}
}
