package OneD;

/**
 * Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.
 */
public class MaxProduct {
    public int maxProduct(int length) {
        int[] array = new int[length + 1];
        array[1] = 0;
        for (int i = 2; i <= length; i++) {
            for (int j = 1; j < i; j++) {
                array[i] = Math.max(array[i], Math.max(i - j, array[i - j]) * j);
            }
        }
        return array[length];
    }
}

/**
 * time complexity: O(n^2)
 * space complexity: O(n)
 */