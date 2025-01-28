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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // If the list is empty or has only one node, return null
        }
        ListNode temp=head;
        ListNode slow=head;
          ListNode fast=head;
          while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

          }
               if (head.next.next == null) {
            head.next = null; // Remove the second node
            return head;
        }
         if (slow.next != null) {
            slow.val = slow.next.val; // Copy the value from the next node
            slow.next = slow.next.next; // Remove the next node
        }
          return head;
    }
}