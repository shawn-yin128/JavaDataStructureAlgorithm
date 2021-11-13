package DataStructure.String.EncodingDecoding;

/**
 * Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.
 */
public class DeCompressString {
    public String decompress(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        char[] array = input.toCharArray();
        return decodeLong(array, decodeShort(array));
    }

    private int decodeShort(char[] array) {
        int end = 0;
        for (int i = 0; i < array.length; i += 2) {
            int digit = getDigit(array[i + 1]);
            if (digit >= 0 && digit <=2) {
                for (int j = 0; j < digit; j++) {
                    array[end++] = array[i];
                }
            } else {
                array[end++] = array[i];
                array[end++] = array[i + 1];
            }
        }
        return end;
    }

    private String decodeLong(char[] array, int length) {
        int newLength = length;
        for (int i = 0; i < length; i++) {
            int digit = getDigit(array[i]);
            if (digit > 2 && digit <= 9) {
                newLength += digit - 2;
            }
        }
        char[] result = new char[newLength];
        int end = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            int digit = getDigit(array[i]);
            if (digit > 2 && digit <= 9) {
                i--;
                for (int j = 0; j < digit; j++) {
                    result[end--] = array[i];
                }
            } else {
                result[end--] = array[i];
            }
        }
        return new String(result);
    }

    private int getDigit(char digit) {
        return digit - '0';
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */
