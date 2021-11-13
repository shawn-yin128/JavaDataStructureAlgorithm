package DataStructure.String.Remove;

import java.util.HashSet;
import java.util.Set;

/**
 * DataStructure.String.Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.
 */
public class RemoveCertainChar {
    public String remove(String input, String target) {
        char[] array = input.toCharArray();
        Set<Character> set = buildSet(target);
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if(set.contains(array[fast])) {
                fast++;
            } else {
                array[slow++] = array[fast++];
            }
        }
        return new String(array, 0, slow);
    }
    private Set<Character> buildSet(String string) {
        Set<Character> result = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            result.add(string.charAt(i));
        }
        return result;
    }
}

/**
 * time complexity: O(m + n) m and n are number of element in input and target
 * space complexity: O(m + n)
 */
