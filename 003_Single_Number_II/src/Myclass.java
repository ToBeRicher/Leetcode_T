//Given an array of integers, every element appears three times except for one. Find that single one.
public class Myclass {
	public static int singleNumber(int[] A) {
		int counter[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		for(int i=A.length-1;i>=0;i--){
			int temp=A[i];
			for(int j=0;j<32;j++){
				counter[j]+=(temp>>j)&0x00000001;//lowest bit. # of this bit==1 
			}
		}
		int result=0x00000000;
		for(int i=31;i>=0;i--){
			int temp=result<<1;
			result= temp + counter[i]%3;
		}
		return result;
    }
	
	public static void main(String[] args){
		int test[] = {1,1,12,1};
		singleNumber(test);
	}
}
