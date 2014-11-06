//Given an array of integers, every element appears three times except for one. Find that single one.
public class Myclass {
	 public static int maxProfit(int[] prices) {
		int length=prices.length;
        if(length<2)
            return 0;
        int buy;
        int sell;
        int profit=0;
     	int i=0;
	        while(i<length-1){
	        	while( i<length-1 && prices[i] >= prices[i+1] )//low peak of wave
	        		i++;
	        	buy=prices[i];
	        	while(i<length-1 && prices[i] <= prices[i+1])//high peak of wave
	        		i++;
	        	sell=prices[i];
	        	profit+=sell-buy;
	        }
	        return profit;
	        
	 }
	
	public static void main(String[] args){
		int test[] = {1,2,1,2,12,3,1,4};
		int result = maxProfit(test);
		System.out.print(""+result);
	}
	/*
	 int length=prices.length;
	        if(length<2)
	            return 0;
	        int buy=prices[0];
	        int profit=0;
        	int i=0;
	        while(true){
	        	//searching buy time, until prices[i]<prices[i+1]
	        	while( i< length-1 && prices[i] > prices[i+1] )
	        		i++;
	        	buy=prices[i];
	        	i++;
	        	//searching sell time(may not exist)
	        	for(int j=i;j<length;j++){
	        		int profit_temp=prices[j]-buy;
	        		profit = profit > profit_temp ? profit : profit_temp;
	        	}
	        	
	        	if(i>=length-2){//when buy time is the latest day //break
	        		break;
	        	}
	        }
	        return profit;
	 * */
}
