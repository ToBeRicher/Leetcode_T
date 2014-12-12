import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		String [] strs = {"tea","and","ate","eat","den"};
		m.anagrams(strs);
	}
	public List<String> anagrams(String[] strs) {
        List<String> resList = new LinkedList<String>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String s: strs){
        	char[] ch = s.toCharArray();
        	Arrays.sort(ch);
        	String sorted = String.valueOf(ch);
        	if(map.containsKey(sorted)){
        		map.get(sorted).add(s);
        	}else{
        		List<String> temp = new LinkedList<String>();
        		temp.add(s);
        		map.put(sorted, temp);
        	}
        }
        
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
        	List<String> l = map.get(it.next());
        	if(l.size() > 1){
        		resList.addAll(l);
        	}
        }
        
        return resList;
    }
}
