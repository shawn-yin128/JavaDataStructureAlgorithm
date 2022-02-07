package Algorithm.DynamicProgramming.OneDArray;

/**
 * Given an array A[0]...A[n-1] of integers,
 * find out the length of the longest ascending subsequence.
 */
public class LogestAscendingSubsequenceI {
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] longest = new int[array.length];
        int result = 1;
        for (int i = 0; i < array.length; i++) {
            longest[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    longest[i] = Math.max(longest[j] + 1, longest[i]);
                }
            }
            result = Math.max(longest[i], result);
        }
        return result;
    }
}
