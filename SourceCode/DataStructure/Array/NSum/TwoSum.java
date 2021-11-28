package DataStructure.Array.NSum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Determine if there exist two elements in a given array, the sum of which is the given target number.
 */
public class TwoSum {
    // simple version that return true if has such a pair and false if not
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

    // return all pairs
    public List<List<Integer>> twoSumII(int[] array, int target) {
        if (array == null || array.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            int res = target - num;
            if (set.contains(res)) {
                List<Integer> cur = new ArrayList<>();
                cur.add(num);
                cur.add(res);
                result.add(cur);
            } else {
                set.add(num);
            }
        }
        return result;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */