/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
     public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode after = null;
        while(curr!=null){
            after =curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }
        return prev;
    }
    
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
         slow.next=reverse(slow.next);
         int maxSum=0;
         ListNode head1=head;
         ListNode head2=slow.next;
         while(head2!=null){
            int sum =head1.val+head2.val;
            if(maxSum<sum)
                maxSum=sum;
                head1=head1.next;
                head2=head2.next;
            
           
         }
         return maxSum;

        
    }
}