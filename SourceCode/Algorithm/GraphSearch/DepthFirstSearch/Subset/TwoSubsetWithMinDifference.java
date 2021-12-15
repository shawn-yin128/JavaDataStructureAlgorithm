package Algorithm.GraphSearch.DepthFirstSearch.Subset;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of n integers, divide the set in two subsets of n/2 sizes each
 * such that the difference of the sum of two subsets is as minimum as possible.
 * Return the minimum difference(absolute value).
 */
public class TwoSubsetWithMinDifference {
    public int minDifference(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        int[] min = new int[] {Integer.MAX_VALUE};
        List<Integer> cur = new ArrayList<>();
        int n = array.length;
        helper(array, 0, n, sum, cur, min);
        return min[0];
    }

    private int getSum(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    private void helper(int[] array, int index, int n, int sum, List<Integer> cur, int[] min) {
        if (cur.size() == n / 2) {
            int curSum = getSum(cur);
            int diff = Math.abs(curSum - (sum - curSum));
            min[0] = Math.min(min[0], diff);
            return;
        }
        if (index == array.length) {
            return;
        }
        cur.add(array[index]);
        helper(array, index + 1, n, sum, cur, min);
        cur.remove(cur.size() - 1);
        helper(array, index + 1, n, sum, cur, min);
    }
}

/**
 * time complexity: O(n2^(n/2))
 * space complexity: O(n)
 */