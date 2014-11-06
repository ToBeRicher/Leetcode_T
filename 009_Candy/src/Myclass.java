//Given an array of integers, every element appears three times except for one. Find that single one.




public class Myclass {
	private static final int UP = 1;
	private static final int UP_FLAT = 2;
	private static final int DOWN = -1;
	private static final int DOWN_FLAT = -2;
	
	public static int candy(int[] ratings) {
		if(ratings.length==0)
			return 0;
		if(ratings.length==1)
			return 1;
		int pulse=0;
		int nowHighest=0;
		int total=0;
		int nowCandy=1;
		int preFlag=0;
		int Flag=0;
		int FlatCount=0;
		int peak_length=0;
		int peak_value;
		int i=1;
		
		//**First loop finding first peak**//
		while(i<ratings.length&&peak_length==0){
			total+=nowCandy;
			
			preFlag=Flag;
			if(ratings[i-1]==ratings[i]){
				Flag+=Flag%2;
			}else if(ratings[i-1]<ratings[i]){
				Flag=UP;
			}else{
				Flag=DOWN;
			}
			
			if(preFlag*Flag<0){//found first peak
				peak_length=FlatCount;
				peak_value=nowCandy;
				if(peak_value<=0){
					total+=(peak_value-1)*(-i);
					peak_value=1;
				}
				break;
			}else if(Flag==1){
				FlatCount=0;
				nowCandy++;// candy for the child[i]
			}else if(Flag==-1){
				FlatCount=0;
				nowCandy--;// candy for the child[i]
			}else{//flat part
				FlatCount++;
			}
			i++;
		}
		return total;
    }
	
	public static void main(String[] args){
		int[] a={1,2,3,4,2};
		int res=candy(a);
		System.out.print(""+res);
	}
}
