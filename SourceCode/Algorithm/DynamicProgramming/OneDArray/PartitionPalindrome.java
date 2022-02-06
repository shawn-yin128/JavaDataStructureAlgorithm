package Algorithm.DynamicProgramming.OneDArray;

/**
 * Given a string, a partitioning of the string is a palindrome partitioning if every partition is a palindrome.
 * minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are “a | babbbab | b | ababa”.
 */
public class PartitionPalindrome {
    public int minCutPalindrome(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int[] cut = new int[input.length() + 1];
        cut[0] = 0;
        cut[1] = 0;
        for (int i = 2; i < cut.length; i++) {
            cut[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    if (isPalindrome(input.substring(j, i))) {
                        cut[i] = 0;
                        break;
                    }
                } else {
                    if (isPalindrome(input.substring(j, i))) {
                        cut[i] = Math.min(cut[i], cut[j] + 1);
                    }
                }
            }
        }
        return cut[cut.length - 1];
    }

    private boolean isPalindrome(String input) {
        char[] array = input.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
