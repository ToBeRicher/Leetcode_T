class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		int[] A = {1,3};
		int[] B = {2,4};
		System.out.print("result: " + m.findMedianSortedArrays(A,B));
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		if(A.length == 0 || A==null)
			if(B.length%2==1)
				return B[B.length/2];
			else
				return (B[B.length/2]+B[B.length/2 - 1])/2.0;
		if(B.length == 0 || B==null)
			if(A.length%2==1)
				return A[A.length/2];
			else
				return (A[A.length/2]+A[A.length/2 - 1])/2.0;
		
		if((A.length+B.length)%2 == 1)  //如果长度之和为奇数
			return findKth(A,0,A.length,B,0,B.length, (A.length+B.length)/2 +1); 
		else
			return (
					findKth(A,0,A.length,B,0,B.length, (A.length+B.length)/2) + 
					findKth(A,0,A.length,B,0,B.length, (A.length+B.length)/2 + 1) 
					)  
					/2.0; 
    }

	private double findKth(int[] a,int al,int ar, int[] b,int bl,int br, int k) { //包括 a[al:ar-1], 不包括a[ar]
		
		int lenA = ar-al;
		int lenB = br-bl;
		
		if(lenA == 0)
			return b[bl+k-1];
		if(lenB == 0)
			return a[al+k-1];
		if(k==1)
			return a[al]<b[bl]?a[al]:b[bl];
		
		int indexA = (int)((lenA * 1.0 / (lenA + lenB)) * (k-1));
		int indexB = (k - indexA - 2);
		if(a[al+indexA]==b[bl+indexB]){
			return a[al+indexA];
		}else if(a[al+indexA]>b[bl+indexB]){
			return findKth( a, al, al+indexA+1,  b, bl+indexB+1, br,  k-(indexB+1));
		}else if(a[al+indexA]<b[bl+indexB]){
			return findKth( a, al+indexA+1, ar,  b, bl, bl+indexB+1,  k-(indexA+1));
		}
		return 0;
	}
	
}
