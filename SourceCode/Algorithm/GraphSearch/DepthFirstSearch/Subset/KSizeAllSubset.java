package Algorithm.GraphSearch.DepthFirstSearch.Subset;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of characters represented by a String,
 * return a list containing all subsets of the characters whose size is K.
 * assume no duplicate in the string
 */
public class KSizeAllSubset {
    public List<String> kSizeSubset(String set, int k) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] charSet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(k, charSet, 0, sb, result);
        return result;
    }

    private void helper(int k, char[] set, int index, StringBuilder sb, List<String> result) {
        if (sb.length() == k) {
            result.add(sb.toString());
            return;
        }
        if (index == set.length) {
            return;
        }
        sb.append(set[index]);
        helper(k, set, index + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        helper(k, set, index + 1, sb, result);
    }
}

/**
 * time complexity: O(n*2^n)
 * space complexity: O(n)
 */