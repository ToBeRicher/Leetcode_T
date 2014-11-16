import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


class Myclass {
 /*
  * 这种方法的复杂度是n^2
  */

	public static void main(String[] args){
		Myclass m = new Myclass();
		String elements[] = {"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
		//String elements[] = {"hot","cog","dot","dog","hit","lot","log"};
		Set<String> dict = new HashSet<String>(Arrays.asList(elements));
		long start = System.currentTimeMillis();
		System.out.println(m.ladderLength("nape","mild", dict));
		//System.out.println(m.ladderLength("hit","cog", dict));
		System.out.println(System.currentTimeMillis() - start + " Millis");
		
	}
    public int ladderLength(String start, String end, Set<String> dict) {
    	if(start.length()==1)
    		return 2;
    	String[] strs = dict.toArray(new String[dict.size()]);
    	HashMap<String, Integer> hs = new HashMap<String, Integer>();
    	
    	//put the dictionary to HashMap, that key is string, and value is used for BFS mark(0: not searched, 1: searched)
    	for(String s: strs)
    		hs.put(s, 0); 
    	hs.put(start,1); 
    	
    	// BFS need a queue
    	Queue<String> q = new LinkedList<String>();
    	q.add(start);
    	
    	while(q.size() > 0){
    		String currentStr = q.poll();
    		for(int i=0; i<start.length(); i++){
    			for(int j=0; j<26; j++){
    				String targetStr = generateTarget(currentStr,i,j);
    				if(targetStr.equals(end))
    					return hs.get(currentStr)+1;
    				if(hs.get(targetStr) != null && hs.get(targetStr) == 0){
    					//System.out.print(targetStr+ " ");
    					q.add(targetStr);
    					hs.put(targetStr, hs.get(currentStr)+1);
    				}
    			}
    		}
    	}
    	return 0;
    }
	private String generateTarget(String str, int i, int j) {
		char[] c = str.toCharArray();
		c[i] = (char) ('a'+j);
		return String.valueOf(c);
	}
}
