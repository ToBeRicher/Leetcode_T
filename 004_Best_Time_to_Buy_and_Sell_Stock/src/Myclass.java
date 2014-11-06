//Given an array of integers, every element appears three times except for one. Find that single one.
public class Myclass {
	 public static int maxProfit(int[] prices) {
		 int length=prices.length;
	        if(length<2)
	            return 0;
	        int profit=0;
	        int buy=prices[0];
     	for(int i=1;i<length;i++){
     		buy = buy < prices[i] ? buy : prices[i];
     		profit = profit > prices[i]-buy ? profit:  prices[i]-buy;
     	}
	        return profit;
	 }
	
	public static void main(String[] args){
		int test[] = {1,4,2};
		int result = maxProfit(test);
		System.out.print(""+result);
	}
}