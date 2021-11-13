package Algorithm.DynamicProgramming.OneDArray;

/**
 * Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).
 */
public class Fibonacci {
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        int lastOne = 1;
        int lastTwo = 0;
        for (int i = 2; i <= n; i++) {
            int temp = lastTwo;
            lastTwo = lastOne;
            lastOne = lastOne + temp;
        }
        return lastOne;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */