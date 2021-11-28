package DataStructure.Array.NSum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Determine if there exist two elements in a given array, the sum of which is the given target number.
 */
public class TwoSum {
    public boolean twoSumI(int[] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            int res = target - num;
            if (set.contains(res)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */