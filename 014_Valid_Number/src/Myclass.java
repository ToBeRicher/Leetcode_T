class Myclass {
	//too hard

	public static void main(String[] args){
		Myclass m = new Myclass();
		System.out.print(m.isNumber(" +1.e-11 "));
	}
	public boolean isNumber(String s) {
		
		if(s.contains("e")){
			String[] strs = s.split("e", 2);
        	String front = this.removeFrontSpace(strs[0]);
        	String back = this.removeBackSpace(strs[1]);
        	if(back.startsWith("+") || back.startsWith("-"))
        		back = back.substring(1, back.length());
        	if(front.length() == 0 || back.length() == 0)
        		return false;
        	front = this.removeFrontSpace(front);
        	return this.checkFraction(front) && this.checkUnsignedInt(back);
		}
		
		s = this.removeFrontSpace(s);
		s = this.removeBackSpace(s);
		if(s.length()==0)
			return false;
        return checkFraction(s);
    	
    }
	
	private boolean checkFraction(String s){
		if(s.contains(".")==false)
			return checkUnsignedInt(s);
    	String[] strs = s.split("\\.", 2);
    	String front = strs[0];
    	String back = strs[1];
    	if(front.length()==0 && back.length() == 0){
    		return false;
    	}else{
    		return this.checkUnsignedInt(front) && this.checkUnsignedInt(back);
    	}
	}
	private String removeFrontSpace(String s){
		char[] ch = s.toCharArray();
		int i=0;
		while(i<ch.length){ //jump all spaces: ' '
			if(ch[i]!= ' ')
				break;
			i++;
		}
		if(i<ch.length){
			if(ch[i]=='-'|| ch[i]=='+')
				i++;
		}
		return s.substring(i,s.length());// if i==ch.length, means this char[] ch are all space
	}
	
	private String removeBackSpace(String s){
		char[] ch = s.toCharArray();
		int i=ch.length-1;
		while(i>=0){ //jump all spaces: ' '
			if(ch[i]!= ' ')
				break;
			i--;
		}
		if(i==-1)
			return "";
		return s.substring(0,i+1); // if i==-1, means this char[] ch are all space
	}
	private boolean checkUnsignedInt(String s) {
		char[] ch = s.toCharArray();
		int i=0;
		while(i<ch.length){
			char c = ch[i];
			if(c<'0' || c>'9')
				return false;
			i++;
		}
		return true;
	}
}
