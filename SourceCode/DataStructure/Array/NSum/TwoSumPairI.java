package DataStructure.Array.NSum;

import java.util.*;

/**
 * Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indices.
 */
public class TwoSumPairI {
    public List<List<Integer>> twoSumII(int[] array, int target) {
        if (array == null || array.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> index = map.get(target - array[i]); // represents all index that has value array[i]
            if (index != null) {
                for (int j : index) {
                    result.add(Arrays.asList(j, i));
                }
            }
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<Integer>());
            }
            map.get(array[i]).add(i);
        }
        return result;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */