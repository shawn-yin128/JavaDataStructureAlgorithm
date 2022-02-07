package DataStructure.Array.Math;

import java.util.*;

/**
 * Given an integer array of length L,
 * find all numbers that occur more than 1/3 * L times if any exist.
 */
public class MajorityNumberII {
    public List<Integer> majority(int[] array) {
        Map<Integer, Integer> count = new HashMap<>();
        int target = array.length / 3;
        List<Integer> result = new ArrayList<>();
        Set<Integer> added = new HashSet<>();
        for (int num : array) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
                if (count.get(num) > target) {
                    if (!added.contains(num)) {
                        result.add(num);
                        added.add(num);
                    }
                }
            } else {
                count.put(num, 1);
                if (target == 0) {
                    result.add(num);
                    added.add(num);
                }
            }
        }
        return result;
    }
}
