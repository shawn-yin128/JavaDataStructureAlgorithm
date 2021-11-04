package Revise;

public class PartitionLinkedList {
    private class ListNode {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
    public ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode large = largeHead;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            if (curr.value < target) {
                small.next = curr;
                curr.next = null;
                small = small.next;
                curr = next;
            } else {
                large.next = curr;
                curr.next = null;
                large = large.next;
                curr = next;
            }
        }
        small.next = largeHead.next;
        largeHead.next = null;
        return smallHead.next;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */
