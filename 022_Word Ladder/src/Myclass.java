import java.util.Arrays;
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
		Set<String> dict = new HashSet<String>(Arrays.asList(elements));
		long start = System.currentTimeMillis();
		System.out.println(m.ladderLength("nape","mild", dict));
		System.out.println(System.currentTimeMillis() - start + "Millis");
		
	}
    public int ladderLength(String start, String end, Set<String> dict) {
    	String[] strs = dict.toArray(new String[dict.size()]);
    	/*
    	 * Build a graph
    	 */
    	Node[] nodes = getNodes(strs, start, end);
    	nodes = getSides(nodes);
    	Queue<Node> q = new LinkedList<Node>();
    	
    	/*
    	 * BFS
    	 */
    	nodes[nodes.length-1].sides.clear();//clear sides of end Node
    	q.add(nodes[nodes.length-2]);//push start Node to queue
    	nodes[nodes.length-2].searched = true;
    	
    	int dist=1;
    	while(q.size()>0){
    		Node n = q.poll();
    		
    		int i=0;
    		//System.out.println("search: "+n.str);
    		while(i < n.sides.size()){
    			if(n.sides.get(i).str == nodes[nodes.length-1].str)
        			return dist;
    			
    			if(!n.sides.get(i).searched){
    				//System.out.println("    add: "+ n.sides.get(i).str);
    				q.add(n.sides.get(i));
    				n.sides.get(i).searched = true;
    			}
    			i++;
    		}
    		dist++;
    	}
		return 0;
    }
    
    
    /*
     * Create N+2 Node object, the (n+1)th Node is start node, (n+2)th Node is end node;
     */
    private Node[] getNodes(String[] str, String start, String end){
    	int n = str.length;
    	if(n==0)
    		return null;
    	Node nodes[] = new Node[n+2];
    	for(int i=0; i<n; i++){
    		nodes[i] = new Node(str[i]);
    	}
    	nodes[n] = new Node(start);
    	nodes[n+1] = new Node(end);
		return nodes;
    }
    
    /*
     * Link each Node to build a graph
     */
    private Node[] getSides(Node[] nodes){
    	for(int i=0; i<nodes.length; i++){
    		for(int j=0; j<nodes.length; j++){
    			if(nodes[i].isNeighborOf(nodes[j])){
    				nodes[i].add(nodes[j]);
    			}
    		}
    	}
    	return nodes;
    }
    /*
     * Find a node.str that equals to input str
     */
    private Node findNode(Node[] nodes, String str){
    	for(int i=0; i<nodes.length; i++){
    		if(nodes[i].str == str)
    			return nodes[i];
    	}
    	return null;
    }
    
    class Node{
    	String str;
    	LinkedList<Node> sides = new LinkedList<Node>();
    	boolean searched = false;
    	
    	public Node(){
    	}
    	public Node(String str){
    		this.str=str;
    	}
    	public boolean isNeighborOf(Node node){
    		char[] c1 = str.toCharArray();
    		char[] c2 = node.str.toCharArray();
    		int differences = 0;
    		for(int i=0; i<c1.length; i++){
    			if(c1[i] != c2[i]){
    				differences++;
    			}
    		}
    		if(differences==1) 
    			return true;
    		else			// if diff==0, DO NOT link them.
    			return false;
    	}
    	public void add(Node node){
    		sides.add(node);
    	}
    }
}
