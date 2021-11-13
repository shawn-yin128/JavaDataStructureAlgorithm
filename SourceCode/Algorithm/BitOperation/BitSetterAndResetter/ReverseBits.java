package Algorithm.BitOperation.BitSetterAndResetter;

/**
 * DataStructure.String.Reverse bits of a 32-bit integer.
 */
public class ReverseBits {
    public long reverseBit(long n) {
        for (int offset = 0; offset < 16; offset++) {
            long right = (n >> offset) & 1L;
            long left = (n >> (31 - offset)) & 1L;
            if (left != right) {
                if (left == 0) {
                    n = n | (1L << (31 - offset));
                } else if (left == 1) {
                    n = n & ~(1L << (31 - offset));
                }
                if (right == 0) {
                    n = n | (1L << offset);
                } else if (right == 1) {
                    n = n & ~(1L << offset);
                }
            }
        }
        return n;
    }
}

/**
 * time complexity = O(1)
 * space complexity = O(1)
 */