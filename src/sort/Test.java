package src.sort;

public class Test {
    public static void main(String[] args) {
        int[] testArray = new int[]{3, 31, 48, 73, 8, 1, 20, 29, 65, 15};
        Sorting<Object> sorting = new Sorting<>(testArray);

        sorting.toString();
//        sorting.selectionSort();
        sorting.bubbleSort();
        sorting.toString();
    }
}
