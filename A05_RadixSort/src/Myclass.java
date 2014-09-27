//基数排序
//09/25/2014
//田忠骏
public class Myclass {
	
	public static void main(String[] args){		
		int N=1000000,range=255;
		int[]A = Myclass.getRamdomNumberInt(N,range);//产生0-255范围的数
		
		long startT = System.nanoTime();  

		int r=(int) (Math.log(range)/Math.log(2));
		//Myclass.radixSort(A,N,r);
		Myclass.radixSort2(A,N);
	    long endT = System.nanoTime();  
		
		//for(int i=0;i<N;i++)
			//System.out.println(A[i]);
	
	    System.out.println(N+"个数排序用时：" + (double)(endT - startT)/1000000+"毫秒");  
	}
	
	public static void radixSort(int[] array,int length,int r){	
		for(int shift=0;shift<=r;shift++){
			int bit=1<<shift;
			int i=-1;
			for(int j=0;j<length;j++){//from start to end-1
				int bb=(array[j]&bit);
				if(bb ==0){
					i++;
					int temp=array[j]; //交换
					array[j]=array[i];
					array[i]=temp;
				}
			}
		}
		return;
	}
	

public static void radixSort2(int data[], int n) //基数排序
{
    int d = 2;
    int[] tmp = new int[n];
    int[] count = new int[16]; //计数器
    int i, j, k;
    int radix = 1;
    for(i = 1; i <= d; i++) //进行d次排序 (16+?)*2=32+2? (8+?)*3=24+3?  => ?=8 
    {
        for(j = 0; j < 16; j++)
            count[j] = 0; //每次分配前清空计数器
        for(j = 0; j < n; j++)//scan 16 times 
        {
            k = (data[j] / radix) % 16; //统计每个桶中的记录数
            count[k]++;
        }
        for(j = 1; j < 16; j++)
            count[j] = count[j - 1] + count[j]; //将tmp中的位置依次分配给每个桶
        for(j = n - 1; j >= 0; j--) //将所有桶中记录依次收集到tmp中
        {
            k = (data[j] / radix) % 16;
            tmp[count[k] - 1] = data[j];
            count[k]--;
        }
        for(j = 0; j < n; j++) //将临时数组的内容复制到data中
            data[j] = tmp[j];
        radix = radix * 16;
    }
}
	

	public static int[] getRamdomNumberInt(int N,int range) {
		N=Math.abs(N);
		int []A= new int[N];
		for(int i=0;i<N;i++){
			A[i]=(int)(Math.random()*range);
		}
		return A;
    }
}
