package Algorithm.GraphSearch.DepthFirstSearch.GeneratCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a telephone keypad, and an int number,
 * print all words which are possible by pressing these numbers,
 * the output strings should be sorted.
 * {0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 : "pqrs", 8 : "tuv", 9 : "wxyz"}
 */
public class TelephonePadCombination {
    public String[] telephone(int number) {
        List<String> result = new ArrayList<>();
        char[] num = Integer.toString(number).toCharArray();
        StringBuilder sb = new StringBuilder();
        String[] dict = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(num, 0, dict, sb, result);
        return result.toArray(new String[0]);
    }

    private void helper(char[] num, int index, String[] dict, StringBuilder sb, List<String> result) {
        if (index == num.length) {
            result.add(sb.toString());
            return;
        }
        int curIndex = num[index] - '0';
        if (curIndex == 0 || curIndex == 1) { // notice!
            helper(num, index + 1, dict, sb, result);
        }
        char[] candidates = dict[curIndex].toCharArray();
        for (int i = 0; i < candidates.length; i++) {
            sb.append(candidates[i]);
            helper(num, index + 1, dict, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
