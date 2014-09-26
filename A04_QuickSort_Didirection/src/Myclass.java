//快速排序
//09/25/2014 
//quick sort有两种，一种是从左往右，一种是两边向中间搜索，这里用的第二种
//田忠骏 
public class Myclass {
	
	public static void main(String[] args){		
		int N=1000000;
		double[]A = Myclass.getRamdomNumber(N);//产生随机N个数
		
		long startT = System.nanoTime();  //测试算法耗时
		
		Myclass.quickSort(A,0,N-1);
		
	    long endT = System.nanoTime();   //测试算法耗时
		
		//for(int i=0;i<N;i++)
			//System.out.println((int)(A[i]*100));//打印结果, 因为小数不好看，就全部乘以100
	
	    System.out.println(N+"个数排序用时：" + (double)(endT - startT)/1000000+"毫秒");  
	}
	
	public static void quickSort(double[] array,int s,int e){
		if(s<e){
			int mid=partition(array,s,e);//mid后面全大于mid
			quickSort(array,s,mid);
			quickSort(array,mid+1,e);
		}
	}

	public static int partition(double[] array,int s,int e){
		
		double key=array[e];
		int i=s;
		int j=e-1;
		while(true){
			while(array[i]<=key && i<j)
				i++;
			while(array[j]>key && i<j)
				j--;

			if(i<j){
				double temp=array[j]; //交换
				array[j]=array[i];
				array[i]=temp;
			}else{
				if(array[i]>array[e]){
					double temp=array[e]; //交换
					array[e]=array[i];
					array[i]=temp;
				}
				return i;
			}
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
	public static void exchange(double[] array,int i,int j){
		double temp=array[j]; //交换
		array[j]=array[i];
		array[i]=temp;
	}
}
