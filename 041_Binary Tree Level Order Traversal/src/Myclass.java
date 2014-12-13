import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t2.left = t3;
		m.levelOrder(t1);
		
	}

	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		List<TreeNode> s = new LinkedList<TreeNode>();
		List<TreeNode> sp= new LinkedList<TreeNode>(); //previous stack
		s.add(root);
		while(true){
			List<TreeNode> tmp = sp;
			sp = s;
			s = tmp;
			s.clear();
			if(sp.size() == 0)
				break;
			Iterator<TreeNode> it = sp.iterator();
			res.add(new LinkedList<Integer>());
			
			while(it.hasNext()){
				TreeNode tree = it.next();
				res.get(res.size()-1).add(tree.val);
				if(tree.left != null){
					s.add(tree.left);
				}
				if(tree.right != null){
					s.add(tree.right);
				}
			}
		}
		return res;
	}
	
}
