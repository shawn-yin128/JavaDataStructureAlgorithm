package Classical;

/**
 * input unknown size dict, target
 * find target or return -1
 */
public class SearchInUnknownSizeDict {
    private abstract static class Dictionary {
        public abstract Integer get(int index);
    }
    public static int searchInUnknownSizeDict(Dictionary dict, int target) {
        if (dict == null) {
            return -1;
        }
        int left = 0;
        int right = 1;
        while (dict.get(right) != null && dict.get(right) < target) {
            left = right;
            right = right * 2;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dict.get(mid) > target || dict.get(mid) == null) {
                right = mid - 1;
            } else if (dict.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

/**
 * time complexity: O(logn)
 * space complexity: O(1)
 */