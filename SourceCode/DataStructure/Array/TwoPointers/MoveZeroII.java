package DataStructure.Array.TwoPointers;

import java.util.Arrays;

/**
 * Given an array of integers, move all the 0s to the right end of the array.
 * The relative order of the elements in the original array need to be maintained.
 */
public class MoveZeroII {
    public int[] moveZero(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (array[fast] != 0) {
                array[slow++] = array[fast++];
            } else {
                fast++;
            }
        }
        while (slow < array.length) {
            array[slow++] = 0;
        }
        return array;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */