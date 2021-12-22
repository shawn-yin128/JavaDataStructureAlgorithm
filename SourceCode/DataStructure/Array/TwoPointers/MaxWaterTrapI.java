package DataStructure.Array.TwoPointers;

/**
 * Given a non-negative integer array representing the heights of a list of adjacent bars.
 * Suppose each bar has a width of 1.
 * Find the largest amount of water that can be trapped in the histogram.
 */
public class MaxWaterTrapI {
    public int maxWater(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int result = 0;
        int lmax = array[left];
        int rmax = array[right];
        while (left < right) {
            if (array[left] <= array[right]) {
                result += Math.max(0, lmax - array[left]);
                lmax = Math.max(lmax, array[left]);
                left++;
            } else {
                result += Math.max(0, rmax - array[right]);
                rmax = Math.max(rmax, array[right]);
                right--;
            }
        }
        return result;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */