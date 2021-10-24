public class RemoveLinkedListElement {
    public ListNode removeElement(ListNode head, int target) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode curr = dummyHead.next;
        while (curr != null) {
            if (curr.value != target) {
                prev = curr;
                curr = curr.next;
            } else {
                ListNode next = curr.next;
                prev.next = next;
                curr.next = null;
                curr = next;
            }
        }
        return dummyHead.next;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */