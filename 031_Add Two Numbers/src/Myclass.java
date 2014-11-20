/*
	You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. 
	Add the two numbers and return it as a linked list.

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int carry = 0;
    	ListNode res = new ListNode(-1);
    	ListNode returnRes = res;
    	while(l1 != null && l2 != null){
    		int sum = l1.val + l2.val + carry;
    		carry = sum/10;
    		res.next = new ListNode(sum%10);
    		res = res.next;
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	
    	ListNode l;
    	if(l1 != null)
    		l = l1;
    	else
    		l = l2;
    	
    	while(l != null){
    		int sum = l.val + carry;
    		carry = sum/10;
    		res.next = new ListNode(sum%10);
    		res = res.next;
    		l = l.next;
    	}
    	if(carry == 1){
    		res.next = new ListNode(1);
    	}
    	
		return returnRes.next;
    }
	
}
