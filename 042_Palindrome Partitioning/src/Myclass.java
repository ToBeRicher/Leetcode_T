import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		m.partition("aab");
	}
    public List<List<String>> partition(String s) {
    	List<List<String>> res = new LinkedList<List<String>>();
    	List<String> temp = new ArrayList<String>();
    	recursive(0, s.toCharArray(), temp, res);
    	return res;
    }
	private void recursive(int current, char[] ch,
			List<String> temp, List<List<String>> res) {
		if(current >= ch.length){
			res.add(new ArrayList<String>(temp));
			return;
		}
		
		for(int i=current; i<ch.length; i++){
			//check palindrome from current to i
			int s = current;
			int e = i;
			boolean isPalin = true;
			while(s<=e){
				if(ch[s] != ch[e]){
					isPalin = false;
					break;
				}
				s++;
				e--;
			}
			
			//if compose palidrome
			if(isPalin){
				StringBuilder sb = new StringBuilder();
				sb.append(ch, current, i-current+1);
				temp.add(sb.toString());
				this.recursive(i+1, ch, temp, res);
				temp.remove(temp.size()-1);
			}
		}
		
	}
}
