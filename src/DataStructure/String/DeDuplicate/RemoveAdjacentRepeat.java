package DataStructure.String.DeDuplicate;

/**
 * DataStructure.String.Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
 */
public class RemoveAdjacentRepeat {
    public String deDuplicate(String input) {
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (slow == 0 || array[fast] != array[slow - 1]) {
                array[slow++] = array[fast++];
            } else {
                fast++;
            }
        }
        return new String(array, 0, slow);
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */