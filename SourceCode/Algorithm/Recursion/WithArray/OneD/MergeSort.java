package Algorithm.Recursion.WithArray.OneD;

public interface MergeSort {
    int[] mergeSort(int[] array);
    int[] mergeSort(int[] array, int left, int right);
    int[] merge(int[] left, int[] right);
}
