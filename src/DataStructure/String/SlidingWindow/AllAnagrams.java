package DataStructure.String.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find all occurrence of anagrams (same letter different order) of a given string s in a given string l. Return the list of starting indices.
 */
public class AllAnagrams {
    public List<Integer> anagrams(String s, String l) {
        List<Integer> result = new ArrayList<>();
        if (l == null || s.length() > l.length()) {
            return result;
        }
        Map<Character, Integer> map = getMap(s);
        int match = 0;
        for (int i = 0; i < l.length(); i++) {
            char temp = l.charAt(i);
            Integer freq = map.get(temp);
            if (freq != null) {
                map.put(temp, freq - 1);
                if (freq == 1) {
                    match++;
                }
            }
            if (i >= s.length()) {
                temp = l.charAt(i - s.length());
                freq = map.get(temp);
                if (freq != null) {
                    map.put(temp, freq + 1);
                    if (freq == 0) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                result.add(i - s.length() + 1);
            }
        }
        return result;
    }

    private Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Integer freq = result.get(ch);
            if (freq != null) {
                result.put(ch, freq + 1);
            } else {
                result.put(ch, 1);
            }
        }
        return result;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(d) d is number of alphabet in s
 */