package Algorithm.BitOperation.BitRepresentation;

/**
 * Generate the hexadecimal representation for a given non-negative integer number as a string. The hex representation should start with "0x".
 */
public class Hexadecimal {
    public String hex(int number) {
        String prefix = "0x";
        if (number == 0) {
            return prefix + "0";
        }
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int rem = number % 16;
            if (rem < 10) {
                sb.append((char)('0' + rem));
            } else {
                sb.append((char)(rem - 10 + 'A'));
            }
            number >>= 4;
        }
        return prefix + sb.reverse().toString();
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */
