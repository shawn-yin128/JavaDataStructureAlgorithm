import java.util.ArrayList;
import java.util.List;

/**
 * Given N pairs of parentheses “()”, return a list with all the valid permutations.
 */
public class ParenthesesPermutation {
    public List<String> parentheses(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(n, 0, 0, sb, result);
        return result;
    }

    private void helper(int n, int l, int r, StringBuilder sb, List<String> result) {
        if (l == n && r == n) {
            result.add(sb.toString());
            return;
        }
        if (l < n) {
            sb.append('(');
            helper(n, l + 1, r, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (l > r) {
            sb.append(')');
            helper(n, l, r + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

/**
 * time complexity: O(2^(2n))
 * space complexity: O(n)
 */