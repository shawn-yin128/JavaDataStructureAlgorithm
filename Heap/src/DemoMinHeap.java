import java.util.Arrays;
import java.util.NoSuchElementException;

public class DemoMinHeap {
    private int[] array;
    private int size; // max is array.length and size - 1 is the index for last element

    public DemoMinHeap(int[] array) {
        if (array == null || array.length <= 1) {
            throw new IllegalArgumentException("input array cannot be null, empty or 1.");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    public DemoMinHeap(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size cannot be 0 or negative.");
        }
        array = new int[size];
        this.size = 0;
    }

    public void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) { // size / 2 - 1 is the last parent node
            percolateDown(i);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (array[parentIndex] > array[index]) {
                swap(parentIndex, index);
            } else {
                break;
            }
            index = parentIndex;
        }
    }

    private void percolateDown(int index) {
        while (index < size / 2 - 1) {
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;
            int swapCandidate = leftChild; // just candidate may not swap
            if (rightChild <= size - 1 && array[leftChild] > array[rightChild]) { // when right child exist and right child is smaller one
                swapCandidate = rightChild;
            }
            if (array[index] > array[swapCandidate]) { // when swap is necessary
                swap(index, swapCandidate);
                index = swapCandidate;
            } else {
                break;
            }
        }
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty.");
        }
        return array[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty.");
        }
        int result = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return result;
    }

    public void offer(int num) {
        if (size == array.length) {
            array = Arrays.copyOf(array, (int)(array.length * 1.5));
        }
        array[size] = num;
        size++;
        percolateUp(size - 1);
    }

    public int update(int index, int num) { // return the original value
        if (index < 0 || index > size - 1) { // size - 1 is the current last element position
            throw new ArrayIndexOutOfBoundsException("invalid index.");
        }
        int result = array[index];
        array[index] = num;
        if (num > result) {
            percolateDown(index);
        } else {
            percolateUp(index);
        }
        return result;
    }

    private void swap(int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
