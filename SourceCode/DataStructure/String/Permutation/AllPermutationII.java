package DataStructure.String.Permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string with possible duplicate characters, return a list with all permutations of the characters.
 */
public class AllPermutationII {
    public List<String> permutation(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }

    private void helper(char[] array, int index, List<String> result) {
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        Set<Character> visit = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (visit.add(array[i])) {
                swap(array, index, i);
                helper(array, index + 1, result);
                swap(array, index, i);
            }
        }
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

/**
 * time complexity: O(n!)
 * space complexity: O(n!)
 */