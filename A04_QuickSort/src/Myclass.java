//快速排序
//09/21/2014
//田忠骏 双边逼近中间的方法 应该比 单边的快一些
public class Myclass {
	
	public static void main(String[] args){		
		int N=2;
		double[]A = Myclass.getRamdomNumber(N);
		
		long startT = System.nanoTime();  
		
		Myclass.quickSort(A,1,N-1);
		
	    long endT = System.nanoTime();  
		
		for(int i=0;i<N;i++)
			System.out.println((int)(A[i]*100));
	
	    System.out.println(N+"个数排序用时：" + (double)(endT - startT)/1000000+"毫秒");  
	}
	
	public static void quickSort(double[] array,int s,int e){
		if(s<e){
			int mid=partition(array,s,e);
			quickSort(array,s,mid);
			quickSort(array,mid+1,e);
		}
	}

	public static int partition(double[] array,int s,int e){
		int i=s;
		int j=e-1;//??e-1
		double key=array[e];
		while(i<j){
			while(array[i]<key)//正向搜索第一个大于等于key的
				i++;
			if(i==j){//没找到,也就是说i之前所有数都小于第一个,但是array[i]>=key
				return e-1;
			}else{//找到
				while(array[j]>=key)//反向搜索第一个小于key的
					j--;
				if(i==j){//没找到
					array[e]=array[j+1];
					array[j+1]=key;
					return j+1;
				}else{//找到了
					double temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		if(array[s]>array[e]){
			double temp=array[s];
			array[s]=array[e];
			array[e]=temp;
		}
		return i;
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
