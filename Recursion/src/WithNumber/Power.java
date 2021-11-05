package WithNumber;

/**
 * input a number and a power
 *  output int result
 */

public class Power {
    public static void main(String[] args) {

    }
    public static int power(int num, int pow) {
        if (pow == 0) {
            return 1;
        }
        if (num == 0) {
            return 0;
        }
        int half = power(num, pow/2);
        return pow % 2 == 0? half * half : half * half * num;
    }
}

/**
 * time complexity: O(log pow)
 * space complexity: O(log pow)
 */
