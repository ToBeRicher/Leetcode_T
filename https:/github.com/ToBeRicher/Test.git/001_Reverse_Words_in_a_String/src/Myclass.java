
public class Myclass {
	 public static String reverseWords(String s) {
	        if(s==null)
				return s;
			s=s.trim();
			int last_i = s.length();
			if(last_i==0)
			    return "";
			int i=last_i-1;
			StringBuffer sb=new StringBuffer();
			for(;i>0;){
				if(s.charAt(i)==' '){
					sb.append(s.substring(i+1, last_i));
					sb.append(' ');
					do{
						last_i=i;
						i--;
					}while(s.charAt(i)==' ');
				}
				else
					i--;
			}
			sb.append(s.substring(i, last_i));
			String result = sb.toString();
			   return result;
	    }
	public static void main(String[] args){
		String s= " The sky is blue ";
		System.out.print(reverseWords(s));
		
	}
}
