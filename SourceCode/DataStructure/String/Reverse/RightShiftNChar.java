package DataStructure.String.Reverse;

/**
 * Right shift a given string by n characters.
 * "abc", 4 -> "cab"
 * same with reverse words in sentence because it can be divided into two parts and each parts relative position matain unchanged
 */
public class RightShiftNChar {
    public String rightShift(String input, int n) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        n %= array.length;
        reverse(array, array.length - n, array.length - 1); // array.length - n is the position that the first element will be in result
        reverse(array, 0, array.length - n - 1);
        reverse(array, 0, array.length - 1);
        return new String(array);
    }
    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            swap(array, left++, right--);
        }
    }
    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */