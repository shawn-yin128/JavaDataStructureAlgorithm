package DataStructure.LinkedList.KLinkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KListMerge {
    class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public ListNode merge(List<ListNode> lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        while (!heap.isEmpty()) {
            cur.next = heap.poll();
            if (cur.next.next != null) {
                heap.offer(cur.next.next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
