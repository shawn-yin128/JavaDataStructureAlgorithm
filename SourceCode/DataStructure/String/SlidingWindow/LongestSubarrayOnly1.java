package DataStructure.String.SlidingWindow;

/**
 * Given an array of integers that contains only 0s and 1s and a positive integer k, you can flip at most k 0s to 1s, return the longest subarray that contains only integer 1 after flipping.
 */
public class LongestSubarrayOnly1 {
    public int longestOne(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int longest = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                right++;
                longest = Math.max(longest, right - left);
            } else if (count < k) {
                count++;
                right++;
                longest = Math.max(longest, right - left);
            } else if (nums[left] == 0) {
                count--;
                left++;
            } else {
                left++;
            }
        }
        return longest;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */