package DataStructure.Array.TwoPointers;

import java.util.Arrays;

/**
 * Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. For each group of elements with the same value do not keep any of them.
 * Do this in-place, using the left side of the original array. Return the array after deduplication.
 */
public class ArrayDeduplicateIV {
    public int[] arrayDeduplicate(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (slow == 0 || array[fast] != array[slow - 1]) {
                array[slow++] = array[fast++];
            } else {
                while (fast < array.length && array[fast] == array[slow - 1]) {
                    fast++;
                }
                slow--;
            }
        }
        return Arrays.copyOfRange(array, 0, slow);
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */
