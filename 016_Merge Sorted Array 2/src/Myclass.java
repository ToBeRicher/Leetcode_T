class Myclass {
 

	public static void main(String[] args){
		Myclass m = new Myclass();
		int[] A = {1,3,4,5,0,0};
		int[] B = {4};
		m.merge(A, 4, B, 1);
		System.out.print(true);
	}
    public void merge(int A[], int m, int B[], int n) {
    	if(n==0)
    		return;
        int c = 0;
        int[] index =new int[n+1];
        for(int i=0;i<n;i++){
        	while(c<m && A[c]<B[i]){
        		c++;
        	}
        	index[i]=c+i;
        }
        index[n] = m + n-1;
        int idA = m-1;

    	int j = index[n];
        while(j>index[n-1]){
    		A[j] = A[idA];
			idA--;
			j--;
        }
        
        for(int i=n-1;i>=0;i--){ 
        	while(j>index[i]){
        		A[j] = A[idA];
				idA--;
        		j--;
        	}
        	A[j]= B[i];
        	j--;
        }
    }
}
