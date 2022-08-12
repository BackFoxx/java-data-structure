package src.sort;

public class Sorting<A> {
    int A[];

    public Sorting(int[] B) {
        A = B;
    }

    public void selectionSort() {
        for (int i = A.length - 1; i >= 1; i--) {
            int largest = theLargestIndex(A, i);
            int tmp = A[i];
            A[i] = A[largest];
            A[largest] = tmp;
        }
    }

    private int theLargestIndex(int[] a, int last) {
        int largest = 0;
        for (int i = 0; i <= last; i++) {
            if (a[i] > a[largest]) {
                largest = i;
            }
        }
        return largest;
    }

    public void bubbleSort() {
        for (int i = A.length - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                }
            }
        }
    }

    public void insertionSort() {
        for (int i = 1; i <= A.length - 1; i++) {
            int index = i - 1;
            while (0 <= index && A[index] > A[index + 1]) {
                int tmp = A[index + 1];
                A[index + 1] = A[index];
                A[index] = tmp;
                index--;
            }
        }
    }

    @Override
    public String toString() {
        for (int i : A) {
            System.out.print(i + " , ");
        }
        System.out.println();
        return null;
    }
}
