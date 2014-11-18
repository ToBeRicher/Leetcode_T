class Myclass {
 

	public static void main(String[] args){
		Myclass m = new Myclass();
		System.out.print(m.strStr("tesrretest", "test"));
	}
	public int strStr(String haystack, String needle) {
		//two special cases
		if(needle.equals(""))
			return 0;
		if(haystack.equals(""))
			return -1;
		
		char[] h = haystack.toCharArray();
		char[] n = needle.toCharArray();
		int i=0;
		while(i<= h.length-n.length){
			//check the first char
			if(h[i]==n[0]){
				int j=0;
				while(j<n.length){
					if(h[i+j] != n[j])
						break;
					j++;
				}
				if(j==n.length)
					return i;
			}
			i++;
		}
		return -1;
    }
}
