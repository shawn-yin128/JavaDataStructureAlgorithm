package Algorithm.GraphSearch.DepthFirstSearch.Permutation;

/**
 * Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ...., k - 1, k - 1, k, k],
 * such that the output integer array satisfy this condition:
 * Between each two i's, they are exactly i integers
 * (for example: between the two 1s, there is one number, between the two 2's there are two numbers).
 * If there does not exist such sequence, return null.
 */
public class IdenticalElementDistance {
    public int[] distance(int k) {
        int[] array = new int[2 * k];
        for (int i = 0; i < k; i++) {
            array[2 * i] = i + 1;
            array[2 * i + 1] = i + 1;
        }
        boolean[] used = new boolean[k + 1];
        return helper(array, 0, used) ? array : null;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private boolean helper(int[] array, int index, boolean[] used) {
        if (index == array.length) {
            return true;
        }
        for (int i = index; i < array.length; i++) {
            int cur = array[i];
            if (!used[cur] || (index > cur && array[index - cur - 1] == cur)) {
                swap(array, index, i);
                used[cur] = !used[cur];
                if (helper(array, index + 1, used)) {
                    return true;
                }
                swap(array, index, i);
                used[cur] = !used[cur];
            }
        }
        return false;
    }
}

/**
 * time complexity: o(n!)
 * space complexity: O(n)
 */