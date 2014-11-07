class Myclass {
 

	public static void main(String[] args){
		Myclass m = new Myclass();
		int[] A = {0,0,0};
		int[] B = {1};
		m.merge(A, 0, B, B.length);
		System.out.print(true);
	}
    public void merge(int A[], int m, int B[], int n) {
    	if(n==0)
    		return;
        int idA = m-1;
        int idB = n-1;
        while(idB>=0 && idA>=0){
        	if(A[idA] > B[idB]){
        		A[idA+idB+1]=A[idA];
        		idA--;
        	}else{
        		A[idA+idB+1] = B[idB];
        		idB--;
        	}
        }
        while(idB>=0){
    		A[idA+idB+1] = B[idB];
    		idB--;
        }
        return;
    }
}
