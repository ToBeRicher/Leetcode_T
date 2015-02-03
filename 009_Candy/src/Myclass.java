/*
 There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		int [] ratings = {1,2,3,1,3,6,5,4,3};
		System.out.print(m.candy(ratings));
	}
	
    public int candy(int[] ratings) {
    	if(ratings.length <= 1)
    		return ratings.length;
    	int maxIncreaseLength = 1;
        int currentInLen = 1;
    	int maxDecreaseLength = 1;
        int currentDeLen = 1;
        for(int i=1; i<ratings.length; i++){
        	if(ratings[i] >= ratings[i-1]){
        		currentInLen++;
        	}else{
        		maxIncreaseLength = maxIncreaseLength > currentInLen? maxIncreaseLength: currentInLen;
        		currentInLen = 1;
        	}
        	
        	if(ratings[i] <= ratings[i-1]){
        		currentDeLen++;
        	}else{
        		maxDecreaseLength = maxDecreaseLength > currentDeLen? maxDecreaseLength: currentDeLen;
        		currentDeLen = 1;
        	}
        }
        maxIncreaseLength = maxIncreaseLength > currentInLen? maxIncreaseLength: currentInLen;
        maxDecreaseLength = maxDecreaseLength > currentDeLen? maxDecreaseLength: currentDeLen;
        
        int max = maxIncreaseLength > maxDecreaseLength? maxIncreaseLength: maxDecreaseLength;
        return max;
    }
}
