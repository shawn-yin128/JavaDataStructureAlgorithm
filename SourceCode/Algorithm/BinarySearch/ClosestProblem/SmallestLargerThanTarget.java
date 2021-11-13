package Algorithm.BinarySearch.ClosestProblem;

/**
 * input sorted array, int target
 * find the element that is smallest larger than target
 * return index
 */
public class SmallestLargerThanTarget {
    public static void main(String[] args) {
        int[] array1 = null;
        int res1 = smallestLargerThanTarget(array1, 4);
        System.out.println(res1);
        int[] array2 = new int[] {};
        int res2 = smallestLargerThanTarget(array2, 4);
        System.out.println(res2);
        int[] array3 = new int[] {1};
        int res3 = smallestLargerThanTarget(array3, 4);
        System.out.println(res3);
        int[] array4 = new int[] {1, 2};
        int res4 = smallestLargerThanTarget(array4, 4);
        System.out.println(res4);
        int[] array5 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int res5 = smallestLargerThanTarget(array5, 4);
        System.out.println(res5);
    }
    public static int smallestLargerThanTarget(int[] array, int target) {
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
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        if (array[left] > target) {
            return left;
        } else if (array[right] > target) {
            return right;
        } else {
            return -1;
        }
    }
}

/**
 * time complexity: O(logn)
 * space complexity: O(1)
 */