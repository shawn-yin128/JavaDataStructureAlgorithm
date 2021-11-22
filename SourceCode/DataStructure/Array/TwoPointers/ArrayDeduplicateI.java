package DataStructure.Array.TwoPointers;

import java.util.Arrays;

/**
 * Given a sorted integer array, remove duplicate elements.
 * For each group of elements with the same value keep only one of them.
 * Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array.
 * Return the array after deduplication.
 */
public class ArrayDeduplicateI {
    public int[] sortedArrayDeduplicate(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (slow == 0 || array[fast] != array[slow - 1]) { // use slow == 0 is better because slow is how many elelments in current output
                array[slow++] = array[fast++];
            } else {
                fast++;
            }
        }
        return Arrays.copyOfRange(array, 0, slow);
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */