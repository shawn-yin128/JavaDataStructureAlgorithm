package DataStructure.LinkedList.Advanced;

/**
 * given a linked list N1 -> N2 -> N3 -> ... -> Nn
 * reorder as N -> Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> ...
 */
public class ReorderLinkedList {
    private class ListNode {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
    public ListNode reorder(ListNode head) {
        if (head == null ||head.next == null) {
            return head;
        }
        ListNode headOne = head;
        ListNode middle = findMiddle(head);
        ListNode headTwo = middle.next;
        middle.next = null;
        headTwo = reverse(headTwo);
        ListNode res = merge(headOne, headTwo);
        return res;
    }
    public ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode merge(ListNode left, ListNode right) {
        if (left == null && right == null) {
            return left;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int one = 0;
        int two = 0;
        while (left != null && right != null) {
            if (one == two) {
                curr.next = left;
                left = left.next;
                curr = curr.next;
                one++;
            } else if (one > two) {
                curr.next = right;
                right = right.next;
                curr = curr.next;
                two++;
            }
        }
        if (left != null) {
            curr.next = left;
        }
        if (right != null) {
            curr.next = right;
        }
        return dummyHead.next;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */