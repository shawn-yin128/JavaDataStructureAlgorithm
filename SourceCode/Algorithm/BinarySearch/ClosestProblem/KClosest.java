package Algorithm.BinarySearch.ClosestProblem;

/**
 * input stored array, an int target, an int k standing for how many elements wanted
 * output an int array consisting of closest value
 * assume 0 <= k <= array.length always
 * if k == 0, return empty array
 */
public class KClosest {
    public static void main(String[] args) {
        int[] array1 = null;
        int[] res1 = kClosest(array1, 4, 3);
        for (int i = 0; i < res1.length; i++) {
            System.out.print(res1[i]);
        }
        System.out.println();
        int[] array2 = new int[] {};
        int[] res2 = kClosest(array2, 4, 3);
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i]);
        }
        System.out.println();
        int[] array3 = new int[] {1};
        int[] res3 = kClosest(array3, 4, 3);
        for (int i = 0; i < res3.length; i++) {
            System.out.print(res3[i]);
        }
        System.out.println();
        int[] array4 = new int[] {1, 2};
        int[] res4 = kClosest(array4, 4, 3);
        for (int i = 0; i < res4.length; i++) {
            System.out.print(res4[i]);
        }
        System.out.println();
        int[] array5 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] res5 = kClosest(array5, 4, 3);
        for (int i = 0; i < res5.length; i++) {
            System.out.print(res5[i]);
        }
        System.out.println();
    }
    public static int[] kClosest(int[] array, int target, int k) {
        if (array == null || array.length == 0) {
            return new int[] {-1, -1};
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (left >= 0 && right <= array.length - 1) {
                if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
                    res[i] = array[left--];
                } else {
                    res[i] = array[right++];
                }
            } else if (left >= 0) {
                res[i] = array[left--];
            } else if (right <= array.length - 1) {
                res[i] = array[right++];
            }
        }
        return res;
    }
}

/**
 * time complexity: O(logn + k)
 * space complexity: O(1)
 */
