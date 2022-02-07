package Algorithm.DynamicProgramming.TwoDArray;

/**
 * There is an array of positive integers, in which each integer represents a piece of Pizza’s size,
 * you and your friend take turns to pick pizza from either end of the array.
 * Your friend follows a simple strategy: !!!!
 *      He will always pick the larger one he could get during his turn.
 * The winner is the one who gets the larger total sum of all pizza.
 * Return the max amount of pizza you can get.
 */
public class CanIWinII {
    public int canWin(int[] nums) {
        int n = nums.length;
        int[][] M = new int[n][n];
        for(int j = 0; j < nums.length; j++){
            for(int i = j; i >= 0; i--){
                if (i == j){
                    M[i][j] = nums[j];
                } else if (i + 1 == j){
                    M[i][j] = Math.max(nums[i], nums[j]);
                } else {
                    int temp1 = nums[i];
                    int temp2 = nums[j];
                    temp1 += nums[i + 1] > nums[j] ? M[i + 2][j] : M[i + 1][j - 1];
                    temp2 += nums[i] > nums[j - 1] ? M[i + 1][j - 1] : M[i][j - 2];
                    M[i][j] = Math.max(temp1, temp2);
                }
            }
        }
        return M[0][n-1];
    }
}
