package DataStructure.String.Reverse;

/**
 * DataStructure.String.Reverse a given string.
 */
public class ReverseString {
    // iterative
    public String reverseStrIterative(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            swap(array, left++, right--);
        }
        return new String(array);
    } // time complexity: O(n), space complexity: O(n)

    // recursive
    public String reverseStrRecursive(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        helper(array, 0, array.length - 1);
        return new String(array);
    }
    private void helper(char[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(array, left, right);
        helper(array, left + 1, right - 1);
    } // time complexity: O(n), space complexity: O(n)

    // common method
    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
