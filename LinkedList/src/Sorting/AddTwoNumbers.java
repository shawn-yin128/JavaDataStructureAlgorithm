package Sorting;

public class AddTwoNumbers {
    private class ListNode {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
    public ListNode addTwoNumbers(ListNode left, ListNode right) {
        if (left == null && right == null) {
            return null;
        }
        ListNode rLeft = reverse(left);
        ListNode rRight = reverse(right);
        int carry = 0;
        ListNode res = new ListNode(0);
        while (rLeft != null && rRight != null) {
            int temp = rLeft.value + rRight.value + carry;
            int value = temp % 10;
            carry = temp / 10;
            res.next = new ListNode(value);
            rLeft = rLeft.next;
            rRight = rRight.next;
            res = res.next;
        }
        while (rLeft != null) {
            int temp = rLeft.value + carry;
            int value = temp % 10;
            carry = temp / 10;
            res.next = new ListNode(value);
            rLeft = rLeft.next;
            res = res.next;
        }
        while (rRight != null) {
            int temp = rRight.value + carry;
            int value = temp % 10;
            carry = temp / 10;
            res.next = new ListNode(value);
            rRight = rRight.next;
            res = res.next;
        }
        if (carry != 0) {
            res.next = new ListNode(carry);
            res = res.next;
        }
        return res.next;
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
}

/**
 * time complexity: O(n+m) + O(max(n, m)) = O(n+m)
 * space complexity: O(n+m) + O(max(n ,m)) = O(n+m)
 */