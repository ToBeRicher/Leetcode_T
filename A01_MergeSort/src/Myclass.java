//归并排序

public class Myclass {
	
	public static void main(String[] args){
		int N=100;
		double[]A = Myclass.getRamdomNumber(N);
		Myclass.mergeSort(A,0,N-1);
		for(int i=0;i<N;i++)
			System.out.println((int)(A[i]*100));
	}
	
	public static void mergeSort(double[] array,int start,int end){
		if(end-start>0){
			int mid=(end+start)/2;
			Myclass.mergeSort(array,start,mid);
			Myclass.mergeSort(array,mid+1,end);
			Myclass.merge(array,start,mid,end);
		}
		return;
	}

	private static void merge(double[] array, int start, int mid, int end) {
		int i=start,j=mid+1;
		double[] temp=new double[end-start+1];
		int k=0;
		while(i<=mid && j<=end){
			temp[k++] = array[i]<array[j] ? array[i++] : array[j++];
		}
		while(j<=end){
			temp[k++] = array[j++];
		}
		while(i<=mid){
			temp[k++] = array[i++];
		}
		k--;
		while(k>=0){
			array[end--]=temp[k--]; 
		}
		
	}

	public static double[] getRamdomNumber(int N) {
		N=Math.abs(N);
		double []A= new double[N];
		for(int i=0;i<N;i++){
			A[i]=Math.random();
		}
		return A;
    }
}
