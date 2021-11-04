package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents.
 */
public class CoinsCombination {
    public List<List<Integer>> coinsCombination(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (target <= 0 || coins == null) {
            return result;
        }
        List<Integer> cur = new ArrayList<Integer>();
        helper(target, coins, 0, cur, result);
        return result;
    }

    private void helper(int target, int[] coins, int index, List<Integer> cur, List<List<Integer>> result) {
        if (index == coins.length - 1) { // int[]'s length is a field not method
            if (target % coins[coins.length - 1] == 0) {
                cur.add(target / coins[coins.length - 1]);
                result.add(new ArrayList<>(cur)); // need to new, because we need to reuse cur
                cur.remove(cur.size() - 1);
            }
            return;
        }
        int max = target / coins[index];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            helper(target - i * coins[index], coins, index + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}

/**
 * time complexity: O(target ^ k) k is number of coins
 * space complexity: O(k)
 */