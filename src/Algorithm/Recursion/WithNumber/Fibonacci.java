package Algorithm.Recursion.WithNumber;

/**
 * input int n as the nth position's value
 * if n <= 0 return 0
 */

public class Fibonacci {
    public static void main(String[] args) {
        int n1 = -1;
        int n2 = 0;
        int n3 = 1;
        int n4 = 5;
        int res1 = fibonacci(n1);
        System.out.println(res1);
        int res2 = fibonacci(n2);
        System.out.println(res2);
        int res3 = fibonacci(n3);
        System.out.println(res3);
        int res4 = fibonacci(n4);
        System.out.println(res4);
    }
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci((n - 2));
    }
}

/**
 * time complexity: O(2^n)
 * space complexity: O(n)
 */