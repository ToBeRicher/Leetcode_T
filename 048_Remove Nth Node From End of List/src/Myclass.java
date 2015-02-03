/*
 
 */
class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		
	}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0) return head;
        ListNode pre = head;
		ListNode cur = head;
		
		for(int i=n;i>0;i--){
			cur = cur.next;
		}
		if(cur == null){//if delete the first node;
			return head.next;
		}
		//if(n == 1){//if delete the last node;
			
		//}
		while(cur.next != null){
			cur = cur.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;//becuase n>=1, so pre.next always exist
		
		return head;
    }
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
}
