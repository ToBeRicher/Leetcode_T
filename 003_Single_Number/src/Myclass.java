
public class Myclass {
	public static int singleNumber(int[] A) {
		int counter[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		for(int i=A.length-1;i>=0;i--){
			int temp=A[i];
			counter[0]+=(temp>>0)&0x00000001;//lowest bit. # of this bit==1 
			counter[1]+=(temp>>1)&0x00000001;
			counter[2]+=(temp>>2)&0x00000001;
			counter[3]+=(temp>>3)&0x00000001;
			counter[4]+=(temp>>4)&0x00000001;
			counter[5]+=(temp>>5)&0x00000001;
			counter[6]+=(temp>>6)&0x00000001;
			counter[7]+=(temp>>7)&0x00000001;
			counter[8]+=(temp>>8)&0x00000001;
			counter[9]+=(temp>>9)&0x00000001;
			counter[10]+=(temp>>10)&0x00000001;
			counter[11]+=(temp>>11)&0x00000001;
			counter[12]+=(temp>>12)&0x00000001;
			counter[13]+=(temp>>13)&0x00000001;
			counter[14]+=(temp>>14)&0x00000001;
			counter[15]+=(temp>>15)&0x00000001;
			counter[16]+=(temp>>16)&0x00000001;
			counter[17]+=(temp>>17)&0x00000001;
			counter[18]+=(temp>>18)&0x00000001;
			counter[19]+=(temp>>19)&0x00000001;
			counter[20]+=(temp>>20)&0x00000001;
			counter[21]+=(temp>>21)&0x00000001;
			counter[22]+=(temp>>22)&0x00000001;
			counter[23]+=(temp>>23)&0x00000001;
			counter[24]+=(temp>>24)&0x00000001;
			counter[25]+=(temp>>25)&0x00000001;
			counter[26]+=(temp>>26)&0x00000001;
			counter[27]+=(temp>>27)&0x00000001;
			counter[28]+=(temp>>28)&0x00000001;
			counter[29]+=(temp>>29)&0x00000001;
			counter[30]+=(temp>>30)&0x00000001;
			counter[31]+=(temp>>31)&0x00000001;//highest bit
		}
		int result=0x00000000;
		for(int i=31;i>=0;i--){
			int temp=result<<1;
			result= temp + counter[i]%2;
		}
		return result;
    }
	
	public static void main(String[] args){
		int test[] = {1};
		singleNumber(test);
	}
}
