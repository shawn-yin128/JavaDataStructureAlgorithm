package DataStructure.Array.KArray;

import java.util.Arrays;

public class CommonElementsInKSortedArray {
    public int[] common(int[][] arrays) {
        int[] result = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            result = helper(result, arrays[i]);
        }
        return result;
    }

    private int[] helper(int[] l1, int[] l2) {
        int i = 0;
        int j = 0;
        int cur = 0;
        int[] result = new int[Math.min(l1.length, l2.length)];
        while (i < l1.length && j < l2.length) {
            if (l1[i] == l2[j]) {
                result[cur++] = l1[i];
                i++;
                j++;
            } else if (l1[i] < l2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(result, 0, cur);
    }
}