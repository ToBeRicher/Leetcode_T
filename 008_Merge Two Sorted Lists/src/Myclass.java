//Given an array of integers, every element appears three times except for one. Find that single one.
class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}

public class Myclass {

	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		ListNode head;
		ListNode search1;
		ListNode search2;
		ListNode tail;
		
		if(l1.val < l2.val){
			head=l1;
			tail=l1;
			search1=l1.next;
			search2=l2;
		}
		else{
			head=l2;
			tail=l2;
			search1=l1;
			search2=l2.next;
		}
		while(search1!=null && search2!=null){
			if(search1.val < search2.val){
				tail.next=search1;
				tail=search1;
				search1=search1.next;
			}
			else{
				tail.next=search2;
				tail=search2;
				search2=search2.next;
			}
		}
		if(search1==null && search2!=null){
			tail.next=search2;
		}
		if(search1!=null && search2==null){
			tail.next=search1;
		}
		
		return head;
    }
	
	public static void main(String[] args){
		ListNode L1[]=new ListNode[3];
		ListNode L2[]=new ListNode[3];
		L1[0]=new ListNode(1);
		L1[1]=new ListNode(5);
		L1[2]=new ListNode(7);
		L1[0].next=L1[1];L1[1].next=L1[2];
		L2[0]=new ListNode(2);
		L2[1]=new ListNode(4);
		L2[2]=new ListNode(8);
		L2[0].next=L2[1];L2[1].next=L2[2];
		ListNode head=mergeTwoLists(L1[0],L2[0]);
		while(head!=null){
			System.out.print(""+head.val);
			head=head.next;
		}
	}
}
