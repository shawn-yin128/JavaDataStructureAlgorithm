package OneD;

/**
 * Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.
 */
public class LongestAscendingSubarray {
    public int longestSubarray(int[] array) {
        int longest = 1;
        int prev = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                prev++;
                longest = Math.max(longest, prev);
            } else {
                prev = 1;
            }
        }
        return longest;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */