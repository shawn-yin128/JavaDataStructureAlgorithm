package DataStructure.Array.TwoDArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.
 */
public class SpiralTraverseMatrixII {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        helper(matrix, 0, row, col, result);
        return result;
    }

    private void helper(int[][] matrix, int offset, int row, int col, List<Integer> result) {
        if (row == 0 || col == 0) {
            return;
        }
        if (row == 1 && col == 1) {
            result.add(matrix[offset][offset]);
            return;
        } else if (row == 1) {
            for (int i = 0; i < col; i++) {
                result.add(matrix[offset][offset + i]);
            }
            return;
        } else if (col == 1) {
            for (int i = 0; i < row; i++) {
                result.add(matrix[offset + i][offset]);
            }
            return;
        }
        for (int i = 0; i < col - 1; i++) {
            result.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < row - 1; i++) {
            result.add(matrix[offset + i][offset + col - 1]);
        }
        for (int i = col - 1; i > 0; i--) {
            result.add(matrix[offset + row - 1][offset + i]);
        }
        for (int i = row - 1; i > 0; i--) {
            result.add(matrix[offset + i][offset]);
        }
        helper(matrix, offset + 1, row - 2, col - 2, result);
    }
}