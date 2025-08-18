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
    public ListNode reverseKGroup(ListNode head, int k) {
    

        if (head == null || k <= 1) return head;  // guard condition

        // Step 1: Check if at least k nodes exist
        ListNode temp = head;
        int cnt = 0;
        while (cnt < k) {
            if (temp == null) return head;  // less than k nodes → no reversal
            temp = temp.next;
            cnt++;
        }

        // Step 2: Recursively call for the rest
        ListNode prevNode = reverseKGroup(temp, k);

        // Step 3: Reverse current k-group
        temp = head;
        cnt = 0;
        while (cnt < k) {
            ListNode next = temp.next;  // save next node
            temp.next = prevNode;   // link to already reversed part
            prevNode = temp;        // move prev forward
            temp = next;            // move temp forward
            cnt++;
        }

        // prevNode is new head of this reversed group
        return prevNode;
    }
}
 