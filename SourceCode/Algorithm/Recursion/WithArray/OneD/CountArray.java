package Algorithm.Recursion.WithArray.OneD;

/**
 * Given an array A of length N containing all positive integers from [1...N].
 * How to get an array B such that B[i] represents how many elements A[j] (j > i) in array A that are smaller than A[i].
 */
public class CountArray {
    public int[] countArray(int[] array) {
        if (array == null || array.length == 0) {
            return new int[] {};
        }
        int[] indexArray = getIndex(array);
        int[] countArray = new int[array.length];
        int[] indexHelper = new int[array.length];
        mergeSort(array, indexArray, countArray, indexHelper, 0, array.length - 1);
        return countArray;
    }

    private void mergeSort(int[] array, int[] indexArray, int[] countArray, int[] indexHelper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, indexArray, countArray, indexHelper, left, mid);
        mergeSort(array, indexArray, countArray, indexHelper, mid + 1, right);
        merge(array, indexArray, countArray, indexHelper, left, mid, right);
    }

    private void merge(int[] array, int[] indexArray, int[] countArray, int[] indexHelper, int left, int mid, int right) {
        copyIndex(indexArray, indexHelper, left, right);
        int l = left;
        int r = mid + 1;
        int cur = left;
        while (l <= mid) {
            if (r > right || array[indexHelper[l]] <= array[indexHelper[r]]) { // equal is ok because we only count right elements that are smaller than left
                countArray[indexHelper[l]] += (r - mid - 1);
                indexArray[cur++] = indexHelper[l++];
            } else {
                indexArray[cur++] = indexHelper[r++];
            }
        }
    }

    private void copyIndex(int[] indexArray, int[] indexHelper, int left, int right) {
        for (int i = left; i <= right; i++) {
            indexHelper[i] = indexArray[i];
        }
    }

    private int[] getIndex(int[] array) {
        int[] index = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            index[i] = i;
        }
        return index;
    }
}

/**
 * time complexity: O(nlogn)
 * space complexity: O(n)
 */