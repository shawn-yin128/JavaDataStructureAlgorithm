package SpecialCase;

public class CheckPalindrome {
    private class ListNode {
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;
        ListNode rHead = reverse(middleNext);
        while (head != null && rHead != null) {
            if (head.value == rHead.value) {
                head = head.next;
                rHead = rHead.next;
            } else {
                return false;
            }
        }
        return true;
    }
    public ListNode findMiddle(ListNode head) {
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
}

/**
 * time complexity: O(n/2 + n + n/2) = O(n)
 * space complexity: O(n) // can be changed to O(1) with iterative methods
 */