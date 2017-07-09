public class Solution{
	public ListNode findK(ListNode head,int k){
		if(head == null || k <= 0){
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		for(int i = 0; i < k-1; i++){
			if(fast.next != null){
				fast = fast.next;
			}else{
				return null;
			}
			
		}
		while(fast.next != null){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}