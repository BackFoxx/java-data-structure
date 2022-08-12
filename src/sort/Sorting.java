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

    public void mergeSort() {
        int[] B = new int[A.length];
        mSort(0, A.length-1, B);
    }

    private void mSort(int p, int r, int[] B) {
        if (p < r) {
            int q = (p + r) / 2;
            mSort(p, q, B);
            mSort(q + 1, r, B);
            merge(p, q, r, B);
        }
    }

    private void merge(int p, int q, int r, int[] B) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) B[t++] = A[i++];
            else B[t++] = A[j++];
        }
        while (i <= q) {
            B[t++] = A[i++];
        }
        while (j <= r) {
            B[t++] = A[j++];
        }
        i = p;
        t = 0;
        while (i <= r) {
            A[i++] = B[t++];
        }
    }

    public void quickSort() {
        qSort(0, A.length - 1);
    }

    private void qSort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            qSort(p, q - 1);
            qSort(q + 1, r);
        }
    }

    private int partition(int p, int r) {
        int x = A[r]; // 끝 원소
        int i = p - 1; // ?
        int tmp;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {
                i++;
                tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        tmp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = tmp;
        return i + 1;
    }

    public void heapSort() {
        buildHeap();
        int tmp;
        for (int i = A.length - 1; i >= 1; i--) {
            tmp = A[i];
            A[i] = A[0];
            A[0] = tmp;
            percolateDown(0, i - 1);
        }
    }

    public void buildHeap() {
        if (A.length >= 2) {
            for (int i = (A.length - 2) / 2; i >= 0; --i) {
                percolateDown(i, A.length - 1);
            }
        }
    }

    private void percolateDown(int i, int n) {
        int child = 2 * i + 1;
        int right = 2 * i + 2;
        if (child <= n) {
            if (right <= n && A[child] < A[right]) {
                child = right;
            }
            if (A[i] < A[child]) {
                int tmp = A[i];
                A[i] = A[child];
                A[child] = tmp;
                percolateDown(child, n);
            }
        }
    }

    public void shellSort() {
        for (int h = A.length / 7; h > 5; h = h / 5 - 1) {
            for (int k = 0; k < h - 1; k++) {
                stepInsertionSort(k, h);
            }
        }
        stepInsertionSort(0, 1);
    }

    public int[] countingSort(int K) {
        int[] cnt = new int[K];
        for (int i = 0; i < K; i++) {
            cnt[i] = 0;
        }
        for (int i = 0; i < A.length; i++) {
            cnt[A[i]]++;
        }
        cnt[0]--;

        for (int i = 1; i < K; i++) {
            cnt[i] += cnt[i - 1];
        }

        int[] B = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            B[cnt[A[i]]] = A[i];
            cnt[A[i]]--;
        }

        return B;
    }

    public void radixSort() {
        int[] cnt = new int[10];
        int[] start = new int[10];
        int[] B = new int[A.length];
        int max = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        int numDigits = (int)Math. log10(max) + 1;
        for(int digit = 1; digit <= numDigits; digit++) {
            for(int d = 0; d <= 9; d++)
                cnt[d] = 0;
            for(int i = 0; i < A.length; i++)
                cnt[(int)(A[i]/Math.pow(10, digit-1) % 10)]++;
            start[0] = 0;
            for(int d = 1; d <= 9; d++)
                start[d] = start[d-1] + cnt[d-1];
            for(int i = 0; i < A.length; i++)
                B[start[(int)(A[i]/Math.pow(10, digit-1)) % 10]++] = A[i];
            for(int i = 0; i < A.length; i++)
                A[i] = B[i];
        }
    }

    private void stepInsertionSort(int k, int h) {
        int j, insItem;
        for (int i = k + h; i < A.length - 1; i += h) {
            insItem = A[i];
            for (j = i - h; j >= 0 && A[j] > insItem; j -= h) {
                A[j + h] = A[j];
            }
            A[j + h] = insItem;
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
