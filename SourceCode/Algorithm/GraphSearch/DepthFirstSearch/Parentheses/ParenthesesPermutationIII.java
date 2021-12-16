package Algorithm.GraphSearch.DepthFirstSearch.Parentheses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {},
 * subject to the priority restriction: {} higher than <> higher than ().
 */
public class ParenthesesPermutationIII {
    public List<String> parentheses(int l, int m, int n) {
        char[] ps = new char[] {'(', ')', '<', '>', '{', '}'};
        int target = (l + m + n) * 2;
        int[] remain = new int[] {l, l, m, m, n, n};
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        helper(remain, ps, target, sb, stack, result);
        return result;
    }

    private void helper(int[] remain, char[] ps, int target, StringBuilder sb, Deque<Integer> stack, List<String> result) {
        if (sb.length() == target) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {
                if (remain[i] > 0 && (stack.isEmpty() || stack.peekFirst() > i)) {
                    sb.append(ps[i]);
                    stack.offerFirst(i);
                    remain[i]--;
                    helper(remain, ps, target, sb, stack, result);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                    remain[i]++;
                }
            } else {
                if (!stack.isEmpty() && stack.peekFirst() == i - 1) {
                    sb.append(ps[i]);
                    stack.pollFirst();
                    remain[i]--;
                    helper(remain, ps, target, sb, stack, result);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.offerFirst(i - 1);
                    remain[i]++;
                }
            }
        }
    }
}

/**
 * time complexity: O(2^(2(l+m+n)))
 * space complexity: O(l+m+n)
 */