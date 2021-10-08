public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[] {3, 2, 1, 9, 6, 8};
        int[] res = mergeSort(array);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }
    public static int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        return mergeSort(array, 0, array.length - 1);
    }
    public static int[] mergeSort(int[] array, int left, int right) {
        if (left == right) {
            return new int[] {array[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftArray = mergeSort(array, left, mid);
        int[] rightArray = mergeSort(array, mid + 1, right);
        return merge(leftArray, rightArray);
    }
    public static int[] merge(int[] leftArray, int[] rightArray) {
        int[] res = new int[leftArray.length + rightArray.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resIndex = 0;
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                res[resIndex++] = leftArray[leftIndex++];
            } else {
                res[resIndex++] = rightArray[rightIndex++];
            }
        }
        while (leftIndex < leftArray.length) {
            res[resIndex++] = leftArray[leftIndex++];
        }
        while (rightIndex < rightArray.length) {
            res[resIndex++] = rightArray[rightIndex++];
        }
        return res;
    }
}
