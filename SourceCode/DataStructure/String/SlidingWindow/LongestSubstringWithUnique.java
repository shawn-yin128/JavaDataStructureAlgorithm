package DataStructure.String.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.
 */
public class LongestSubstringWithUnique {
    public int longest(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int longest = 0;
        Set<Character> set = new HashSet<>();
        while (right < input.length()) {
            if (set.contains(input.charAt(right))) {
                set.remove(input.charAt(left++));
            } else {
                set.add(input.charAt(right++));
                longest = Math.max(longest, right - left);
            }
        }
        return longest;
    }
}

/**
 * time complexity: O(n + d) n is input length, d is unique character in input
 * space complexity: O(d)
 */