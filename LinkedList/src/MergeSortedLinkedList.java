public class MergeSortedLinkedList {
    public ListNode mergeSortedLinkedList(ListNode headOne, ListNode headTwo) {
        if (headOne == null && headTwo == null) {
            return headOne;
        }
        ListNode dummyHead = ListNode(0);
        ListNode curr = dummyHead;
        while (headOne != null && headTwo != null) {
            if (headOne.value < headTwo.value) {
                curr.next = headOne;
                headOne = headOne.next;
                curr = curr.next;
            } else {
                curr.next = headTwo;
                headTwo = headTwo.next;
                curr = curr.next;
            }
        }
        if (headOne != null) {
            curr.next = headOne;
        }
        if (headTwo != null) {
           curr.next = headTwo;
        }
        return dummyHead.next;
    }
}

/**
 * time complexity: O(n+m)
 * space complexity: O(1)
 */