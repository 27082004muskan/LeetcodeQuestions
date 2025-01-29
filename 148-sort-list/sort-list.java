class Solution {
    // Merge two sorted lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(100);
        ListNode temp = dummy;
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        if (temp1 == null) temp.next = temp2;
        else temp.next = temp1;

        return dummy.next;
    }

    // Split and sort the list
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head; // Fixed condition

        ListNode slow = head, fast = head;

        // Corrected loop to split properly
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null; // Corrected splitting

        ListNode firstHalf = sortList(head);
        secondHalf = sortList(secondHalf);

        return mergeTwoLists(firstHalf, secondHalf);
    }
}
