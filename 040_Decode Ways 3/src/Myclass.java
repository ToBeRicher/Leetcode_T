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
		System.out.print(m.numDecodings("10"));
	}
	/*
	 * optimized DP method.
	 */
    public int numDecodings(String s) {
    	char[] ch = s.toCharArray();
    	if(ch.length==0 || ch[0]=='0')
    		return 0;
    	int c=1,p=1,pp=1;
    	for(int i=1; i<ch.length;i++){
    		pp=p;
    		p=c;
    		c = (ch[i]=='0' ) ?  0:p;
			if(ch[i-1] =='1'|| ch[i-1]=='2'&&ch[i]<='6'){
				c += pp;
			}
    	}
    	
		return c;
	}
    
}
