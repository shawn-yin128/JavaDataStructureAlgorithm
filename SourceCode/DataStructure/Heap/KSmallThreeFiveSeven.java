package DataStructure.Heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.
 */
public class KSmallThreeFiveSeven {
    public long kth(int k) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        heap.offer(3*5*7L);
        visited.add(3*5*7L);
        while (k > 1) {
            long current = heap.poll();
            if (visited.add(3*current)) {
                heap.offer(3*current);
            }
            if (visited.add(5*current)) {
                heap.offer(5*current);
            }
            if (visited.add(7*current)) {
                heap.offer(7*current);
            }
            k--;
        }
        return heap.peek();
    }
}

/**
 * time complexity: O(klogk)
 * space complexity: o(k)
 */