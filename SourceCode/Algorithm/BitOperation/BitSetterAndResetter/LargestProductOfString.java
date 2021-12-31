package Algorithm.BitOperation.BitSetterAndResetter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a dictionary containing many words,
 * find the largest product of two words’ lengths, such that the two words do not share any common characters.
 */
public class LargestProductOfString {
    public int largest(String[] dict) {
        Map<String, Integer> bitMap = getBitMap(dict);
        Arrays.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return 0;
                }
                return o1.length() < o2.length() ? 1 : -1;
            }
        });
        int result = 0;
        for (int i = 0; i < dict.length; i++) {
            for (int j =  i + 1; j < dict.length; j++) {
                int product = dict[i].length() * dict[j].length();
                if (product < result) {
                    break;
                }
                int bit1 = bitMap.get(dict[i]);
                int bit2 = bitMap.get(dict[j]);
                if ((bit1 & bit2) == 0) {
                    result = product;
                }
            }
        }
        return result;
    }

    private Map<String, Integer> getBitMap(String[] dict) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : dict) {
            int bit = 0;
            for (int i = 0; i < str.length(); i++) {
                bit |= 1 << (int)(str.charAt(i) - 'a');
            }
            map.put(str, bit);
        }
        return map;
    }
}

/**
 * time complexity: O(n^2 + sum of all words length when traverse to get bitMap)
 * space complexity: O(n)
 */