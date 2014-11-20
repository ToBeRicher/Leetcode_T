/*
 Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		int[] A = {1,2,3,4,5,4,3,2,1,2};
		System.out.print(m.removeElement(A, 2));
	}
    public int removeElement(int[] A, int elem) {
    	int i=0;
        for(int j=0; j<A.length; j++, i++){
        	while(A[j]==elem ){
        		j++;
        		if(j==A.length)
        			return i;
        	}
        	A[i] = A[j];
        }
        return i;
    }
}
