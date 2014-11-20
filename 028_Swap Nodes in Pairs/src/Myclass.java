/*
 Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
		
	}
	
    public ListNode swapPairs(ListNode head) {
        ListNode theOne = head;
    	while(theOne != null && theOne.next != null){
    		int temp = theOne.val;
    		theOne.val = theOne.next.val;
    		theOne.next.val = temp;
    		theOne = theOne.next.next;
    	}
        return head;
        
    }
}
