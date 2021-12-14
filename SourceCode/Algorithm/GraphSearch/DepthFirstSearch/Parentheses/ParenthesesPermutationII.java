package Algorithm.GraphSearch.DepthFirstSearch.Parentheses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.
 */
public class ParenthesesPermutationII {
    public List<String> validParentheses(int l, int m, int n) {
        final char[] ps = new char[] {'(', ')', '<', '>', '{', '}'};
        int[] remain = new int[] {l, l, m, m, n, n};
        int target = l*2 + m*2 + n*2;
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        helper(ps, remain, target, sb, stack, result);
        return result;
    }

    private void helper(char[] ps, int[] remain, int target, StringBuilder sb, Deque<Character> stack, List<String> result) {
        if (sb.length() == target) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {
                if (remain[i] > 0) {
                    sb.append(ps[i]);
                    stack.offerFirst(ps[i]);
                    remain[i]--;
                    helper(ps, remain, target, sb, stack, result);
                    stack.pollFirst();
                    sb.deleteCharAt(sb.length() - 1);
                    remain[i]++;
                }
            } else {
                if (!stack.isEmpty() && stack.peekFirst() == ps[i - 1]) {
                    sb.append(ps[i]);
                    stack.pollFirst();
                    remain[i]--;
                    helper(ps, remain, target, sb, stack, result);
                    stack.offerFirst(ps[i - 1]);
                    sb.deleteCharAt(sb.length() - 1);
                    remain[i]++;
                }
            }
        }
    }
}

/**
 * time complexity: O(2^2*(l+m+n))
 * space complexity: O(l+m+n)
 */