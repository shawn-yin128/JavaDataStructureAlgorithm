package DataStructure.Array.NSum;

import java.util.Arrays;

/**
 * Determine if there exists a set of four elements in a given array that sum to the given target number.
 */
public class FourSum {
    public boolean fourSum(int[] array, int target) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i++) {
            for (int j = i + 1; j < array.length - 2; j++) {
                int left = j + 1;
                int right = array.length - 1;
                int curTarget = target - array[i] - array[j];
                while (left < right) {
                    int temp = array[left] + array[right];
                    if (temp == curTarget) {
                        return true;
                    } else if (temp < curTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * time complexity: O(n^3)
 * space complexity: O(1)
 */