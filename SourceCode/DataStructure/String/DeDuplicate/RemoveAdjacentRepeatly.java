package DataStructure.String.DeDuplicate;

/**
 * Repeatedly remove all adjacent, repeated characters in a given string from left to right.
 * No adjacent characters should be identified in the final string.
 * "abbbaaccz" → "aaaccz" → "ccz" → "z"
 */
public class RemoveAdjacentRepeatly {
    public String deDuplicateRepeat(String input) {
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (slow == 0 || array[fast] != array[slow - 1]) {
                array[slow++] = array[fast++];
            } else if (array[fast] == array[slow - 1]) {
                while (fast < array.length && array[fast] == array[slow - 1]) {
                    fast++;
                }
                slow--;
            }
        }
        if (slow == 0) { // maybe a case that all elements have duplicate
            return new String();
        }
        return new String(array, 0, slow);
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */