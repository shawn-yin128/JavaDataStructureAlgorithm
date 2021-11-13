package Algorithm.BinarySearch.ClosestProblem;

/**
 * input sorted array, an int target
 * find the index of element that is closest to target or equal and return the index
 */
public class ClosestInSortedArray {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5};
        int res1 = closetInSortedArray(array, 2);
        System.out.println(res1);
        int res2 = closetInSortedArray(array, 9);
        System.out.println(res2);
    }
    public static int closetInSortedArray(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
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
                return mid;
            }
        }
        if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
            return left;
        } else {
            return right;
        }
    }
}

/**
 * time complexity analysis: O(logn)
 * space complexity analysis: O(1)
 */
