/**
 * class ListNode {
 *     public int value;
 *     public ListNode next;
 *     public ListNode(int value) {
 *         this.value = value;
 *         next = null;
 *     }
 * }
 */
public class ReverseLinkedListIterative {
    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev; // because at last the curr is null and what represents current node is prev
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1) although new on heap but gc after loop
 */