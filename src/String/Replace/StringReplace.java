package Replace;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an original string input, and two strings S and T, from left to right replace all occurrences of S in input with T.
 */
public class StringReplace {
    public String replace(String input, String s, String t) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        if (s.length() <= t.length()) {
            return replaceLong(array, s, t);
        }
        return replaceShort(array, s, t);
    }

    public String replaceShort(char[] array, String s, String t) {
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (fast <= array.length - s.length() && equalSubstring(array, fast, s)) {
                copySubstring(array, slow, t);
                slow += t.length();
                fast += s.length();
            } else {
                array[slow++] = array[fast++];
            }
        }
        return new String(array, 0, slow);
    }

    public String replaceLong(char[] array, String s, String t) {
        List<Integer> allMatches = getMatches(array, s);
        char[] result = new char[array.length + allMatches.size() * (t.length() - s.length())];
        int lastIndex = allMatches.size() - 1;
        int slow = result.length - 1;
        int fast = array.length - 1;
        while (fast >= 0) {
            if (lastIndex >= 0 && fast == allMatches.get(lastIndex)) {
                copySubstring(result, slow - t.length() + 1, t);
                slow -= t.length();
                fast -= s.length();
                lastIndex--;
            } else {
                result[slow--] = array[fast--];
            }
        }
        return new String(result);
    }

    private boolean equalSubstring(char[] array, int index, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (array[index + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void copySubstring(char[] array, int index, String t) {
        for (int i = 0; i < t.length(); i++) {
            array[index + i] = t.charAt(i);
        }
    }

    private List<Integer> getMatches(char[] array, String s) {
        List<Integer> match = new ArrayList<>();
        int i = 0;
        while (i <= array.length - s.length()) {
            if (equalSubstring(array, i, s)) {
                match.add(i + s.length() - 1);
                i += s.length();
            } else {
                i++;
            }
        }
        return match;
    }
}
