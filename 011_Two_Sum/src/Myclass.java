import java.util.HashMap;
import java.util.Hashtable;
//找到两个数，和为target
class Myclass {
 
 
	public static void main(String[] args){
		Myclass m = new Myclass();
		int[] numbers = {3,2,4};
		int t = 6;
		for(int i : m.twoSum(numbers,t))
			System.out.println(i);
	}
	
	public HashMap<Integer,Integer> ht = new HashMap<Integer,Integer>();
    public int[] twoSum(int[] numbers, int target) {
    	//利用hashMap，遍历到某个数A，先看看map里面有没有为(target-A)的数。如果没有则put A into hashmap
    	for(int i=0;i<numbers.length;i++){
    		if(ht.get(target - numbers[i]) == null){
    			ht.put(numbers[i], i);
    		}else{
    			int rs[] = {ht.get(target - numbers[i])+1,i+1};
    			return rs;
    		}
    	}
    	return null;
    }
}
