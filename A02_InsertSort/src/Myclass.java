//插入排序
//09/21/2014
//田忠骏
public class Myclass {
	
	public static void main(String[] args){
		
		int N=1000;
		double[]A = Myclass.getRamdomNumber(N);
		
		long startT = System.nanoTime();  
		
		Myclass.insertSort(A,N);
		
	    long endT = System.nanoTime();  
		
		for(int i=0;i<N;i++)
			System.out.println((int)(A[i]*100));

	    System.out.println(N+"个数排序用时：" + (double)(endT - startT)/1000000+"毫秒");  
	}
	
	public static void insertSort(double[] array,int length){
		for(int i=1;i<length;i++){//从第二个数开始往后遍历
			double key=array[i];
			int j=i;
			while(j>0 && key<array[j-1] ){//如果某个数比前面的数小，则往前一直插
				array[j] = array[j-1];
				j--;
			}
			array[j]=key;
		}
		return;
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
