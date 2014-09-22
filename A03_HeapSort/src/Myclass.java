//堆排序
//09/21/2014
//田忠骏
public class Myclass {
	
	public static class Heap{//先构建一个heap类
		private double[] array;
		public int length;
		public Heap(){
			array = new double [10];
			array[0]=4;
			array[1]=1;
			array[2]=3;
			array[3]=2;
			array[4]=16;
			array[5]=9;
			array[6]=10;
			array[7]=14;
			array[8]=8;
			array[9]=7;
			length=10;
		}
		public Heap(int N){
			array = new double [N];
			length = N;
			for(int i=0;i<N;i++){
				array[i]=Math.random();
			}
		}
		public double get(int i){
			return array[i];
		}
		public double getParent(int i){
			return array[(i+1)/2];
		}
		public double getLeft(int i){
			return array[2*i+1];
		}
		public double getRight(int i){
			return array[2*i+2];
		}
		public void exchange(int i,int j){
			double temp=array[i];
			array[i]=array[j];
			array[j]=temp;
		}
		public int length(){
			return length;
		}
	}
	
	public static void main(String[] args){		
		int N=1000;
		Heap h = new Heap(N);
		
		long startT = System.nanoTime();  
		
		Myclass.heapSort(h);
	    long endT = System.nanoTime();  
		
		for(int i=0;i<N;i++)
			System.out.println((int)(h.get(i)*100));
	
	    System.out.println(N+"个数排序用时：" + (double)(endT - startT)/1000000+"毫秒");  
	}
	public static void heapSort(Heap h){
		buildheap(h);
		for(int i = h.length()-1; i>0; i--){
			h.exchange(i, 0);
			maxHeapify(h,0,i);
		}
	}
	
	public static void buildheap(Heap h){
		int length=h.length();
		for(int i =length/2;i>=0;i--){
			maxHeapify(h,i,h.length);
		}
	}
	public static void maxHeapify(Heap h,int i,int length){
		if(length-1 >= 2*i+2){
			double j=h.get(i);
			double l=h.getLeft(i);
			double r=h.getRight(i);
			double largest= l > r ? l: r;
			if(largest>j){
				if(l>r){
					h.exchange(2*i+1,i);
					maxHeapify(h,2*i+1,length);
				}else{
					h.exchange(2*i+2,i);
					maxHeapify(h,2*i+2,length);
				}
			}
		}else if(length-1 == 2*i+1 ){
			if(h.get(i)<h.getLeft(i)){
				h.exchange(i, 2*i+1);
			}
		}
		return;
	}

}
