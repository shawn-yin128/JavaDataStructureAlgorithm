package Basic;

/**
 * input array
 * output sorted array
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] array1 = new int[] {};
        int[] array2 = new int[] {1};
        int[] array3 = new int[] {2, 1, 7, 3, 5};
        int[] array4 = null;
        int[] res1 = selectionSort(array1);
        int[] res2 = selectionSort(array2);
        int[] res3 = selectionSort(array3);
        int[] res4 = selectionSort(array4);
        for (int i = 0; i <= res3.length - 1; i++) {
            System.out.print(res3[i]);
        }
    }
    public static int[] selectionSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int localMinIndex = i;
            int localMin = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < localMin) {
                    localMinIndex = j;
                    localMin = array[j];
                }
            }
            int temp;
            temp = array[localMinIndex];
            array[localMinIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}

/**
 * time complexity: O(n^2)
 * space complexity: O(1)
 */