/*
 
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		
	}    
	public int sqrt(int x) {
		int res = 0;
		for(int i=15; i>=0; i--){
			long r = res|(1<<i);
			long r2 = r*r;
			if(r2 <= x)
				res = (int)r;
		}
	
		return res; 
	}
}
