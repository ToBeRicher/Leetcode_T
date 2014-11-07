
public class SortOneThread extends Thread{
	
	public void run(double[] array,int s,int e){
		if(s<e){
			int mid=partition(array,s,e);
			run(array,s,mid);
			run(array,mid+1,e);
		}
	}

	public  int partition(double[] array,int s,int e){
		double key=array[e];
		int i=s-1;
		
		for(int j=s;j<e;j++){//from start to end-1
			if(array[j]<=key){
				i++;
				double temp=array[j]; //交换
				array[j]=array[i];
				array[i]=temp;
			}
		}
		double temp=array[e];//交换
		array[e]=array[i+1];
		array[i+1]=temp;
		return i;
	}
	
}
