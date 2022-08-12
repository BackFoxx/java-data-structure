package src.sort;

public class Test {
    public static void main(String[] args) {
        int[] testArray = new int[]{3, 31, 48, 73, 8, 1, 20, 29, 65, 15};
//        int[] testArray = new int[]{8839, 1111, 3454, 3464, 1123};
        Sorting<Object> sorting = new Sorting<>(testArray);

        sorting.toString();
//        sorting.selectionSort();
//        sorting.bubbleSort();
//        sorting.insertionSort();
//        sorting.mergeSort();
//        sorting.quickSort();
//        sorting.heapSort();
//        sorting.shellSort();
//        sorting.countingSort(65);
        sorting.radixSort();
        sorting.toString();
    }
}
