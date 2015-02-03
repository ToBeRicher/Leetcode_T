/*
 
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		
	}
    public int reverse(int x) {
        long y = 0;
        int neg = x<0 ? -1:1;
        x *= neg;
        while(x>0){
            y=y*10+x%10;
            x/=10;
        }
        if(y>2147483647)
            return 0;
        return (int)y*neg;
    }
}
