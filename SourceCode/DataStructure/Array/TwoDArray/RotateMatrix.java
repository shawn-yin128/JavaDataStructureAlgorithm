package DataStructure.Array.TwoDArray;

/**
 * Rotate an N * N matrix clockwise 90 degrees.
 */
public class RotateMatrix {
    public int[][] rotate(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int n = matrix.length;;
        if (n == 0) {
            return matrix;
        }
        helper(matrix, 0, n);
        return matrix;
    }

    private void helper(int[][] matrix, int offset, int size) {
        if (size <= 1) {
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            int temp = matrix[offset][offset + i];
            matrix[offset][offset + i] = matrix[offset + size - 1 - i][offset];
            matrix[offset + size - 1 -i][offset] = matrix[offset + size - 1][offset + size - 1 - i];
            matrix[offset + size - 1][offset + size - 1 - i] = matrix[offset + i][offset + size - 1];
            matrix[offset + i][offset + size - 1] = temp;
        }
        helper(matrix, offset + 1, size - 2);
    }
}

/**
 * time complexity: O(n^2)
 * space complexity: O(n)
 */
