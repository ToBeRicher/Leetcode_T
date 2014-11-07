//归并排序
//09/21/2014
//田忠骏
public class Myclass {
	
	public static void main(String[] args){		
		int N=1000;
		double[]A = Myclass.getRamdomNumber(N);
		
		long startT = System.nanoTime();  
		
		Myclass.Sort(A,N);
		
	    long endT = System.nanoTime();  
		
		for(int i=0;i<N;i++)
			System.out.println((int)(A[i]*100));
	
	    System.out.println(N+"个数排序用时：" + (double)(endT - startT)/1000000+"毫秒");  
	}
	
	public static void Sort(double[] array,int length){
		
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
