package Algorithm.GraphSearch.DepthFirstSearch.Coins;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer number, return all possible combinations of the factors that can multiply to the target number.
 */
public class NumberFactor {
    public List<List<Integer>> combination(int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target <= 1) {
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        List<Integer> factors = getFactors(target);
        helper(factors, 0, target, cur, result);
        return result;
    }

    private List<Integer> getFactors(int target) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i < target; i++) {
            if (target % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    private void helper(List<Integer> factors, int index, int target, List<Integer> cur, List<List<Integer>> result) {
        if (index == factors.size()) {
            if (target == 1) {
                result.add(new ArrayList<>(cur));
            }
            return;
        }
        helper(factors, index + 1, target, cur, result);
        int factor = factors.get(index);
        int size = cur.size();
        while (target % factor == 0) {
            cur.add(factor);
            target /= factor;
            helper(factors, index + 1, target, cur, result);
        }
        cur.subList(size, cur.size()).clear();
    }
}

/**
 * time complexity: O(target ^ k)
 * space complexity: O(k) k is number of factors
 */