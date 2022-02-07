package Algorithm.DynamicProgramming.OneDArray;

/**
 * Given an array A[0]...A[n-1] of integers,
 * count the number of ascending subsequences.
 */
public class CountAscendingSubsequence {
    public int numIncreasingSubsequences(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int[] M = new int[a.length];
        int count = 0;
        M[0] = 1;
        count += M[0];
        for (int i = 1; i < a.length; i++) {
            M[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) {
                    M[i] += M[j];
                }
            }
            count += M[i];
        }
        return count;
    }
}
