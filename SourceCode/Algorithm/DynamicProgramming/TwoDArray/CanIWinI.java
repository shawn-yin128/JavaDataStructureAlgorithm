package Algorithm.DynamicProgramming.TwoDArray;

/**
 * There is an array of positive integers,
 * in which each integer represents a piece of Pizza’s size,
 * you and your friend take turns to pick pizza from either end of the array.
 * The winner is the one who gets larger total sum of all pizza or whoever starts first if there is a tie.
 * Return whether you will win the game if you start first.
 */
public class CanIWinI {
    public boolean canWin(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int[][] M = new int[n][n];
        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            for(int i = j; i >= 0; i--){
                if (i == j){
                    M[i][j] = nums[j];
                } else if (i + 1 == j){
                    M[i][j] = Math.max(nums[i], nums[j]);
                } else {
                    int temp1 = nums[i] + Math.min(M[i + 2][j], M[i + 1][j - 1]);
                    int temp2 = nums[j] + Math.min(M[i + 1][j - 1], M[i][j - 2]);
                    M[i][j] = Math.max(temp1, temp2);
                }
            }
        }
        return M[0][n-1] >= sum - M[0][n-1];
    }
}
