package Algorithm.DynamicProgramming.PrefixSum;

/**
 * Given a matrix that contains integers, find the submatrix with the largest sum.
 * Return the sum of the submatrix.
 */
public class LargestSubmatrixSum {
    public int largestSubmatrix(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] cur = new int[m];
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    cur[k] += matrix[j][k];
                }
                int curMax = cur[0];
                int prev = cur[0];
                for (int l = 1; l < m; l++) {
                    prev = Math.max(prev + cur[l], cur[l]);
                    curMax = Math.max(curMax, prev);
                }
                result = Math.max(result, curMax);
            }
        }
        return result;
    }
}

/**
 * time complexity: O(N * N * M)
 * space complexity: O(N * M)
 */