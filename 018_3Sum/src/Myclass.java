import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Myclass {
	//数组里面找出3个数之和为0，找出所有这样的组合，并且不能重复。
	public static void main(String[] args){
		Myclass m = new Myclass();
		int[] n = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		m.threeSum(n);
		System.out.print("test");
	}
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		for(int i=0; i<num.length-1; i++){
			if(i>0 && num[i]==num[i-1])
				continue;
			int k=num.length-1;
			int j = i+1;
			while(j < k){
				if(num[k] + num[j] + num[i] == 0){
					List<Integer> l = new ArrayList<Integer>();
					l.add(num[i]);
					l.add(num[j]);
					l.add(num[k]);
					ll.add(l);
					k--;
					j++;
					while(k>=0 && num[k]==num[k+1])
						k--;
					while(j<num.length && num[j]==num[j-1])
						j++;
				}else if(num[k] + num[j] + num[i] > 0){
					k--;
				}else if(num[k] + num[j] + num[i] < 0){
					j++;
				}
			}
		}
		int i=1;
		while(i<ll.size()){
			if(ll.get(i-1).equals( ll.get(i))){
				ll.remove(i);
				continue;
			}
			i++;
		}
		return ll;
    }
}
