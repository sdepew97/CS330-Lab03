//Import Statements
import java.util.Random;
import java.util.Arrays;

public class Lab03 {
    //global variable for the cutoff value
    public static int cutoff = 25;

    public static void main(String[] args) {

//        int arraySize = 1000000;
//        int arraySize = 6000000;
//        int arraySize = 11000000;
//        int arraySize = 16000000;
//        int arraySize = 21000000;
//        int arraySize = 26000000;
        int arraySize = 31000000;
//        int arraySize = 36000000;
//        int arraySize = 41000000;
//        int arraySize = 46000000;
//        int arraySize = 51000000;


        int[] A = new int[arraySize];
        long start;
        double duration;

        //Initialize Array
        initialize(A, arraySize);

        //Shuffle Array Randomly
        FisherYatesShuffle(A, arraySize);
        /*
        start = System.nanoTime();
        quicksort(A, 0, arraySize - 1);
        duration = (System.nanoTime() - start) / 1000000.0; //duration is in miliseconds
        System.out.println("Size: " + arraySize + ", Duration " + duration);
        */

        start = System.nanoTime();
        hybridSort(A, 0, arraySize - 1, arraySize);
        duration = (System.nanoTime() - start) / 1000000.0; //duration is in miliseconds
        System.out.println("Size: " + arraySize + ", Duration " + duration);

        /*
        start = System.nanoTime();
        librarySort(A);
        duration = (System.nanoTime() - start) / 1000000.0; //duration is in miliseconds
        System.out.println("Size: " + arraySize + ", Duration " + duration);
       */
    }

    //Task #1
    private static void initialize(int[] A, int n) {
        for (int i = 0; i < n; i++) {
            A[i] = i;
        }
    }

    private static void FisherYatesShuffle(int[] A, int n) {
        Random random = new Random();
        int j;

        for (int i = 0; i < n - 1; i++) {
            j = random.nextInt(n - i) + i; //get the random number j such that i<=j<n
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    private static void printArray(int[] A, int n) {
        System.out.print("{");
        for (int i = 0; i < n; i++) {
            int valueToPrint = A[i];
            System.out.print(valueToPrint + ", ");
        }
        System.out.println("}");
    }

    //Task #2
    private static void quicksort(int[] A, int left, int right) {
        Random random = new Random();
        int m = left;

        if (left >= right) {
            return;
        }

        //pivot is a random element in A[l]...A[u]
        swap(A, left, random.nextInt(right - left + 1) + left);

        for (int i = left + 1; i <= right; i++) {
            if (A[i] < A[left]) {
                swap(A, ++m, i);
            }
        }

        swap(A, left, m);
        quicksort(A, left, m - 1);
        quicksort(A, m + 1, right);
    }

    private static void swap(int A[], int i, int j) {
        int temp = A[j];
        A[j] = A[i];
        A[i] = temp;
    }

    //Task #3
    private static void insertionSort(int[] A, int n) {
        int key;
        int j;

        for (int i = 1; i < n; i++) {
            key = A[i];
            j = i - 1;

            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }
    }

    //Task #4
    private static void hybridSort(int[] A, int left, int right, int n) {
        quicksort(A, left, right);
        insertionSort(A, n);
    }

    private static void modifiedQuicksort(int[] A, int left, int right) {
        Random random = new Random();
        int m = left;

        if ((right - left) < cutoff) {
            return;
        }

        //pivot is a random element in A[l]...A[u]
        swap(A, left, random.nextInt(right - left + 1) + left);

        for (int i = left + 1; i <= right; i++) {
            if (A[i] < A[left]) {
                swap(A, ++m, i);
            }
        }

        swap(A, left, m);
        modifiedQuicksort(A, left, m - 1);
        modifiedQuicksort(A, m + 1, right);
    }

    //Task #5

    /* (From Java Documentation)
     * Implementation note: The sorting algorithm is a Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch.
     * This algorithm offers O(n log(n)) performance on many data sets that cause other quicksorts to degrade to quadratic performance,
     * and is typically faster than traditional (one-pivot) Quicksort implementations.
     */
    private static void librarySort(int[] A) {
        Arrays.sort(A);
    }
}
