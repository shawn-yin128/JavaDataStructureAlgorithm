package Algorithm.DynamicProgramming.TwoDArray;

/**
 * Determine the largest square surrounded by 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.
 */
public class LargestSquareSurroundedByOne {
    public int largestSquare1(int[][] matrix) {
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
        int[][] left = new int[n][m];
        int[][] up = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 && j == 0) {
                        left[i][j] = 1;
                        up[i][j] = 1;
                    } else if (i == 0) {
                        left[i][j] = left[i][j - 1] + 1;
                        up[i][j] = 1;
                    } else if (j == 0) {
                        left[i][j] = 1;
                        up[i][j] = up[i - 1][j] + 1;
                    } else {
                        up[i][j] = up[i - 1][j] + 1;
                        left[i][j] = left[i][j - 1] + 1;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int leftLength = left[i][j];
                int upLength = up[i][j];
                for (int size = Math.min(leftLength, upLength); size >= 1; size--) {
                    if (left[i - size + 1][j] >= size && up[i][j - size + 1] >= size) {
                        result = Math.max(result, size);
                        break;
                    }
                }
            }
        }
        return result;
    }
}

/**
 * time complexity: O(N * M * min(N, M))
 * space complexity: O(N * M)
 */