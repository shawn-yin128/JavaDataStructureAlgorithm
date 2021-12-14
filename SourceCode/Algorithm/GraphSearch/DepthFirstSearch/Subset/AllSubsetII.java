package Algorithm.GraphSearch.DepthFirstSearch.Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of characters represented by a String, return a list containing all subsets of the characters.
 * Notice that each subset returned will be sorted to remove the sequence.
 */
public class AllSubsetII {
    public List<String> allSubset(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] charSet = set.toCharArray();
        Arrays.sort(charSet); // to make sure we can deduplicate
        StringBuilder sb = new StringBuilder();
        helper(charSet, 0, sb, result);
        return result;
    }

    private void helper(char[] set, int index, StringBuilder sb, List<String> result) {
        if (index == set.length) {
            result.add(sb.toString());
            return;
        }
        sb.append(set[index]);
        helper(set, index  + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        while (index < set.length - 1 && set[index] == set[index + 1]) { // when we dont add, we skip all same char
            index++;
        }
        helper(set, index + 1, sb, result);
    }
}

/**
 * time complexity: O(nlogn + n*2^n) = O(n*2^n)
 * space complexity: O(n)
 */