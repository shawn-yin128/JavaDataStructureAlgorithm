package Algorithm.DynamicProgramming.PrefixSum;

/**
 * suppose we want to repeatedly query sum between index i and j
 */
public class RepeatedQuerySum {
    public int prefixSum(int[] array, int i, int j) {
        int[] prefixArray = getPrefixSum(array);
        return prefixArray[j] - prefixArray[i] + array[i];
    }

    private int[] getPrefixSum(int[] array) {
        int[] result = new int[array.length];
        result[0] = array[0];
        for (int i = 1; i < result.length; i++) {
            result[i] = array[i] + result[i - 1];
        }
        return result;
    }
}
