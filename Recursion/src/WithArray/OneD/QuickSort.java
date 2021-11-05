package WithArray.OneD;

public interface QuickSort {
    int[] quickSort(int[] array);
    void quickSort(int[] array, int left, int right);
    int pivot(int left, int right);
    int partition(int[] array, int left, int right);
    void swap(int[] array, int left, int right);
}
