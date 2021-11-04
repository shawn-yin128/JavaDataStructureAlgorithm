package ListOperation.Revise;

public class ReverseLinkedListRecursive {
    private class ListNode {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
    public ListNode reverseLinkedListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseLinkedListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */
