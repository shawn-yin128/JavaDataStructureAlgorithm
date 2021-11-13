package DataStructure.String.EncodingDecoding;

/**
 * Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences.
 */
public class CompressString {
    public String compress(String input) {
        if (input == null) {
            return input;
        }
        char[] array = input.toCharArray();
        return encode(array);
    }

    private String encode(char[] array) {
        int slow = 0;
        int fast = 0;
        int newLength = 0;
        while (fast < array.length) {
            int begin = fast;
            while (fast < array.length && array[fast] == array[begin]) {
                fast++;
            }
            array[slow++] = array[begin];
            if (fast - begin == 1) {
                newLength += 2;
            } else {
                int len = getLen(array, slow, fast - begin);
                slow += len;
                newLength += len + 1;
            }
        }
        char[] result = new char[newLength];
        fast = slow - 1;
        slow = newLength - 1;
        while (fast >= 0) {
            if (Character.isDigit(array[fast])) {
                while (fast >= 0 && Character.isDigit(array[fast])) {
                    result[slow--] = array[fast--];
                }
            } else {
                result[slow--] = '1';
            }
            result[slow--] = array[fast--];
        }
        return new String(result);
    }

    private int getLen(char[] array, int index, int count) {
        int len = 0;
        for (int i = count; i > 0; i /= 10) {
            index++;
            len++;
        }
        for (int i = count; i > 0; i /= 10) {
            int digit = i % 10;
            array[--index] = (char) ('0' + digit);
        }
        return len;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */