import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/*
	 Given a collection of intervals, merge all overlapping intervals.
	
	For example,
	Given [1,3],[2,6],[8,10],[15,18],
	return [1,6],[8,10],[15,18].
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
    	//test.add(new Interval(8,10));
    	//test.add(new Interval(15,18));
    	//test.add(new Interval(1,3));
    	//test.add(new Interval(2,6));
    	test.add(new Interval(1,4));
    	test.add(new Interval(1,4));
    	m.merge(test);
	}

	 public List<Interval> merge(List<Interval> intervals) {
	    	List<Interval> in = intervals;
	    	if(in.size()<=1)
	    	    return in;
	    	 Comparator<Interval> comparator = new Comparator<Interval>(){
	    		 //override the compare method
	    		 public int compare(Interval i1, Interval i2){
	    			 if(i1.start>i2.start)
	    				 return 1;
	    			 else if(i1.start<i2.start)
	    				 return -1;
	    			 else
	    				 return 0;
	    		 }
	    	 };
	    	 
	    	Collections.sort(in, comparator);

	    	int start = in.get(0).start;
	    	int end = in.get(0).end;
	    	List<Interval> list = new ArrayList<Interval>();
	    	
	    	for(int i=1; i<in.size(); i++){
	    		Interval current = in.get(i);
	    		//core code:
	    		if(current.start <= end){
	    			end = current.end > end ? current.end : end; // choose the bigger one.
	    		}else{
	    			list.add(new Interval(start, end));
	    			start = current.start;
	    			end = current.end;
	    		}
	    	}
			list.add(new Interval(start, end));
	    	
	    	return list;
	    }
	
}
