package Algorithm.DynamicProgramming.TwoDArray;

/**
 * Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s, with the same arm lengths and the four arms joining at the central point.
 * Return the arm length of the largest X shape.
 */
public class LargestX1s {
    public int largestX(int[][] matrix) {
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
        int result = 0;
        int[][] leftUp = getLeftUp(matrix, n, m);
        int[][] leftDown = getLeftDown(matrix, n, m);
        int[][] rightUp = getRightUp(matrix, n, m);
        int[][] rightDown = getRightDown(matrix, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.max(Math.min(leftUp[i][j], Math.min(leftDown[i][j], Math.min(rightUp[i][j], rightDown[i][j]))), result);
            }
        }
        return result;
    }

    private int[][] getLeftUp(int[][] matrix, int n, int m) {
        int[][] leftUp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        leftUp[i][j] = 1;
                    } else {
                        leftUp[i][j] = leftUp[i - 1][j - 1] + 1;
                    }
                }
            }
        }
        return leftUp;
    }

    private int[][] getLeftDown(int[][] matrix, int n, int m) {
        int[][] leftDown = new int[n][m];
        for (int i = n -1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == n - 1 || j == 0) {
                        leftDown[i][j] = 1;
                    } else {
                        leftDown[i][j] = leftDown[i + 1][j - 1] + 1;
                    }
                }
            }
        }
        return leftDown;
    }

    private int[][] getRightUp(int[][] matrix, int n, int m) {
        int[][] rightUp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == m - 1) {
                        rightUp[i][j] = 1;
                    } else {
                        rightUp[i][j] = rightUp[i - 1][j + 1] + 1;
                    }
                }
            }
        }
        return rightUp;
    }

    private int[][] getRightDown(int[][] matrix, int n, int m) {
        int[][] rightDown = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == n - 1 || j == m - 1) {
                        rightDown[i][j] = 1;
                    } else {
                        rightDown[i][j] = rightDown[i + 1][j + 1] + 1;
                    }
                }
            }
        }
        return rightDown;
    }
}

/**
 * time complexity: O(N * M)
 * space complexity: O(N * M)
 */