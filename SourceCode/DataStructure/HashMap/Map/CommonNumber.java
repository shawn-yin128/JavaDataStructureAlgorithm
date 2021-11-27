package DataStructure.HashMap.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).
 */
public class CommonNumber {
    public List<Integer> commonNumber(int[] array1, int[] array2) {
        List<Integer> common = new ArrayList<>();
        Map<Integer, Integer> map1 = getMap(array1);
        Map<Integer, Integer> map2 = getMap(array2);
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer freq2 = map2.get(entry.getKey());
            if (freq2 != null) {
                int appear = Math.min(freq2, entry.getValue());
                for (int i = 0; i < appear; i++) {
                    common.add(entry.getKey());
                }
            }
        }
        return common;
    }

    private Map<Integer, Integer> getMap(int[] array) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int num : array) {
            Integer freq = result.get(num);
            if (freq == null) {
                result.put(num, 1);
            } else {
                result.put(num, freq + 1);
            }
        }
        return result;
    }
}

/**
 * time complexity: O(m + n)
 * space complexity: O(m + n)
 */