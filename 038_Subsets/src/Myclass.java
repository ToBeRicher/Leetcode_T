import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		int[] S = {1,2,3};
		m.subsets(S);
	}
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>((int)Math.pow(2, S.length));
        Arrays.sort(S);
        List<Integer> item = new ArrayList<Integer>();
        recursive(S, 0, item, res);
        return res;
    }
	private void recursive(int[] s, int cur, List<Integer> item,
			List<List<Integer>> res) {
		if(cur == s.length){
			res.add(new ArrayList<Integer>(item));
			return;
		}
		recursive(s, cur+1, item, res);
		item.add(s[cur]);
		recursive(s, cur+1, item, res);
		item.remove(item.size()-1);
	}
}
