package BitExtracter;

/**
 * Determine if a given integer is power of 2.
 */
public class PowerOfTwo {
    public boolean powerTwo(int number) {
        if (number <= 0) {
            return false;
        }
        int count = 0;
        while (number > 0) {
            count += number & 1;
            number >>= 1;
        }
        return count == 1;
    }
}

/**
 * time complexity: O(logn) set k times, the last time residual element is n/2^k = 1 --> k = logn
 * space complexity: O(1)
 */