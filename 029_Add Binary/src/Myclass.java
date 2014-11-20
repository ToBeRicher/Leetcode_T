/*
 Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		System.out.print(m.addBinary("1101", "1"));
	}
    public String addBinary(String a, String b) {
    	//make sure that c1.length < c2.length
    	char [] c1;
    	char [] c2;
    	if(a.length()<b.length()){
    		c1 = a.toCharArray();
    		c2 = b.toCharArray();
    	}else{
    		c1 = b.toCharArray();
    		c2 = a.toCharArray();
    	}
    	
    	char carry = 0;
    	int j = c2.length-1;
    	for(int i = c1.length-1; i >= 0; i--,j--){
    		int sum = c1[i]+c2[j]+carry - '0'*2;
			c2[j] = (char) ((sum%2) + '0');
			carry = (char) (sum/2);
    	}
    	
    	while(carry == 1){
    		if(j == -1){
    			return "1".concat(String.valueOf(c2));
    		}
    		if(c2[j] == '0'){
    			c2[j] = '1';
    			break;
    		}else{// == '1'
    			c2[j] = '0';
    		}
    		j--;
    	}
        
    	return String.valueOf(c2);
    }
}
