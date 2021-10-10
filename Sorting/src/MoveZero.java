/**
 * input an array, move all zero to right side
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] array = new int[] {0, 9, 8, 1, 0, 0, 2, 4, 0, 6};
        array = moveZero(array);
        for (int i =  0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    public static int[] moveZero(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int leftBound = 0;
        int rightBound = array.length - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] != 0) {
                leftBound++;
            } else if (array[rightBound] == 0) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        return array;
    }
}

/**
 * time complexity: O(n)
 * space complexity: O(1)
 */