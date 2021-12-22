package DataStructure.HashMap.Count;

import java.util.*;

/**
 * Find all numbers that appear in both of the two unsorted arrays, return the common numbers in increasing order.
 */
public class CommonNumberII {
    public List<Integer> common(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int numa : a) {
            set.add(numa);
        }
        for (int numb : b) {
            if (set.contains(numb)) {
                result.add(numb);
            }
        }
        Collections.sort(result);
        return result;
    }
}
