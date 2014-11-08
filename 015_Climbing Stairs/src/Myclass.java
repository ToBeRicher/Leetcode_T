class Myclass {
 
	//一次只能走1或者2梯，n梯有多少种？
	public static void main(String[] args){
		Myclass m = new Myclass();
		
	}

    public int climbStairs(int n) {
    	if(n<=1)
    		return 1;
    	if(n==2)
    	    return 2;
        int[] d = new int[n+1];
        d[1] = 1;
        d[2] = 2;
        for(int i=3; i< n+1;i++){
        	d[i] = d[i-1]+d[i-2];
        }
        return d[n];
    }
}
