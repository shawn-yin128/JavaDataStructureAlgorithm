package OneD;

/**
 * Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
 * A[i] means the maximum jump distance from index i (you can only jump towards the end of the array).
 * Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.
 */
public class ArrayHopperII {
    public int minJump(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        int[] jump = new int[array.length];
        jump[array.length - 1] = 0;
        for (int i = array.length - 2; i >= 0; i--) {
            jump[i] = -1;
            if (i + array[i] >= array.length - 1) {
                jump[i] = 1;
            } else {
                for (int j = array[i]; j >= 1; j++) {
                    if (jump[i + j] != -1) {
                        jump[i] = jump[i] == -1 ? jump[i + j] + 1 : Math.min(jump[i], jump[i + j] + 1);
                    }
                }
            }
        }
        return jump[0];
    }
}

/**
 * time complexity: O(n^2)
 * space complexity: O(n)
 */