public class MergeSortLinkedList {
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(middleNext);
        return merge(left, right);
    }
    public ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = haed;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode left, ListNode right) {
        if (left == null && right == null) {
            return left;
        }
        ListNode newDummyHead = new ListNode(0);
        ListNode curr = newDummyHead;
        ListNode leftIndex = left;
        ListNode rightIndex = right;
        while (leftIndex != null && rightIndex != null) {
            if (leftIndex.value < rightIndex.value) {
                curr.next = leftIndex;
                curr = curr.next;
                leftIndex = leftIndex.next;
            } else {
                curr.next = rightIndex;
                rightIndex = rightIndex.next;
                curr = curr.next;
            }
        }
        if (leftIndex != null) {
            curr.next = leftIndex;
        }
        if (rightIndex != null) {
            curr.next = rightIndex;
        }
        return newDummyHead.next;
    }
}

/**
 * time complexity: O(nlogn)
 * space complexity: O(logn)
 */