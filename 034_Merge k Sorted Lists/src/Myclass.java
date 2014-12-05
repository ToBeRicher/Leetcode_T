import java.util.LinkedList;
import java.util.List;

/*
 
 */
class Myclass {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	public static void main(String[] args){
		Myclass m = new Myclass();
		int a [] = {1,3,9,15};
		int b [] = {2,5,7,10};
		int c [] = {4,6,11,13};
		ListNode la = m.generator(a);
		ListNode lb = m.generator(b);
		ListNode lc = m.generator(c);
		List<ListNode> list = new LinkedList<ListNode>();
		list.add(la);
		list.add(lb);
		list.add(lc);
		
		ListNode res = m.mergeKLists(list);
	}
	
	public ListNode generator(int[] in){
		ListNode nodes = new ListNode(in[0]);
		ListNode temp = nodes;
		for(int i = 1; i < in.length; i++){
			temp.next = new ListNode(in[i]);
			temp = temp.next;
		}
		return nodes;
	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists.size() == 0)
			return null;
		List<ListNode> CombinedList = lists;
		List<ListNode> NotCombineList = new LinkedList<ListNode>();

        while(CombinedList.size() != 1){
        	NotCombineList = CombinedList;
        	CombinedList = new LinkedList<ListNode>();
        	
			if(NotCombineList.size()%2 == 1){
				CombinedList.add(NotCombineList.get(NotCombineList.size()-1));
			}
			for(int i=0; i+1<NotCombineList.size(); i+=2){
				CombinedList.add(this.mergeTwoList(NotCombineList.get(i), NotCombineList.get(i+1)));
			}
        }
		
		return CombinedList.get(0);
    }
	public ListNode mergeTwoList(ListNode la, ListNode lb){
		
		if(la == null && lb == null)
			return null;
		else if(la == null)
			return lb;
		else if(lb == null)
			return la;
		
		ListNode res;
		if(la.val < lb.val){
			res = la;
			la = la.next;
		}else{ 
			res = lb;
			lb = lb.next;
		}
		
		ListNode temp = res;
		while(la != null && lb != null){
			if(la.val < lb.val){
				temp.next = la;
				temp = la;
				la = la.next;
			}else{
				temp.next = lb;
				temp = lb;
				lb = lb.next;
			}
		}
		if(la == null){
			temp.next = lb;
		}
		if(lb == null){
			temp.next = la;
		}
		return res;
	}
	
	
}
