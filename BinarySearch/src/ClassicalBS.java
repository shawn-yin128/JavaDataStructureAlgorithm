/**
 * input sorted array, and int target
 * output the target's index
 * if not in array or array is null or empty, return -1
 */
public class ClassicalBS {
    public static void main(String[] args) {
        int[] array1 = {};
        int res1 = binarySearchClassical(array1, 3);
        System.out.println(res1);
        int[] array2 = null;
        int res2 = binarySearchClassical(array2, 3);
        System.out.println(res2);
        int[] array3 = {1, 2};
        int res3 = binarySearchClassical(array3, 3);
        System.out.println(res3);
        int[] array4 = {1, 2, 3};
        int res4 = binarySearchClassical(array4, 3);
        System.out.println(res4);
    }
    public static int binarySearchClassical(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

/**
 * time complexity analysis: at k round, the rest of elements are n*(1/2)^k. when this term = 1, end. so k which is total runing round is logn -> O(logn)
 * space complexity analysis: O(1)
 */
