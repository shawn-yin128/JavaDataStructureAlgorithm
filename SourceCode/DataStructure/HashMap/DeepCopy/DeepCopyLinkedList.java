package DataStructure.HashMap.DeepCopy;

import java.util.HashMap;
import java.util.Map;

/**
 * Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. Make a deep copy of the original list.
 */
public class DeepCopyLinkedList {
     class RandomListNode {
         public int value;
         public RandomListNode next;
         public RandomListNode random;
         public RandomListNode(int value) {
             this.value = value;
         }
     }

     public RandomListNode copy(RandomListNode head) {
         if (head == null) {
             return null;
         }
         Map<RandomListNode, RandomListNode> map = new HashMap<>();
         RandomListNode dummy = new RandomListNode(0);
         RandomListNode cur = dummy;
         while (head != null) {
             if (!map.containsKey(head)) {
                 map.put(head, new RandomListNode(head.value));
             }
             cur.next = map.get(head);
             if (head.random != null) {
                 if (!map.containsKey(head.random)) {
                     map.put(head.random, new RandomListNode(head.random.value));
                 }
                 cur.next.random = map.get(head.random);
             }
             cur = cur.next;
             head = head.next;
         }
         return dummy.next;
     }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */