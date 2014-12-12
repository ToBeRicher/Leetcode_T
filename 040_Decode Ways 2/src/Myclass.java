/*
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		System.out.print(m.numDecodings("124436203451111133412111141"));
	}
	/*
	 * DP method.
	 */
    public int numDecodings(String s) {
    	char[] ch = s.toCharArray();
    	if(ch.length==0 || ch[0]=='0')
    		return 0;
    	if(ch.length == 1)
    		return 1;
    	int[] dp = new int[ch.length];
    	
    	dp[0] = 1;
    	if(ch[1]=='0'){
    		if(ch[0]=='1' ||ch[0]=='2')
    			dp[1] = 1;
    	}else{
    		if(ch[0] == '1' || ch[0]=='2' && ch[1]<='6')
    			dp[1] = 2;
    		else
        		dp[1] = 1;
    	}
    	
    	for(int i=2; i<ch.length; i++){
    		if(ch[i]>='1'){
    			dp[i] = dp[i-1];
    			if(ch[i-1]=='1'){
    				dp[i]+=dp[i-2];
    			}else if(ch[i-1]=='2' && ch[i]<='6'){
    				dp[i]+=dp[i-2];
    			}
    		}else{// ch[i]=='0'
    			if(ch[i-1]=='1'||ch[i-1]=='2'){
    				dp[i] = dp[i-2];
    			}
    		}
    	}
		return dp[dp.length-1];
	}
    
}
