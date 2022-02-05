package DataStructure.QueueStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given an integer array A and a sliding window of size K,
 * find the maximum value of each window as it slides from left to right.
 */
public class MaxSlidingWindow {
    public List<Integer> slidingMax(int[] array, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            while (!window.isEmpty() && array[window.peekLast()] <= array[i]) {
                window.pollLast();
            }
            if (!window.isEmpty() && window.peekFirst() <= i - k) {
                window.pollFirst();
            }
            window.offerLast(i);
            if (i >= k - 1) {
                result.add(array[window.peekFirst()]);
            }
        }
        return result;
    }
}
