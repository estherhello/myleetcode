/**
 *单链表反转
 *遍历法：先保存当前结点的下一个结点然后更新当前结点
 */
public class Solution{
	public LinkNode reverseList(LinkNode head){
		if(head == null){
			return null;
		}
		if(head.next == null){
			return head;
		}

		ListNode pre = head;
		ListNode cur = head.next;
		pre.next = null;
		while(cur != null){
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		head = pre;
		return head;
	}
}

//链表原地转置实现o(1)空间复杂度  
public static boolean isPalindrome3(ListNode head) {  
 ListNode slow=head;  
 ListNode fast=head;  
   
 if(fast==null||fast.next==null)//0个节点或是1个节点  
     return true;  
  
  
 while(fast.next!=null&&fast.next.next!=null)  
 {  
     fast=fast.next.next;  
     slow=slow.next;  
 }  
 //对链表后半段进行反转  
 ListNode midNode=slow;  
 ListNode pre=slow.next;//后半段链表的第一个节点  
 ListNode cur=pre.next;//插入节点从第一个节点后面一个开始  
 pre.next=null;//第一个节点最后会变最后一个节点  
 while(cur!=null)  
 {  
     ListNode tmp=cur.next;//保存下次遍历的节点  
     cur.next=pre;  
     pre=cur;  
     cur=tmp;  
 }  
   
 //反转之后对前后半段进行比较  
 slow=head;  
 fast=pre;  
 while(fast!=null)  
 {  
     if(fast.val!=slow.val)  
         return false;  
     slow=slow.next;  
     fast=fast.next;  
 }  
 return true;  
   
}  
