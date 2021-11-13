package Algorithm.BinarySearch.OccurenceProblem;

/**
 * input sorted array and target
 * find the index of the last occurrence of target
 */
public class LastOccurrence {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 4, 4, 5};
        int res = lastOccur(array, 4);
        System.out.println(res);
    }
    public static int lastOccur(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                left = mid;
            }
        }
        if (array[right] == target) {
            return right;
        } else if (array[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}

/**
 * time complexity: O(logn)
 * space complexity: O(1)
 */
