package DataStructure.Array.TwoPointers;

/**
 * input an array that contains only -1, 1, 0 in disorder, put them into -1, 0, 1 order
 */
public class Block {
    public static void main(String[] args) {
        int[] array = new int[] {-1, 0, 1, 0, 0, -1, -1, -1, 1, 0, 0};
        int[] res = blockSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(res[i]);
        }
    }
    public static int[] blockSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int left = 0;
        int leftBound = 0;
        int rightBound = array.length - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] == 1) {
                swap(array, leftBound, rightBound--);
            } else if (array[leftBound] == -1) {
                swap(array, left++, leftBound++);
            } else {
                leftBound++;
            }
        }
        return array;
    }
    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */
