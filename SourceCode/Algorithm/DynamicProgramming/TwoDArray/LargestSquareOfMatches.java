package Algorithm.DynamicProgramming.TwoDArray;

/**
 * Determine the largest square surrounded by a bunch of matches (each match is either horizontal or vertical), return the length of the largest square.
 * The input is a matrix of points. Each point has one of the following values:
 * 0 - there is no match to its right or bottom.
 * 1 - there is a match to its right.
 * 2 - there is a match to its bottom.
 * 3 - there is a match to its right, and a match to its bottom.
 */
public class LargestSquareOfMatches {
    public int largestSquareMatch(int[][] matrix) {
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
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                } else if (matrix[i][j] == 2) {
                    down[i][j] = down[i + 1][j] + 1;
                } else if (matrix[i][j] == 3) {
                    right[i][j] = right[i][j + 1] + 1;
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int rightLength = right[i][j];
                int downLength = down[i][j];
                for (int size = Math.min(rightLength, downLength); size >= 1; size--) {
                    if (right[i + size][j] >= size && down[i][j + size] >= size) {
                        result = Math.max(result, size);
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