package Algorithm.DynamicProgramming.OneDArray;

/**
 * Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.
 */
public class LongestConsecutive1s {
    public int longestConsecutive(int[] array) {
        int prev = array[0] == 1 ? 1 : 0;
        int result = prev;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 1) {
                prev = prev + 1;
            } else {
                prev = 0;
            }
            result = Math.max(result, prev);
        }
        return result;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */