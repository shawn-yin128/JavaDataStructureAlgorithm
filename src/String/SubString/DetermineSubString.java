package SubString;

/**
 * Determine if a small string is a substring of another large string.
 * Return the index of the first occurrence of the small string in the large string.
 */
public class DetermineSubString {
    public int subString(String large, String small) {
        for (int i = 0; i < large.length() - small.length(); i++) {
            int j = 0; // index of small
            while (j < small.length() && large.charAt(i + j) == small.charAt(j)) {
                j++;
            }
            if (j == small.length()) {
                return i;
            }
        }
        return -1;
    }
}
/**
 * time complexity: O((m - n) * n) m-n iteration for each one n times iteration, m and n stands for length of large and small
 * space complexity: O(1)
 */
