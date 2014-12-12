import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		long ts = System.currentTimeMillis();
		m.combine(22, 11);
		long te = System.currentTimeMillis();
		System.out.print(te-ts);
	}
	/*
	 * DFS methoed
	 */
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(n >= k){
        	ArrayList<Integer> item = new ArrayList<Integer>(); 
        	int currentNum = 1;
	        dfs(n, k, currentNum, item, list);
        }
        return list;
    }
	private void dfs(int n, int k, int currentNum,
			ArrayList<Integer> item, List<List<Integer>> list) {
		if(item.size() == k){
			list.add(new ArrayList<Integer>(item));
			return;
		}
		for(int i=currentNum;i<= (n - (k - item.size())+1);i++){
            item.add(i);
            dfs(n,k,i+1,item,list);
            item.remove(item.size()-1);
        }
		
	}
	
}
