package Algorithm.GraphSearch.DepthFirstSearch.Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of characters represented by a String,
 * return a list containing all subsets of the characters whose size is K.
 * Notice that each subset returned will be sorted for deduplication.
 */
public class KSizeAllSubsetII {
    public List<String> subsetK(String set, int k) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] charSet = set.toCharArray();
        Arrays.sort(charSet);
        StringBuilder sb = new StringBuilder();
        helper(charSet, 0, k, sb, result);
        return result;
    }

    private void helper(char[] set, int index, int k, StringBuilder sb, List<String> result) {
        if (sb.length() == k) {
            result.add(sb.toString());
            return;
        }
        if (index == set.length) {
            return;
        }
        sb.append(set[index]);
        helper(set, index + 1, k, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        while (index < set.length - 1 && set[index] == set[index + 1]) {
            index++;
        }
        helper(set, index + 1, k, sb, result);
    }
}

/**
 * time complexity: O(n2^n)
 * space complexity: O(n)
 */