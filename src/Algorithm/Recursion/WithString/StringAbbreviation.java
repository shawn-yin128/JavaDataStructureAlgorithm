package Algorithm.Recursion.WithString;

public class StringAbbreviation {
    public boolean match(String input, String pattern) {
        return match(input, pattern, 0, 0);
    }

    public boolean match(String input, String pattern, int i, int p) {
        if (i == input.length() && p == pattern.length()) {
            return true;
        }
        if (i >= input.length() || p >= pattern.length()) {
            return false;
        }
        if (pattern.charAt(p) < '0' || pattern.charAt(p) > '9') {
            if (input.charAt(i) == pattern.charAt(p)) {
                return match(input, pattern, ++i, ++p);
            }
            return false;
        }
        int count = 0;
        while (p < pattern.length() && pattern.charAt(p) >= '0' && pattern.charAt(p) <= '9') {
            count = count * 10 + (pattern.charAt(p) - '0');
            p++;
        }
        return match(input, pattern, i + count, p);
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */