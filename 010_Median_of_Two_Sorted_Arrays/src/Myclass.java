class Myclass {
	public static void main(String[] args){
		int[] A = {1};
		int[] B = {2,3,4,5,6,7,8,9};
		System.out.print("result: " + findMedianSortedArrays(A,B));
	}

	public static double findMedianSortedArrays(int A[], int B[]) { //需要A的长度小于等于 B
		if(A.length == 0){
			return B[B.length/2];
		}
		if(B.length == 0){
			return A[A.length/2];
		}
		return find_kth(A, 0, A.length-1, B, 0, B.length-1, (int)((A.length + B.length + 1)/2));
    }
	
	public static double find_kth(int A[], int al, int ar, int B[], int bl, int br, int k){
		if(A.length > B.length){ //make sure that A is shorter than B
			return find_kth(B, bl, br, A, al, ar, k);
		}
		int lenA = ar - al + 1;
		int lenB = br - bl + 1;
		int m = 0, n = 0;
		if(k < 5){
			while(true){
				if(al == ar+1){
					return B[k];
				}
				if(bl == br+1){
					return A[k];
				}
				if(A[al] > B[bl]){
					if(k == 1){
						return B[bl];
					}
					bl++;
					k--;
				}else if(A[al] < B[bl]){
					if(k == 1){
						return A[al];
					}
					al++;
					k--;
				}else{
					if(k <= 2){
						return A[al];
					}
					al++;
					bl++;
					k-=2;
				}
			}
		}else if((int)(k/2) < lenA){ 
			m = al + (int)(k/2) - 1;
			n = bl + (k - (int)(k/2)) - 1;
		}else if((int)(k/2) >= lenA){
			m = (al + ar) / 2;
			n = bl + (k - (m - al + 1)) -1;
		}
		if(A[m] > B[n]){
			k = k - (n - bl);
			ar = m;
			bl = n;
		}else if(A[m] < B[n]){//当A=1 B=[2,3,4,5,6,7,8]的时候没法缩小范围
			k = k - (m - al);
			al = m;
			br = n;
		}else{
			return A[m];
		}
		
		return find_kth(A, al, ar, B, bl, br, k);
	}
}
