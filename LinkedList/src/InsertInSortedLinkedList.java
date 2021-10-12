public class InsertInSortedLinkedList {
    public ListNode insertInSortedLinkedList(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null || head.value >= value) { // if null linked list or add at head directly
            newNode.next = head;
            return newNode;
        }
        ListNode prev = head;
        while (prev.next != null && prev.next.value < value) { // if not the last node or the next's value is smaller than value
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */