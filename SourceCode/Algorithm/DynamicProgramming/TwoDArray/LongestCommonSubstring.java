package Algorithm.DynamicProgramming.TwoDArray;

/**
 * Find the longest common substring of two given strings.
 */
public class LongestCommonSubstring {
    public String longestCommon(String source, String target) {
        char[] sa = source.toCharArray();
        char[] ta = target.toCharArray();
        int start = 0;
        int longest = 0;
        int[][] common = new int[sa.length][ta.length];
        for (int i = 0; i < sa.length; i++) {
            for (int j = 0; j < ta.length; j++) {
                if (sa[i] == ta[j]) {
                    if (i == 0 || j == 0) {
                        common[i][j] = 1;
                    } else {
                        common[i][j] = common[i - 1][j - 1] + 1;
                    }
                    if (common[i][j] > longest) {
                        longest = common[i][j];
                        start = i - longest + 1;
                    }
                }
            }
        }
        return source.substring(start, start + longest);
    }
}
