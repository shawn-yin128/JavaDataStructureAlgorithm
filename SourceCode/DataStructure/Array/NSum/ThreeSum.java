package DataStructure.Array.NSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Determine if there exists three elements in a given array that sum to the given target number.
 * Return all the triple of values that sums to target.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] array, int target) {
        if (array == null || array.length < 3) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int temp = array[left] + array[right];
                if (temp + array[i] == target) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                    }
                } else if (temp + array[i] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}

/**
 * time complexity: O(n^2)
 * space complexity: O(1)
 */