package Algorithm.GraphSearch.DepthFirstSearch.Permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.
 */
public class NQueens {
    public List<List<Integer>> nQueen(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        helper(n, cur, result);
        return result;
    }

    private void helper(int n, List<Integer> cur, List<List<Integer>> result) {
        if (cur.size() == n) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid(cur, i)) {
                cur.add(i);
                helper(n, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean valid(List<Integer> cur, int col) {
        int row = cur.size();
        for (int i = 0; i < row; i++) {
            if (cur.get(i) == col || Math.abs(cur.get(i) - col) == row - i) {
                return false;
            }
        }
        return true;
    }
}

/**
 * time complexity: O(n! * n)
 * space complexity: O(n)
 */