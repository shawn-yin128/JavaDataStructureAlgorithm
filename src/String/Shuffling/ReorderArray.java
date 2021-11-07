package Shuffling;

/**
 * Given an array of elements, reorder it as follows:
 * { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
 * { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
 * Try to do it in place.
 */
public class ReorderArray {
    public String reorder(String input) {
        if (input == null) {
            return input;
        }
        char[] array = input.toCharArray();
        if (array.length % 2 == 0) {
            helper(array, 0, array.length - 1);
        } else {
            helper(array, 0, array.length - 2);
        }
        return new String(array);
    }

    private void helper(char[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int size = right - left + 1;
        int mid = left + size / 2;
        int lmid = left + size / 4;
        int rmid = left + size * 3 / 4;
        reverse(array, lmid, mid - 1);
        reverse(array, mid, rmid - 1);
        reverse(array, lmid, rmid - 1);
        helper(array, left, left + 2 * (lmid - left) - 1);
        helper(array, left + 2 * (lmid - left), right);
    }

    public void reverse(char[] array, int left, int right) {
        while (left < right) {
            swap(array, left++, right--);
        }
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(n)
 */