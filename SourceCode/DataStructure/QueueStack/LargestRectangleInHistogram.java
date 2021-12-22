package DataStructure.QueueStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a non-negative integer array representing the heights of a list of adjacent bars.
 * Suppose each bar has a width of 1.
 * Find the largest rectangular area that can be formed in the histogram.
 */
public class LargestRectangleInHistogram {
    public int rectangle(int[] array) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= array.length; i++) {
            int curHeight = i == array.length ? 0 : array[i];
            while (!stack.isEmpty() && array[stack.peekFirst()] >= curHeight) {
                int height = array[stack.pollFirst()];
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                result = Math.max(result, height * (i - left));
            }
            stack.offerFirst(i);
        }
        return result;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */