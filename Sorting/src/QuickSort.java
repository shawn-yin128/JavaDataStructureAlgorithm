public class QuickSort {
    public static void main(String[] args) {
        int[] array1 = null;
        int[] array2 = new int[] {};
        int[] array3 = new int[] {3, 1, 5, 2, 6, 78, 0, 2, 17};
        int[] res1 = quickSort(array1);
        System.out.println(res1);
        int[] res2 = quickSort(array2);
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i]);
        }
        int[] res3 = quickSort(array3);
        for (int i = 0; i < res3.length; i++) {
            System.out.print(res3[i]+" ");
        }
    }
    public static int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) { // because of pivotIndex + 1 so left may be larger than right
            return;
        }
        int pivotIndex = partition(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }
    public static int partition(int[] array, int left, int right) { // return the pivot position
        int pivotIndex = pivotIndex(left, right);
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivotValue) {
                leftBound++;
            } else if (array[rightBound] >= pivotValue) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }
    public static int pivotIndex(int left, int right) { // left and right stands for the range of array
        return left + (int)(Math.random()*(right - left + 1));
    }
    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

/**
 * time complexity: average case O(nlogn) worst case O(n^2)
 * space complexity: average case O(logn), worst case O(n)
 */
