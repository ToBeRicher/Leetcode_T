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
	 * Loop methoed
	 */
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(n >= k){
	        int [] comb = new int[k];
	        setAsIncreasingArray(comb,0);//initialize from comb[0]
	        do{
	        	List<Integer> al = new ArrayList<Integer>();
	        	for(int i:comb){
	        		al.add(i);
	        	}
	        	list.add(al);
	        }while(update(comb,n));
        }
        return list;
    }
	
	private boolean update(int[] comb, int n) {
		int p = comb.length-1;
		int maxValueOfComb0 = n - comb.length + 1;
		while(p >=0){
			comb[p]++;
			if(comb[p] <= maxValueOfComb0 + p)
				break;
			else
				p--;
		}
		
		if(p==-1){
			return false;
		}else{
			if(p < comb.length-1)
				setAsIncreasingArray(comb,p+1);
			return true;
		}
	}
	
	private void setAsIncreasingArray(int[] a, int start){
		if(start == 0){
			a[0] = 1;
			start = 1;
		}
		for(int i = start; i < a.length; i++){
        	a[i] = a[i-1]+1;
        }
	}
	
}
