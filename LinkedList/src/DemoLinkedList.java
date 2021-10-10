public class DemoLinkedList {
    public int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head= head.next;
        }
        return length;
    }
    public ListNode get(ListNode head, int index) {
        while (index > 0 && head != null) {
            head = head.next;
            index--;
        }
        return head;
    }
    public ListNode appendHead(ListNode head, int value) {
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        return newHead;
    }
    public ListNode appendTail(ListNode head, int value) {
        if (head == null) {
            return new ListNode(value);
        }
        ListNode prev = head;
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = new ListNode(value);
        return head;
    }
    public ListNode remove(ListNode head, int value) {
        // if head is null
        if (head == null) {
            return head;
        } else if (head.value = value) { // if remove head
            return head.next;
        }
        ListNode cur = head;
        while (cur.next != null && cur.next.value != value) {
            cur = cur.next;
        }
        if (cur.next != null) {
            curr.next = cur.next.next;
        }
        return head;
    }
}
