public class ReverseLinkedListRecursive {
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
