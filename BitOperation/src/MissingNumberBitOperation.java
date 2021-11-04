/**
 * Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.
 */
public class MissingNumberBitOperation {
    public int missNumber(int[] array) {
        int n = array.length + 1;
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        for (int num : array) {
            xor ^= num;
        }
        return xor;
    }
}
/**
 * time complexity: O(n)
 * space complexity: O(1)
 */
