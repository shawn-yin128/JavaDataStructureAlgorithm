package OccurenceProblem;

/**
 * input sorted array and target
 * find the index of the first occurrence of target
 */
public class FirstOccurrence {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 4, 4, 5};
        int res = firstOccur(array, 4);
        System.out.println(res);
    }
    public static int firstOccur(int[] array, int target) {
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
                right = mid;
            }
        }
        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
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
