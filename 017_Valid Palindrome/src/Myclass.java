class Myclass {
 

	public static void main(String[] args){
		Myclass m = new Myclass();
		System.out.print(m.isPalindrome("a,"));
	}
    public boolean isPalindrome(String s) {
    	if(s==null || s.equals(""))
    		return true;
    	int i=0, j=s.length()-1;
        while(i<j){
        	if(Character.isLetterOrDigit(s.charAt(i))){
        		if(Character.isLetterOrDigit(s.charAt(j))) {
	        		if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
	        			return false;
	        		i++;
	        		j--;
        		}else{
        			j--;
        		}
        	}else{
        		i++;
        	}
        }
    	return true;
    }
}
