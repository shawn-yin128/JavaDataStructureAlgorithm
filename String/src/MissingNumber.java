import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.
 */
public class MissingNumber {
    // method 1: traverse with HashSet
    public int missNumberOne(int[] array) {
        if (array == null) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int num : array) {
            set.add(num);
        }
        for (int i = 1; i < array.length + 1; i++) { // start with 1
            if (!set.contains(i)) {
                return i;
            }
        }
        return array.length + 1;
    }
    /**
     * time complexity: O(m)
     * space complexity: O(n)
     */

    // method 2: use sum
    public int missNumberTwo(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        int n = array.length + 1;
        int targetSum = (1 + n) * n / 2;
        int result = targetSum - sum;
        return result;
    }
    /**
     * time complexity: O(n)
     * space complexity: O(1)
     */
}
