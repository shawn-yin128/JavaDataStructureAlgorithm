package DepthFirstSearch;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of characters represented by a String, return a list containing all subsets of the characters.
 */
public class AllSubset {
    public List<String> subSet(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    public void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        if (index == set.length) {
            result.add(sb.toString());
            return;
        }
        helper(set, sb, index + 1, result);
        sb.append(set[index]);
        helper(set, sb, index + 1, result);
        sb.deleteCharAt(sb.length() - 1);
    }
}

/**
 * time complexity: O(2^n - 1 + n * 2^n) -> O(n * 2^n) toString O(n)
 * space complexity: O(n)
 */
