package Algorithm.DynamicProgramming.TwoDArray;

/**
 * Find the length of longest common subsequence of two given strings.
 */
public class LongestCommonSubsequence {
    public int longest(String source, String target) {
        if (source == null || source.length() == 0) {
            return 0;
        }
        if (target == null || target.length() == 0) {
            return 0;
        }
        char[] sa = source.toCharArray();
        char[] ta = target.toCharArray();
        int[][] common = new int[sa.length][ta.length];
        for (int i = 0; i < sa.length; i++) {
            for (int j = 0; j < ta.length; j++) {
                if (sa[i] == ta[j]) {
                    if (i == 0 || j == 0) {
                        common[i][j] = 1;
                    } else {
                        common[i][j] = common[i - 1][j - 1] + 1;
                    }
                } else {
                    if (i == 0 && j == 0) {
                        common[i][j] = 0;
                    } else if (j == 0) {
                        common[i][j] = common[i - 1][j];
                    } else if (i == 0) {
                        common[i][j] = common[i][j - 1];
                    } else {
                        common[i][j] = Math.max(common[i - 1][j], common[i][j - 1]);
                    }
                }
            }
        }
        return common[sa.length - 1][ta.length - 1];
    }
}
