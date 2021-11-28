package DataStructure.Array.NSum;

import java.util.*;

public class TwoSumPairII {
    public List<List<Integer>> twoSum(int[] array, int target) {
        if (array == null || array.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); // store num and its appearance times
        for (int num : array) {
            Integer count = map.get(num);
            if (num * 2 == target && count != null && count == 1) {
                result.add(Arrays.asList(num, num));
            } else if (map.containsKey(target - num) && count == null) {
                result.add(Arrays.asList(target - num, num));
            }
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }
        return result;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */