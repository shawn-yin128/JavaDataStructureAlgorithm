/**
 * input is sorted matrix, int target
 * find the index of target in a 2d matrix
 */
public class MatrixBS {
    public static void main(String[] args) {
        int[][] mat1 = null;
        int[] res1 = MatrixBinarySearch(mat1, 1);
        System.out.println(res1[0]+" "+res1[1]);
        int[][] mat2 = new int[][] {{1,2},{3,4}};
        int[] res2 = MatrixBinarySearch(mat2, 3);
        System.out.println(res2[0]+" "+res2[1]);
    }
    public static int[] MatrixBinarySearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return new int[] {-1, -1};
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row*col-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midRow = mid / col;
            int midCol = mid % col;
            if (matrix[midRow][midCol] > target) {
                right = mid - 1;
            } else if (matrix[midRow][midCol] < target) {
                left = mid + 1;
            } else {
                return new int[] {midRow, midCol};
            }
        }
        return new int[] {-1, -1};
    }
}
