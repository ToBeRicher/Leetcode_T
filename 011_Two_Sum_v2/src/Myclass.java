import java.util.Arrays;
//速度和第一种用hashmap差不多
class Myclass {
 

	public static void main(String[] args){
		Myclass m = new Myclass();
		int[] numbers = {3,2,4};
		int t = 6;
		for(int i : m.twoSum(numbers,t))
			System.out.println(i);
	}
	
    public int[] twoSum(int[] numbers, int target) {
    	int[] sorted = new int[numbers.length];  
    	System.arraycopy(numbers, 0, sorted, 0, numbers.length);  
    	Arrays.sort(sorted);
    	
    	//先寻找两个数
    	int i = 0, j = numbers.length-1;
    	while(i < j){
    		if(sorted[i]+sorted[j] > target)
    			j--;
    		else if(sorted[i]+sorted[j] < target)
    			i++;
    		else
    			break;
    	}
    	
    	//再找到这两个index
    	boolean isFirstGet = false;
    	int[] rs = new int[2];
    	for(int k=0; k<numbers.length; k++){
    		if(numbers[k]==sorted[i] || numbers[k]==sorted[j]){
    			if( isFirstGet == false){
    				rs[0]=k+1;
    				isFirstGet=true;
    			}
    			else{
    				rs[1]=k+1;
    				break;
    			}
    		}
    	}
    	return rs;
    }
}
