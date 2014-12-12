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
		System.out.print(m.numDecodings("111"));
	}
	/*
	 * Recursive method. Error happens when stack exceeded.
	 */
    public int numDecodings(String s) {
    	if(s.length()==0)
    		return 0;
    	char[] ch = s.toCharArray();
    	int[] counter = {0};
    	recursive(ch, 0, counter);
    	
    	return counter[0];
    }
	private void recursive(char[] ch, int i, int[] counter) {
		if(i==ch.length){
			counter[0]++;
			return;
		}
		if(ch[i]>='1' && ch[i]<= '9'){
			this.recursive(ch, i+1, counter);
		}
		if(ch[i]=='1'){
			if(i+1<ch.length && ch[i+1]>='0' && ch[i+1]<= '9')
				this.recursive(ch, i+2, counter);
		}else if(ch[i]=='2'){
			if(i+1<ch.length && ch[i+1]>='0' && ch[i+1]<= '6')
				this.recursive(ch, i+2, counter);
		}
	}
    
}
