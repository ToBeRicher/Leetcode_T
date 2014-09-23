//堆排序
//09/21/2014
//田忠骏
//这种自己创建一个Heap类的方法不是很有效率
public class Myclass {
	
	public static class Heap{//先构建一个heap类
		private double[] array;
		private int length;
		public Heap(){//构造函数
			//ppt上面的例子，用来单步执行检查程序。
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
		public Heap(int N){//构造函数
			array = new double [N];
			length = N;
			for(int i=0;i<N;i++){
				array[i]=Math.random();
			}
		}
		public double get(int i){// get this value
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
		
		long startT = System.nanoTime();  //测试算法时间
		
		Myclass.heapSort(h);//排序
		
	    long endT = System.nanoTime();  //测试算法时间
		
		for(int i=0;i<N;i++)
			System.out.println((int)(h.get(i)*100));//打印结果, 因为小数不好看，就全部乘以100
	
	    System.out.println(N+"个数排序用时：" + (double)(endT - startT)/1000000+"毫秒");  
	}
	
	public static void heapSort(Heap h){
		buildheap(h);//先build
		for(int i = h.length()-1; i>0; i--){
			h.exchange(i, 0);//没交换一次，i--,也就是heap的长度--
			maxHeapify(h,0,i);
		}
	}
	
	public static void buildheap(Heap h){
		int length=h.length();
		for(int i =length/2;i>=0;i--){//对从中间到第一个元素都做max-heapify
			maxHeapify(h,i,h.length);
		}
	}
	public static void maxHeapify(Heap h,int i,int length){//第三个input是heapify的长度，不一定是真实地长度，因为要heapsort的时候长度要不断减小,
		if(length-1 >= 2*i+2){//如果左右都有children
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
		}else if(length-1 == 2*i+1 ){//如果只有左边有child
			if(h.get(i)<h.getLeft(i)){
				h.exchange(i, 2*i+1);
			}
		}
		return;
	}

}
