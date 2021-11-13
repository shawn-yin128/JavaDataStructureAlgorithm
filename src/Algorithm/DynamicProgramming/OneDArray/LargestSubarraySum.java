package Algorithm.DynamicProgramming.OneDArray;

/**
 * Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.
 */
public class LargestSubarraySum {
    public int largestSubSum(int[] array) {
        int largest = array[0];
        int prev = array[0];
        for (int i = 1; i < array.length; i++) {
            if (prev > 0) {
                prev = prev + array[i];
            } else {
                prev = array[i];
            }
            largest = Math.max(largest, prev);
        }
        return largest;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */
