/*
 
 
 */

class Myclass {
	public static void main(String[] args){
		Myclass m = new Myclass();
		
	}
    public ListNode deleteDuplicates(ListNode head) {
      if(head == null)
         return null;
	  ListNode tail = head;
	  ListNode scan = head;
	  while(scan!=null){
	  	if(scan.next == null || scan.val != scan.next.val){
	  		tail.next = scan.next;
	  		tail = tail.next;
	  	}
	  	scan = scan.next;
	  }
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
