/*
 * pow(x,n) returns x^n
 */

class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		System.out.print(m.pow(2,-4));
	}
	public double pow(double x, int n) {
       if(n==0)
			return 1.0;
       if(x==0)
			return 0;
        double res=1;
        if(n>0){
    		double temp=x;
	        while(n>0){
	            if(n%2==1)
	            	res*=temp;
	            n=n/2;
	            temp*=temp;
	        }
        }else{
    		 double temp=1/x;
        	 while(n<0){
 	            if(n%2==-1)
 	            	res*=temp;
 	            n=n/2;
 	            temp*=temp;
 	        }
        }
        
        return res;
    }
}
