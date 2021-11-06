package Reverse;

/**
 * Reverse the words in a sentence.
 * “I love Google” → “Google love I”
 */
public class ReverseWordsInSentence {
    public String reverseWord(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        // reverse all
        reverse(array, 0, array.length - 1);
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i;
            }
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                reverse(array, start, i);
            }
        }
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