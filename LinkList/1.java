/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode meet = meetNode(pHead);
        if(meet == null){
            return null;
        }
        
        int loopLen = 1;
        ListNode slow = meet.next;
        while(slow.next != meet){
			slow = slow.next;
            loopLen++;
        }
        
        slow = pHead;
        ListNode fast = pHead;
        for(int i = 0; i < loopLen; i++){
            fast = fast.next;
        }
        
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    
    public static ListNode meetNode(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return null;
        }
        
        ListNode slow = pHead;
        ListNode fast = pHead;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return slow;
            }
        }
        
        return null;
    }
}


