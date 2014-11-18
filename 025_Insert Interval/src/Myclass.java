import java.util.LinkedList;
import java.util.List;

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */


class Myclass {
	
	public static class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	}
	
	public static void main(String[] args){
		Myclass m = new Myclass();
    	List<Interval> test = new LinkedList<Interval>();
    	test.add(new Interval(1,5));
    	
    	test = m.insert(test, new Interval(2,7));
    	for(Interval i: test)
    		System.out.println(i.start + "," + i.end);
	}
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	if(intervals.size() == 0){
    		intervals.add(newInterval);
    		return intervals;
    	}
    	int start = newInterval.start;
    	int end = newInterval.end;
    	

    	//find start
    	int i=0;
        while(i<intervals.size()){
        	Interval Int = intervals.get(i);
        	if(start <= Int.end){//found a 'start' point
        		start = start < Int.start ? start : Int.start; 
        		if(i==intervals.size()){
        			Int.end = end > Int.end? end:Int.end;
        			return intervals;
        		}else{
        			break;//go on looking for end
        		}
        	}
        	i++;
        }
        
        //after find 'start', we can always removing the points until find a terminal point.
    	while(i<intervals.size()){
    		Interval Int = intervals.remove(i);
    		
			if(end< Int.start){// In this case 1: cannot merge the end
				intervals.add(i, Int);
				intervals.add(i, new Interval(start,end));
				return intervals;
			}else if(end <= Int.end){// In this case 2: can merge the end
				intervals.add(i, new Interval(start,Int.end));
				return intervals;
			}
    	}

        //insert the last of list
    	intervals.add(new Interval(start,end));
    	return intervals;
        
    }
	
}
