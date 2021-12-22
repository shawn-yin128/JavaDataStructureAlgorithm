package DataStructure.HashMap.Count;

import java.util.*;

/**
 * Find all numbers that appear in both of two unsorted arrays.
 * In any of the two arrays, there could be duplicate numbers.
 */
public class CommonNumberIII {
    public List<Integer> common(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int numa : a) {
            if (map.containsKey(numa)) {
                map.put(numa, map.get(numa) + 1);
            } else {
                map.put(numa, 1);
            }
        }
        for (int numb : b) {
            if (map.containsKey(numb) && map.get(numb) > 0) {
                result.add(numb);
                map.put(numb, map.get(numb) - 1);
            }
        }
        Collections.sort(result);
        return result;
    }
}
