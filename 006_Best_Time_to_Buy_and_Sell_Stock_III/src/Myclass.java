/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/


public class Myclass {
	 public static int maxProfit(int[] prices) {
		 	int length=prices.length;
	        if(length<2)
	            return 0;
	        
	        //regular search the best profit for each day
		 	int[] profit=new int[length];
	        profit[0]=0;
	        int buy=prices[0];
	        for(int i=1;i<length;i++){
		  		buy = buy < prices[i] ? buy : prices[i];
		  		profit[i] = profit[i-1] > prices[i]-buy ? profit[i-1]:  prices[i]-buy;
	        }
	        
	        //reverse search the most profit for each dau
		 	int[] Rprofit=new int[length];
	        Rprofit[length-1]=0;
	        int sell=prices[length-1];
	        for(int i=length-2;i>=0;i--){
	        	sell = sell > prices[i] ? sell : prices[i];
	        	Rprofit[i] = Rprofit[i+1] > sell - prices[i] ? Rprofit[i+1]: sell - prices[i];
	        }
	        int[] PP=new int[length+1];
	        PP[0]=Rprofit[0];
	        PP[length]=profit[length-1];
	        for(int i=1;i<length;i++){
	        	PP[i]=Rprofit[i]+profit[i-1];
	        }
	        int res=0;
	        for(int i=0;i<=length;i++){
	        	res=Math.max(res, PP[i]);
	        }
	        
	        return res;
	        //shift the separation day which means two transactions before and two transaction after the day
  	
	 }
	
	public static void main(String[] args){
		/*int test[] = new int[12000];
		int i;
		for(i=0;i<10000;i++){
			test[i]=10000-i;
		}
		for(;i<12000;i++){
			test[i]=0;
		}
		*/
		int test[]={1,3,2,3,6,2,7};
		int result = maxProfit(test);
		System.out.print(""+result);
	}

}
