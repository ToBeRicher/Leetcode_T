import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		int[] num = {1};
		m.permute(num);
	}
	
	public List<List<Integer>> permute(int[] num) {
        boolean visited[] = new boolean[num.length];
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        dfs(visited,num,item, res);
		return res;
    }

	private void dfs(boolean[] visited,int[] num, List<Integer> item,
			List<List<Integer>> res) {
		
		if(visited.length == item.size()){
			res.add(new ArrayList<Integer>(item));
			return;
		}
		
		for(int i=0; i<visited.length; i++){
			if(visited[i] == false){
				visited[i] = true;
				item.add(num[i]);
				dfs(visited, num, item, res);
				visited[i] = false;
				item.remove(item.size()-1);
			}
		}
	}
}
