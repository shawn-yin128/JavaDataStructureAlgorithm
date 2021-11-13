package Algorithm.Recursion.WithList;

/**
 * DataStructure.String.Reverse pairs of elements in a singly-linked list.
 */
public class ReverseInPair {
    private static class ListNode {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode reversePair(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = reversePair(head.next.next);
        newHead.next = head;
        return newHead;
    }
}

/**
 * time complexity :O(n)
 * space complexity: O(n)
 */