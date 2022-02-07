package Algorithm.DynamicProgramming.OneDArray;

/**
 * Given an array A[0]...A[n-1] of integers, find out the longest ascending subsequence.
 * If there are multiple results, then return any valid result.
 */
public class LogestAscendingSubsequenceII {
    public int[] longest(int[] array) {
        if (array.length == 0) {
            return new int[] {};
        }
        int[] longest = new int[array.length];
        int result = 1;
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            longest[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    longest[i] = Math.max(longest[j] + 1, longest[i]);
                }
            }
            int resultTmp = result;
            result = Math.max(longest[i], result);
            if (resultTmp != result) {
                end = i;
            }
        }
        int[] res = new int[result];
        for (int m = end; m >= 0; m--) {
            if (longest[m] == result) {
                res[--result] = array[m];
            }
        }
        return res;
    }
}
