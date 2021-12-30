package DataStructure.Array.KArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all common elements in 3 sorted arrays.
 */
public class CommonElementsInThreeSortedArray {
    public List<Integer> common(int[] a, int[] b, int[] c) {
        List<Integer> result = new ArrayList<>();
        int ai = 0;
        int bi = 0;
        int ci = 0;
        while (ai < a.length && bi < b.length && ci < c.length) {
            if (a[ai] == b[bi] && a[ai] == c[ci]) {
                result.add(a[ai]);
                ai++;
                bi++;
                ci++;
            } else if (a[ai] <= b[bi] && a[ai] <= c[ci]) {
                ai++;
            } else if (b[bi] <= a[ai] && b[bi] <= c[ci]) {
                bi++;
            } else {
                ci++;
            }
        }
        return result;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */