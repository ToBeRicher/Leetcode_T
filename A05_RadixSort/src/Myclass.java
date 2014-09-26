//基数排序
//09/25/2014
//田忠骏
public class Myclass {
	
	public static void main(String[] args){		
		int N=1000,range=255;
		double[]A = Myclass.getRamdomNumberInt(N,range);//产生0-255范围的数
		
		long startT = System.nanoTime();  
		
		Myclass.Sort(A,N);
		
	    long endT = System.nanoTime();  
		
		for(int i=0;i<N;i++)
			System.out.println(A[i]);
	
	    System.out.println(N+"个数排序用时：" + (double)(endT - startT)/1000000+"毫秒");  
	}
	
	public static void Sort(double[] array,int length){
		
	}

	public static double[] getRamdomNumberInt(int N,int range) {
		N=Math.abs(N);
		double []A= new double[N];
		for(int i=0;i<N;i++){
			A[i]=(int)(Math.random()*range);
		}
		return A;
    }
}
