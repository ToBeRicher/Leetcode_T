import java.util.Stack;

class Myclass {
 

	public static void main(String[] args){
		Myclass m = new Myclass();
		System.out.print(m.isValid("{(})}"));
	}

    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Integer> q = new Stack<Integer>();
        for(int c : ch){
        	if(c=='('||c=='['|c=='{'){
        		q.add(c);
        	}else{
        		if(q.size()==0)
        			return false;
        		int temp=q.pop();
        		if(temp=='('&& c==')'
        			||temp=='['&&c==']'
        			||temp=='{'&&c=='}')
        			continue;
        		else
        			return false;
        	}		
        }
        if(q.size()>0)
        	return false;
    	return true;
    }
}
