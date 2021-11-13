package Algorithm.DynamicProgramming.TwoDArray;

/**
 * Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.
 */
public class LargestSquareOf1 {
    public int largest(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int result = 0;
        int[][] largest = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == 0 || j == 0) {
                    largest[i][j] = matrix[i][j] == 1 ? 1 : 0;
                } else if (matrix[i][j] == 1) {
                    largest[i][j] = Math.min(largest[i - 1][j - 1] + 1, Math.min(largest[i][j - 1] + 1, largest[i - 1][j] + 1));
                }
                result = Math.max(result, largest[i][j]);
            }
        }
        return result;
    }
}

/**
 * time complexity: O(n^2)
 * space complexity: O(n^2)
 */